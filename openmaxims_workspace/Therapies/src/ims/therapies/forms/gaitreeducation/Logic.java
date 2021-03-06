//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.40 build 2194.25473)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.gaitreeducation;

import java.util.ArrayList;

import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.PersonName;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.spinalinjuries.vo.lookups.GaitReEducationGaitAspect;
import ims.spinalinjuries.vo.lookups.GaitReEducationGaitAspectCollection;
import ims.spinalinjuries.vo.lookups.LookupHelper;
import ims.therapies.vo.GaitReEducationVo;
import ims.therapies.vo.GaitReEducationVoCollection;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		form.getLocalContext().setGaitEducation(null);
		open();
	}
	private void open()
	{
		clearControls();
		GaitReEducationVoCollection voGaitColl = null;
		form.getLocalContext().setUpdateCurrentRecord(new Boolean(false));
		form.setMode(FormMode.VIEW);
		form.gridGait().getRows().clear();
		prePopulateGaitGrd();
		
		if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			voGaitColl = domain.listGaitReeducation(form.getGlobalContext().Core.getCurrentCareContext());
		
		if(voGaitColl != null)
		{
			populateGaitGrd(voGaitColl);
			isRecordCurrent();
		}
	
		disableButtonsForRecord();
		updateContextMenu();
	}

	private void isRecordCurrent()
	{
		ClinicalContactShortVo voCurrent = null;
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			voCurrent = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		for(int i = 0 ; i < form.gridGait().getRows().size() ; i++)
		{
			GaitReEducationVo voGait = form.gridGait().getRows().get(i).getValue();
			if(voCurrent != null && voGait.getClinicalContact() != null)
			{
				if(voGait.getClinicalContact().getID_ClinicalContact().equals(voCurrent.getID_ClinicalContact()))
				{
					form.getLocalContext().setUpdateCurrentRecord(new Boolean(true));
					//set colour of current record + set it expanded
					GenForm.gridGaitRow currentRow = form.gridGait().getRows().get(i);
					currentRow.setBackColor(Color.Beige);
					currentRow.setExpanded(true);
					form.gridGait().setValue(voGait);
				}
			}
			populateControls(voGait);
		}
	}

	private void disableButtonsForRecord()
	{
		//depending on the record selected - allow update or not
		if(form.getLocalContext().getUpdateCurrentRecordIsNotNull() && form.getMode().equals(FormMode.VIEW))
		{
			if(form.getLocalContext().getUpdateCurrentRecord().booleanValue())
			{
				form.btnNew().setVisible(false);
				form.btnUpdate().setVisible(true);   
				form.btnNew().setEnabled(false);				//allow update
				form.btnUpdate().setEnabled(true);
				form.getLocalContext().setGaitEducation(form.gridGait().getValue());
			}
			else
			{
				form.btnNew().setVisible(true);
				form.btnUpdate().setVisible(false);
				form.btnNew().setEnabled(true);
				form.btnUpdate().setEnabled(false);
			}
		}
		
		if(form.getGlobalContext().Core.getCurrentClinicalContact() == null)
		{
			form.btnNew().setVisible(false);
			form.btnUpdate().setVisible(false);
		}
		
	}
	private void prePopulateGaitGrd()
	{
		GenForm.grdGaitAspectRow row = null;
		form.grdGaitAspect().getRows().clear();
		GaitReEducationGaitAspectCollection gaitColl = LookupHelper.getGaitReEducationGaitAspect(domain.getLookupService());
		
		for (int i = 0; i < gaitColl.size(); i++)
		{
			GaitReEducationGaitAspect aspect = gaitColl.get(i);
			row = form.grdGaitAspect().getRows().newRow();
			row.setValue(aspect);
			row.setColGaitAspect(aspect.getText());
		}
	}

	private void populateGaitGrd(GaitReEducationVoCollection voGaitColl)
	{
		GaitReEducationGaitAspectCollection aspColl = null;
		for(int i =0; i<voGaitColl.size(); i++)
		{
			GaitReEducationVo voGait = voGaitColl.get(i);
			GenForm.gridGaitRow pRow = form.gridGait().getRows().newRow();
			
			//fix WDEV-2255
			if (voGait.getAuthoringDateTimeIsNotNull())
				pRow.setColDate(voGait.getAuthoringDateTime().toString());
			if (voGait.getAuthoringCPIsNotNull())
				pRow.setColHCP(voGait.getAuthoringCP().toString());
			if(voGait.getDetailsIsNotNull())
				pRow.setColDetails(voGait.getDetails());
			
			//display children
			if(voGait.getGaitAspect() != null)
			{
				aspColl = voGait.getGaitAspect();
			
				String gait = "";
				for(int z=0; z<aspColl.size(); z++)
				{
					//fix WDEV-2255
					GaitReEducationGaitAspect aspect = aspColl.get(z);
					gait+=aspect.toString()+"\n";
				}
				pRow.setColGait(gait);
			}
			
			pRow.setValue(voGait);	

		}		
	}
	private void populateControls(GaitReEducationVo voGait)
	{
		form.qmbAuthoringCP().newRow(voGait.getAuthoringCP(), voGait.getAuthoringCP().toString());
		form.qmbAuthoringCP().setValue(voGait.getAuthoringCP());
		form.dtimAuthoring().setValue(voGait.getAuthoringDateTime());
		form.txtDetails().setValue(voGait.getDetails());
		
		if(voGait.getGaitAspect() != null)
			populateGaitGrid(voGait.getGaitAspect());
	}
	private void populateGaitGrid(GaitReEducationGaitAspectCollection gaitAspectColl)
	{
		GenForm.grdGaitAspectRow aRow;
		//Clear all ticks in the grid first
		for (int x = 0 ; x < form.grdGaitAspect().getRows().size() ; x++)
			form.grdGaitAspect().getRows().get(x).setColSelectedDetails(false);
		
		for (int i = 0 ; i < gaitAspectColl.size() ; i++)
		{
			GaitReEducationGaitAspect aspect = gaitAspectColl.get(i);
			aRow = form.grdGaitAspect().getRowByValue(aspect);
			if (aRow != null)
				aRow.setColSelectedDetails(true);
			else
			{
				aRow = form.grdGaitAspect().getRows().newRow();
				aRow.setValue(aspect);
				aRow.setColSelectedDetails(true);	
			}
		}
	}
	private void clearControls()
	{
		form.dtimAuthoring().setValue(null);
		form.qmbAuthoringCP().setValue(null);
		form.txtDetails().setValue(null);
	}
	
	private String[] getUiErrors() 
	{
		ArrayList<String> errors = new ArrayList<String>();
		boolean bFound = false;
		if (form.txtDetails().getValue() == null)
		{
			if (form.grdGaitAspect().getRows().size() > 0)
			{
				for (int i = 0; i < form.grdGaitAspect().getRows().size(); i++)
				{
					if (form.grdGaitAspect().getRows().get(i).getColSelectedDetails() == true)
					{
						bFound = true;
						break;
					}
				}
				
				if (bFound == false)
				{
					errors.add("Details or Gait is mandatory!");
				}
			}
			
		}
			
		if(errors.size() > 0)
		{
			String[] searchErrors = new String[errors.size()];
			errors.toArray(searchErrors);
			return searchErrors;
		}
		
		return null;
	}
	
	protected void onBtnSaveClick() throws PresentationLogicException
	{
		GaitReEducationVo voGait = form.getLocalContext().getGaitEducation();
		if(voGait == null)
			voGait = new GaitReEducationVo();
		voGait.setAuthoringCP(form.qmbAuthoringCP().getValue());
		voGait.setAuthoringDateTime(form.dtimAuthoring().getValue());

		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			voGait.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());

		voGait.setDetails(form.txtDetails().getValue());
		
		voGait.setGaitAspect(populateDataFromGrdAspect());
		
		String[] uiErrors = getUiErrors();	
		String[] message = voGait.validate(uiErrors);
		if (message != null)
		{
			engine.showErrors("Validation errors", message);
			return;
		}
		
		try
		{
			domain.saveGaitReEducation(voGait);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage("A Gait Re-Education record already exists. " + e.getMessage());
			open();
			return;
		}
	
		open();
	}
	private GaitReEducationGaitAspectCollection populateDataFromGrdAspect()
	{
		GaitReEducationGaitAspectCollection gaitColl = new GaitReEducationGaitAspectCollection();
		for(int x=0; x<form.grdGaitAspect().getRows().size(); x++)
		{
			GenForm.grdGaitAspectRow row = form.grdGaitAspect().getRows().get(x);
			if(row.getColSelectedDetails())
				gaitColl.add(row.getValue());
		}
		return gaitColl;
	}
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		clearControls();
		form.setMode(FormMode.VIEW);
		open();
	}
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				menuNew();
				break;
			case GenForm.ContextMenus.GenericGrid.Update:
				menuUpdate();
				break;
		}
	}
	private void menuUpdate()
	{
		updateRecord();
	}
	protected void onBtnUpdateClick() throws PresentationLogicException
	{
		updateRecord();
	}
	private void updateRecord()
	{
		form.setMode(FormMode.EDIT);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
		form.getContextMenus().getGenericGridAddItem().setVisible(false);
		form.getLocalContext().setGaitEducation(form.gridGait().getValue()); //only a tree node can be selected
	}
	private void menuNew()
	{
		newRecord();
	}
	protected void onBtnNewClick() throws PresentationLogicException
	{
		newRecord();	
	}
	private void newRecord()
	{
		form.setMode(FormMode.EDIT);
		clearControls();
		prePopulateGaitGrd();		
		prePopulateControls();
		
		form.getLocalContext().setGaitEducation(null);
	
		updateContextMenu();
		form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
		form.getContextMenus().getGenericGridAddItem().setVisible(false);
	}
	private void prePopulateControls()
	{
		form.dtimAuthoring().setValue(new DateTime()); 
		
		Hcp voHcp = (Hcp) domain.getHcpUser();
		if(voHcp != null)
		{
			form.qmbAuthoringCP().newRow(voHcp, voHcp.toString());
			form.qmbAuthoringCP().setValue(voHcp);
		}
	}
	
	private void updateContextMenu()
	{
		if(form.getLocalContext().getUpdateCurrentRecord().booleanValue())
		{
			form.getContextMenus().getGenericGridUpdateItem().setVisible(form.getMode().equals(FormMode.VIEW));
		}
		else
		{
			form.getContextMenus().getGenericGridAddItem().setText("New");
			form.getContextMenus().getGenericGridAddItem().setVisible(form.getMode().equals(FormMode.VIEW)&& form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull());
		}
		
		form.getContextMenus().getGenericGridRemoveItem().setVisible(false);
		form.getContextMenus().getGenericGridMoveDownItem().setVisible(false);
		form.getContextMenus().getGenericGridMoveUpItem().setVisible(false);
		form.getContextMenus().getGenericGridViewItem().setVisible(false);
	}
	protected void onQmbAuthoringCPTextSubmited(String value) throws PresentationLogicException
	{
		form.qmbAuthoringCP().clear();
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);
		
		HcpCollection coll = domain.listHCPs(filter);
		for (int i = 0; i < coll.size(); i++)
		{
			Hcp med = coll.get(i);
			form.qmbAuthoringCP().newRow(med, med.toString());			
		}
		
		if (coll.size() == 1)
			form.qmbAuthoringCP().setValue(coll.get(0));
		else if (coll.size() > 1)
			form.qmbAuthoringCP().showOpened();	
		
	}
	protected void onGridGaitSelectionChanged() throws PresentationLogicException
	{
		populateControls(form.gridGait().getSelectedRow().getValue());
		ClinicalContactShortVo voClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		GaitReEducationVo voGait = form.gridGait().getSelectedRow().getValue();
		if(voClinicalContact != null && voGait != null && voGait.getClinicalContactIsNotNull() && voGait.getClinicalContact().equals(voClinicalContact))
		{
			updateContextMenu();
			form.btnUpdate().setVisible(true);
		}
		else
		{
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
			form.getContextMenus().getGenericGridRemoveItem().setVisible(false);
			form.getContextMenus().getGenericGridMoveDownItem().setVisible(false);
			form.getContextMenus().getGenericGridMoveUpItem().setVisible(false);
			form.getContextMenus().getGenericGridViewItem().setVisible(false);

			form.btnUpdate().setVisible(false);
		}
	}
}
