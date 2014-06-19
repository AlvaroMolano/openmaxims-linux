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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.65 build 3195.25608)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.hrgconfiguration;

import ims.core.forms.hrgconfiguration.GenForm.grdListGrid;
import ims.core.forms.hrgconfiguration.GenForm.grdListRow;
import ims.core.vo.HrgConfigLiteVo;
import ims.core.vo.HrgConfigLiteVoCollection;
import ims.core.vo.HrgConfigVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.FormOpenException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// Initialize form
		initialize();
		open();
	}
	
	@Override
	protected void onFormModeChanged()
	{
		form.ctnDetails().ccTaxonomy().setComponentMode(form.getMode());
		
		// Update form state
		updateControlsState();
	}
	
	@Override
	protected void onGrdListSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		// Set local context
		form.getLocalContext().setHRGConfiguration(domain.getHRGConfiguration(form.grdList().getValue()));
		// Set details
		populateScreenFromData(form.getLocalContext().getHRGConfiguration());
		
		// Update form state		
		updateControlsState();
	}
	
	@Override
	protected void onGrdListSelectionCleared() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear local context
		form.getLocalContext().setHRGConfiguration(null);
		// Clear details
		populateScreenFromData(null);
		updateControlsState();
	}
	
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}
	
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Attempt to save and list all the HRG Configuration
		if (save())
			open();
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Reset the form
		open();
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.LIP.New:
				newInstance();
				break;
				
			case GenForm.ContextMenus.LIP.Update:
				updateInstance();
				break;
		}
	}
	
	@Override
	public void initialize() throws FormOpenException
	{
		// Call the function in BaseLogic
		super.initialize();
		
		// Initialize the component
		form.ctnDetails().ccTaxonomy().initialize();
		
		// Initialize the local context
		form.getLocalContext().setHRGConfiguration(null);
	}
	
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		// Fill the grid
		setHrgGrid(form.grdList(), domain.listHRGConfiguration());
		// Reselect the VO (get from domain)
		form.getLocalContext().setHRGConfiguration(domain.getHRGConfiguration(form.getLocalContext().getHRGConfiguration()));
		form.grdList().setValue(form.getLocalContext().getHRGConfiguration());
		// Set the details
		populateScreenFromData(form.getLocalContext().getHRGConfiguration());
		
		// Set the form in VIEW mode
		form.setMode(FormMode.VIEW);
	}
	
	public void clearInstanceControls()
	{
		// Clear the container
		clearDetails();
	}
	
	private void clearDetails()
	{
		form.ctnDetails().txtHRGCode().setValue(null);
		form.ctnDetails().txtHRGDescription().setValue(null);
		form.ctnDetails().intPricePounds().setValue(null);
		form.ctnDetails().intPricePence().setValue(null);
		form.ctnDetails().ccTaxonomy().setValue(null);
	}

	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear local context
		form.getLocalContext().setHRGConfiguration(null);
		// Clear the container
		populateScreenFromData(null);
		// Set the form in edit mode
		form.setMode(FormMode.EDIT);
	}
	
	public void updateInstance()
	{
		// Update the local context
		form.getLocalContext().setHRGConfiguration(domain.getHRGConfiguration(form.grdList().getValue()));
		// Set the details
		populateScreenFromData(form.getLocalContext().getHRGConfiguration());
		// Set the form in edit mode
		form.setMode(FormMode.EDIT);
	}

	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		// Get the data from the container
		HrgConfigVo hrgConfiguration = populateDataFromScreen(form.getLocalContext().getHRGConfiguration());
		
		// Validate the HRG Configuration
		String[] validationErrors = hrgConfiguration.validate();
		if (validationErrors != null && validationErrors.length > 0)
		{
			engine.showErrors(validationErrors);
			return false;
		}
		
		// Attempt to save the HRG Configuration
		try
		{
			form.getLocalContext().setHRGConfiguration(domain.saveHRGConfiguration(hrgConfiguration));
		}
		catch (DomainInterfaceException exception)
		{
			engine.showMessage(exception.getMessage(), "Error");//WDEV-12084
			return false;
		}
		catch (StaleObjectException exception)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (ForeignKeyViolationException exception)
		{
			engine.showMessage(exception.getMessage(), "Error");//WDEV-12084
			return false;
		}
		catch (UniqueKeyViolationException exception)
		{
			engine.showMessage(exception.getMessage(), "Error");//WDEV-12084
			return false;
		}

		// In the end return true as the save was successful
		return true;
	}
	
	public void updateControlsState()
	{
		// Container
		form.ctnDetails().setCollapsed(FormMode.VIEW.equals(form.getMode()) && form.grdList().getValue() == null);
		
		// Edit button
		if (FormMode.VIEW.equals(form.getMode()))
		{
			form.btnEdit().setEnabled(form.grdList().getValue() != null); form.btnEdit().setVisible(true);
		}
		
		// Update context menu state
		updateContextMenuState();
	}

	private void updateContextMenuState()
	{
		form.getContextMenus().getLIPNewItem().setVisible(FormMode.VIEW.equals(form.getMode()));
		form.getContextMenus().getLIPUpdateItem().setVisible(FormMode.VIEW.equals(form.getMode()) && form.grdList().getValue() != null);
	}

	private void setHrgGrid(grdListGrid grid, HrgConfigLiteVoCollection listHRGConfiguration)
	{
		// Clear the grid
		grid.getRows().clear();
		
		// Terminate the execution if a null collection
		if (listHRGConfiguration == null)
			return;
		
		// Add a new row for each non null VO in the collection
		for (int i = 0; i < listHRGConfiguration.size(); i++)
		{
			HrgConfigLiteVo hrgConfiguration = listHRGConfiguration.get(i);
			
			// Skip null VOs in the collection
			if (hrgConfiguration == null)
				continue;
			
			// Create the row for the VO
			setGridRow(grid.getRows().newRow(), hrgConfiguration);
		}
	}

	private void setGridRow(grdListRow row, HrgConfigLiteVo hrgConfiguration)
	{
		// Terminate the execution if a null collection
		if (hrgConfiguration == null)
			return;
		
		if (row == null)
			throw new CodingRuntimeException("Major Logical Error - Can not set data to a null row");
		

		// Set up the row with the VO value
		row.setValue(hrgConfiguration);
		
		// Set up the appearance of the row
		row.setColHRGCode(hrgConfiguration.getHRGCode());
		row.setColHRGDescription(hrgConfiguration.getHRGDescription());
		
		String cost = "£ " + (hrgConfiguration.getCostPounds() == null ? "0." : hrgConfiguration.getCostPounds().toString() + ".") + (hrgConfiguration.getCostPence() == null ? "0" : hrgConfiguration.getCostPence().toString());
		row.setColCost(cost);
	}
	
	@Override
	protected HrgConfigVo populateDataFromScreen()
	{
		return populateDataFromScreen(new HrgConfigVo());
	}
	
	@Override
	protected HrgConfigVo populateDataFromScreen(HrgConfigVo value)
	{
		if(value == null)
			value = new HrgConfigVo();

		value.setCostPence(form.ctnDetails().intPricePence().getValue());
		value.setCostPounds(form.ctnDetails().intPricePounds().getValue());
		value.setHRGDescription(form.ctnDetails().txtHRGDescription().getValue());
		value.setHRGCode(form.ctnDetails().txtHRGCode().getValue());
		
		value.setMappings(form.ctnDetails().ccTaxonomy().getValue());
		
		return value;
	}
	
	@Override
	protected void populateScreenFromData(HrgConfigVo value)
	{
		clearDetails();
		if(value == null)
			return;

		form.ctnDetails().intPricePence().setValue(value.getCostPenceIsNotNull() ? value.getCostPence() : null);
		form.ctnDetails().intPricePounds().setValue(value.getCostPoundsIsNotNull() ? value.getCostPounds() : null);
		form.ctnDetails().txtHRGDescription().setValue(value.getHRGDescriptionIsNotNull() ? value.getHRGDescription(): null);
		form.ctnDetails().txtHRGCode().setValue(value.getHRGCodeIsNotNull() ? value.getHRGCode(): null);
		
		form.ctnDetails().ccTaxonomy().setValue(value.getMappingsIsNotNull() ? value.getMappings() : null);
	}
}
