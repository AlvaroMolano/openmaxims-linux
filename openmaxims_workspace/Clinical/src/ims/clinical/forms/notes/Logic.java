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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.notes;

import ims.clinical.vo.HospitalAtNightNotesVo;
import ims.framework.enumerations.DialogResult;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize(args);
		open();
	}
	
	private void open() 
	{
		populateScreenFromData(form.getGlobalContext().Clinical.getHospitalAtNightNotes());
	}

	private void populateScreenFromData(HospitalAtNightNotesVo hospitalAtNightNotes) 
	{
		if(hospitalAtNightNotes == null)
			return;
		
		clearScreen();
		
		form.ccAUthoringHCP().setValue(hospitalAtNightNotes.getAuthoringInformation());
		form.txtNotes().setValue(hospitalAtNightNotes.getNote());
	}

	private void clearScreen() 
	{
		form.ccAUthoringHCP().setValue(null);
		form.txtNotes().setValue(null);
	}

	private void initialize(Object[] args) 
	{
		boolean isRecordActive = false;//	WDEV-13968
		
		if(args != null && args.length > 0)
		{
			isRecordActive = Boolean.TRUE.equals(args[0]);//	WDEV-13968
		}
		
		form.chkRemoveFromList().setEnabled(isRecordActive);//	WDEV-13968
		form.ccAUthoringHCP().setIsRequiredPropertyToControls(true);
		form.ccAUthoringHCP().initializeComponent();
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			engine.close(DialogResult.OK);
	}

	private boolean save() 
	{
		HospitalAtNightNotesVo note = populateDataFromScreen(form.getGlobalContext().Clinical.getHospitalAtNightNotes() != null ? (HospitalAtNightNotesVo) form.getGlobalContext().Clinical.getHospitalAtNightNotes().clone() : null);
		
		String[] errors = note.validate();
		
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		form.getGlobalContext().Clinical.setRemoveFromHospitalAtNight(form.chkRemoveFromList().getValue());
		form.getGlobalContext().Clinical.setHospitalAtNightNotes(note);
		
		return true;
	}

	private HospitalAtNightNotesVo populateDataFromScreen(HospitalAtNightNotesVo hospitalAtNightNotes) 
	{
		if(hospitalAtNightNotes == null)
			hospitalAtNightNotes = new HospitalAtNightNotesVo();
		
		hospitalAtNightNotes.setAuthoringInformation(form.ccAUthoringHCP().getValue());
		hospitalAtNightNotes.setNote(form.txtNotes().getValue());
		
		return hospitalAtNightNotes;
	}
}
