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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4847.21738)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.admin.forms.pacsconfig;

import ims.core.vo.PacsConfigurationVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	private void initialize()
	{
		form.getLocalContext().setPACSConfigVo(null);
	}
	
	@Override
	protected void onBtnShowUrlClick() throws ims.framework.exceptions.PresentationLogicException
	{
		showURL();
	}
	
	private void showURL()
	{
		PacsConfigurationVo record = populateDataFromScreen(form.getLocalContext().getPACSConfigVo());
		
		form.lblURL().setValue(record.getServerAddressIsNotNull() ? record.getURLWithTestAccessionNumber() : "");
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if( save())
			open();

	}
	private boolean save()
	{
		PacsConfigurationVo record = populateDataFromScreen(form.getLocalContext().getPACSConfigVo());
		
		if (form.cmbPACSClientType().getValue() == null)
		{
			engine.showMessage("PACS Client Type is mandatory!");
			return false;
		}
		
		String[] arrErrors = record.validate();
		if (arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setPACSConfigVo(domain.savePACSConfigVo(record));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return true;
		}
		
		showURL();
		return true;
		
	}

	private void open()
	{
		clearScreen();
		PacsConfigurationVo tempVo = domain.getPACSConfigVo();
		form.getLocalContext().setPACSConfigVo(tempVo);
		populateScreenFromData(tempVo);
		showURL();
		form.setMode(FormMode.VIEW);
	}
	
	private void clearScreen()
	{
		form.txtServer().setValue(null);
		form.txtUsername().setValue(null);
		form.txtUsernameString().setValue(null);
		form.txtPassword().setValue(null);
		form.txtPasswordString().setValue(null);
		form.txtAccession().setValue(null);
		form.txtTestAccessionNumber().setValue(null);
	}
	
	private void populateScreenFromData(PacsConfigurationVo tempVo)
	{
		if( tempVo == null )
			return;
		
		form.txtServer().setValue(tempVo.getServerAddress());
		form.txtUsername().setValue(tempVo.getUsername());
		form.txtUsernameString().setValue(tempVo.getUserNameParam());
		form.txtPassword().setValue(tempVo.getPassword());
		form.txtPasswordString().setValue(tempVo.getPasswordParam());
		form.txtAccession().setValue(tempVo.getAccessionParam());
		form.txtTestAccessionNumber().setValue(tempVo.getAccessionTestValue());
		form.cmbPACSClientType().setValue(tempVo.getPACSClientType());		
	}

	private PacsConfigurationVo populateDataFromScreen(PacsConfigurationVo record)
	{
		if( record == null )
			record = new PacsConfigurationVo(); 
		
		record.setServerAddress(form.txtServer().getValue());
		record.setUserNameParam(form.txtUsernameString().getValue());
		record.setUsername(form.txtUsername().getValue());
		record.setPasswordParam(form.txtPasswordString().getValue());
		record.setPassword(form.txtPassword().getValue());
		record.setAccessionParam(form.txtAccession().getValue());
		record.setAccessionTestValue(form.txtTestAccessionNumber().getValue());
		record.setPACSClientType(form.cmbPACSClientType().getValue());

		return record;
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	@Override
	protected void onBtn1Click() throws PresentationLogicException
	{
		form.getGlobalContext().OCRR.CentricityWebPACS.setAccessionNumber(form.txtTestAccessionNumber().getValue());
		engine.open(form.getForms().OCRR.CentricityWebPACSViewer,true,true);
	}
}