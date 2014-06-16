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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.80 build 4198.17562)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.scheduling.forms.sortfixedtheatreappointments;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.scheduling.forms.sortfixedtheatreappointments.GenForm.grdApptsRow;
import ims.scheduling.forms.sortfixedtheatreappointments.GenForm.grdSessionsRow;
import ims.scheduling.helper.SlotGenerationUtils;
import ims.scheduling.vo.Appointment_StatusVo;
import ims.scheduling.vo.BookingAppointmentTheatreVo;
import ims.scheduling.vo.BookingAppointmentTheatreVoCollection;
import ims.scheduling.vo.Booking_AppointmentVo;
import ims.scheduling.vo.Sch_SessionRefVo;
import ims.scheduling.vo.Sch_Session_Appointment_OrderVo;
import ims.scheduling.vo.SessionLiteVo;
import ims.scheduling.vo.SessionLiteVoCollection;
import ims.scheduling.vo.SessionShortVo;
import ims.scheduling.vo.SessionTheatreVo;
import ims.scheduling.vo.lookups.Status_Reason;
import ims.vo.interfaces.IMos;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final int  TCICOLINDEX	= 6;
	private static final long serialVersionUID = 1L;
	private static final int  MOVEDUP	= 1;
	private static final int  MOVEDDOWN	= 2;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	private void initialize()
	{
		//if we have a Session in the context - auto-select it and find the Sch_Session_Appointment_OrderVo record to populate screen
		if(form.getGlobalContext().Scheduling.getTheatreSessionIsNotNull())
		{
			Sch_Session_Appointment_OrderVo voSessionApptOrder = domain.getSessionApptOrderBySession(form.getGlobalContext().Scheduling.getTheatreSession());
			
			if (form.getGlobalContext().Scheduling.getTheatreSession() instanceof SessionTheatreVo)
			{
				SessionTheatreVo theatreSession = (SessionTheatreVo) form.getGlobalContext().Scheduling.getTheatreSession();
				populateSessionDateAndSelectSession(theatreSession.getSessionDate(), theatreSession);
			}
			
			if (form.getGlobalContext().Scheduling.getTheatreSession() instanceof SessionShortVo)
			{
				SessionShortVo shortTheatreSession = (SessionShortVo) form.getGlobalContext().Scheduling.getTheatreSession();
				populateSessionDateAndSelectSession(shortTheatreSession.getSessionDate() , shortTheatreSession);
			}
			
			if(voSessionApptOrder  == null)
			{
				return;
			}
			
			form.getLocalContext().setSessApptOrder(voSessionApptOrder);
			
			//WDEV-13245
			populateAppointmentsBeforeReorderContext(voSessionApptOrder.getAppointments());
			
			if(voSessionApptOrder.getSessionIsNotNull() && voSessionApptOrder.getSession().getSessionDateIsNotNull())
			{
				populateSessionDateAndSelectSession(voSessionApptOrder.getSession().getSessionDate() , voSessionApptOrder.getSession());
			}	
		}
		
		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue()); 
		form.grdAppts().setColHospitalNoCaption(dispIdType.getText());

	}

	private void populateSessionDateAndSelectSession(Date sessionDate, Sch_SessionRefVo id_Sch_Session) 
	{
		form.dteSession().setValue(sessionDate);		
		//Search Sessions and select the row
		searchSessions();
		form.grdSessions().setValue(id_Sch_Session);		
	}

	//	WDEV-13245
	private void populateAppointmentsBeforeReorderContext(BookingAppointmentTheatreVoCollection appointments) 
	{
		if(appointments == null)
		{
			form.getLocalContext().setAppointmentsBeforeReorder(null);
			return;
		}
		
		BookingAppointmentTheatreVoCollection oldAppointments = new BookingAppointmentTheatreVoCollection();
		
		for(BookingAppointmentTheatreVo appt : appointments)
		{
			if(appt == null)
				continue;
			
			oldAppointments.add((BookingAppointmentTheatreVo) appt.clone());
		}
		
		form.getLocalContext().setAppointmentsBeforeReorder(oldAppointments);
	}

	private void open()
	{
		form.getLocalContext().setEditingTimes(false);
		form.setMode(FormMode.VIEW);
		clearInstanceControls();
	
		if(form.grdSessions().getValue() != null)
			grdSessionsSelectionChanged();			
		
		updateControlState();
	}
	
	private void populateScreenFromData(Sch_Session_Appointment_OrderVo voSessionApptOrder)
	{
		if(voSessionApptOrder == null)
			return;
		
		if(voSessionApptOrder.getSessionIsNotNull())
		{
			
			form.txtDate().setValue(voSessionApptOrder.getSession().getSessionDate().toString());
			
			form.txtTheatreDetail().setValue(voSessionApptOrder.getSession().getName());
			if(voSessionApptOrder.getFinalisedByIsNotNull())
				form.txtFinalisedBy().setValue(voSessionApptOrder.getFinalisedBy().toString());
				
			if(voSessionApptOrder.getFinalisedDateTimeIsNotNull())
				form.txtFinalisedDT().setValue(voSessionApptOrder.getFinalisedDateTime().toString());
				
			if(voSessionApptOrder.getSession().getListOwnersIsNotNull())
				form.txtListOwner().setValue(voSessionApptOrder.getSession().getListOwners().toString());
				
			if(voSessionApptOrder.getSession().getTheatreProceduresRemainingIsNotNull() && voSessionApptOrder.getSession().getTheatreProceduresRemaining().getProcedureDetailsIsNotNull()){
				
				form.txtProcedure().setValue(voSessionApptOrder.getSession().getTheatreProceduresRemaining().getProcedureDetails().toString());
				form.txtProcedure().setTooltip(voSessionApptOrder.getSession().getTheatreProceduresRemaining().getProcedureDetails().toString());
			}
		}
		
		if(voSessionApptOrder.getAppointmentsIsNotNull())
		{
			populateAppointmentsGridFromData(voSessionApptOrder.getAppointments());
		}
	}

	/**
	 * @param voAppts
	 */
	private void populateAppointmentsGridFromData(BookingAppointmentTheatreVoCollection voAppts)
	{
		for(BookingAppointmentTheatreVo voAppt : voAppts)
		{
			if(voAppt.getApptStatus().equals(Status_Reason.CANCELLED)
					|| voAppt.getApptStatus().equals(Status_Reason.DNA))
				continue;
				
			grdApptsRow aRow = form.grdAppts().getRows().newRow();
						
			if(voAppt.getPatientIsNotNull())
			{
				if (voAppt.getPatient().getDisplayId() != null) 
					aRow.setColHospitalNo(voAppt.getPatient().getDisplayId().getValue());
				if(voAppt.getPatient().getNameIsNotNull())
				{
					aRow.setColSurname(voAppt.getPatient().getName().getSurname());
					aRow.setColForename(voAppt.getPatient().getName().getForename());
				}
				if(voAppt.getPatient().getSexIsNotNull())
					aRow.setColSex(voAppt.getPatient().getSex().getText());
				if(voAppt.getPatient().getDobIsNotNull())
					aRow.setColDob(voAppt.getPatient().getDob().toString());
			}
			if(voAppt.getTheatreBookingIsNotNull())
			{				
				if(voAppt.getTheatreBooking().getProcedureIsNotNull())
				{
					aRow.setColProcedure(voAppt.getTheatreBooking().getProcedure().getProcedureName());
					aRow.setTooltipForColProcedure(voAppt.getTheatreBooking().getProcedure().getProcedureName());
				}
			}
			
			if(voAppt.getAppointmentTCITimeIsNotNull())
				aRow.setColComeInTime(voAppt.getAppointmentTCITime());
			
			if(voAppt.getApptStartTimeIsNotNull())
				aRow.setColApptTime(voAppt.getApptStartTime());
				
			if(voAppt.getApptStartTimeIsNotNull() && voAppt.getAppointmentTCITimeIsNotNull())
				aRow.setColCustomTCILag(SlotGenerationUtils.calculateDuration(voAppt.getApptStartTime().toString(), voAppt.getAppointmentTCITime().toString()));
			
			if(voAppt.getCustomProcedureDurationIsNotNull())
				aRow.setColDuration(voAppt.getCustomProcedureDuration().toString());
			
			
			//colour overlapping appointments
			grdApptsRow previousRow;
			if(form.grdAppts().getRows().size() > 1)
			{
				previousRow = form.grdAppts().getRows().get(form.grdAppts().getRows().size() -2);
				if(previousRow.getValue() != null)
				{
					if(previousRow.getValue().getApptEndTimeIsNotNull() && previousRow.getValue().getApptEndTime().isGreaterThan(voAppt.getApptStartTime()))
						previousRow.setBackColor(Color.Red);
				}
			}
			
			aRow.setValue(voAppt);
		}
	}

	private void updateControlState()
	{
		if(form.getMode().equals(FormMode.VIEW))
		{
			if(form.getLocalContext().getSessApptOrderIsNotNull() && form.getLocalContext().getSessApptOrder().getFinalisedDateTime() == null && form.grdAppts().getRows().size() > 0)
			{
				form.btnEdit().setVisible(true);
				form.btnFinalise().setVisible(true);
			}
			else
			{
				form.btnEdit().setVisible(false);
				form.btnFinalise().setVisible(false);
			}
		}
		else
		{			
			for(int i=0;i<form.grdAppts().getRows().size(); i++)
			{
				form.grdAppts().getRows().get(i).setColComeInTimeReadOnly(!(form.getLocalContext().getEditingTimesIsNotNull() && form.getLocalContext().getEditingTimes()));
				form.grdAppts().getRows().get(i).setColApptTimeReadOnly(!(form.getLocalContext().getEditingTimesIsNotNull() && form.getLocalContext().getEditingTimes()));
			}
		}

		
		updateContextMenuState();	
	}

	private void updateContextMenuState()
	{
		form.getContextMenus().Scheduling.hideAllSortFixedTheatreAppointmentsMenuItems();
		if(form.getMode().equals(FormMode.EDIT))
		{			
			if(form.grdAppts().getRows().size() > 1)
			{
				form.getContextMenus().Scheduling.getSortFixedTheatreAppointmentsSORTBYTCIItem().setVisible(true);
				
				if(form.grdAppts().getSelectedRow() != null)
				{
					if(form.grdAppts().canMoveCurrentUp())
						form.getContextMenus().Scheduling.getSortFixedTheatreAppointmentsMOVEUPItem().setVisible(true);
					if(form.grdAppts().canMoveCurrentDown())
						form.getContextMenus().Scheduling.getSortFixedTheatreAppointmentsMOVEDOWNItem().setVisible(true);
				}
			}
			if(form.grdAppts().getSelectedRow() != null)
			{
				//only allow editing Times for 'Booked' status
				if(form.grdAppts().getValue() != null)
					if(form.grdAppts().getValue().getCurrentStatusRecordIsNotNull())
						if(form.grdAppts().getValue().getCurrentStatusRecord().getStatusIsNotNull())
							if(form.grdAppts().getValue().getCurrentStatusRecord().getStatus().equals(Status_Reason.BOOKED))
								form.getContextMenus().Scheduling.getSortFixedTheatreAppointmentsEDITTIMESItem().setVisible(true);
			}
		}
	}

	private void clearInstanceControls()
	{
		form.txtTheatreDetail().setValue("");
		form.txtListOwner().setValue("");
		form.txtDate().setValue("");
		form.txtFinalisedBy().setValue("");
		form.txtProcedure().setValue("");
		form.txtProcedure().setTooltip(" ");
		form.txtFinalisedDT().setValue("");
		form.grdAppts().getRows().clear();
	}

	@Override
	protected void onGrdApptsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		updateContextMenuState();
	}
	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		reStackAppointments();	
		updateControlState();			//wdev-16552
		
	}

	/**
	 * get first appt time and stack appts on top of each other by procedure duration
	 */
	private void reStackAppointments()
	{
		Sch_Session_Appointment_OrderVo voSessApptOrder = form.getLocalContext().getSessApptOrder();
		if(voSessApptOrder != null && voSessApptOrder.getAppointmentsIsNotNull() &&  voSessApptOrder.getAppointments().size() > 0)
		{
			if(voSessApptOrder.getAppointments().get(0).getApptStartTime() != null)
			{
				Time nextApptStartTime = getFirstAvailableSlotTime(voSessApptOrder.getSession());
				for(int i=0;i<voSessApptOrder.getAppointments().size();i++)
				{
					
					int duration = 0;
					if(voSessApptOrder.getAppointments().get(i).getCustomProcedureDurationIsNotNull())
						duration = voSessApptOrder.getAppointments().get(i).getCustomProcedureDuration();
					
					int tciDuration = 0;
					if(voSessApptOrder.getAppointments().get(i).getApptStartTimeIsNotNull() && voSessApptOrder.getAppointments().get(i).getAppointmentTCITimeIsNotNull())
						tciDuration = SlotGenerationUtils.calculateDuration(voSessApptOrder.getAppointments().get(i).getApptStartTime().toString(), voSessApptOrder.getAppointments().get(i).getAppointmentTCITime().toString());
					
					
					if(nextApptStartTime != null)
					{
						voSessApptOrder.getAppointments().get(i).setApptStartTime(nextApptStartTime.copy());
					
						Time apptEndTime = nextApptStartTime.copy();
						apptEndTime.addMinutes(duration);
						voSessApptOrder.getAppointments().get(i).setApptEndTime(apptEndTime);
						
						Time newApptTciTime = voSessApptOrder.getAppointments().get(i).getApptStartTime().copy();
						newApptTciTime.addMinutes(tciDuration);
						voSessApptOrder.getAppointments().get(i).setAppointmentTCITime(newApptTciTime);	
					}	
					
					nextApptStartTime = Booking_AppointmentVo.calculateEndTime(voSessApptOrder.getAppointments().get(i).getApptStartTime(), duration);
					
				}
			}
		}
		
		form.grdAppts().getRows().clear();
		populateScreenFromData(form.getLocalContext().getSessApptOrder());
	}
	private Time getFirstAvailableSlotTime(SessionTheatreVo session)
	{
		if (session == null)
			throw new CodingRuntimeException("session cannot be null in method getFirstAvailableSlotTime");
		
		if(session.getParentChildSlotsIsNotNull() && session.getParentChildSlots().size() > 0)
		{
			session.getParentChildSlots().sort(SortOrder.ASCENDING);
			int i=0;
			
			do
			{
				if(i < session.getParentChildSlots().size())
				{
					if(session.getParentChildSlots().get(i).getStatusIsNotNull() && (session.getParentChildSlots().get(i).getStatus().equals(Status_Reason.SLOTOPENED) || session.getParentChildSlots().get(i).getStatus().equals(Status_Reason.APPOINTMENT_BOOKED)))
						return session.getParentChildSlots().get(i).getStartTime().copy();
				}
				
				i++;
			}
			while(i<session.getParentChildSlots().size() && session.getParentChildSlots().get(i).getStatusIsNotNull() && !session.getParentChildSlots().get(i).getStatus().equals(Status_Reason.SLOTOPENED));
			
			
		}
		
		return null;
	}

	@Override
	protected void onBtnFinaliseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Sch_Session_Appointment_OrderVo voSessApptOrder = populateDataFromScreen();
		voSessApptOrder.setFinalisedBy((IMos)domain.getMosUser());
		voSessApptOrder.setFinalisedDateTime(new DateTime());
		if(save(voSessApptOrder))
			open();
	}

	private boolean save(Sch_Session_Appointment_OrderVo voSessApptOrder)
	{
		String[] arrErrors = voSessApptOrder.validate(getUIValidation());
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
	
		try
		{
			domain.saveSessionApptOrder(voSessApptOrder);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			
			//WDEV-11908
			open();
			return false;
		}
		
		return true;
	}
	private String[] getUIValidation()
	{
		List<String> errors = new ArrayList<String>();

		for(int i=form.grdAppts().getRows().size()-1; i>=0; i--)
		{
			grdApptsRow row = form.grdAppts().getRows().get(i);
			if(row.getColApptTime() == null)
				errors.add("'Start Time' is mandatory");
			if(row.getColComeInTime() == null)
				errors.add("'Come In Time' is mandatory");
			if(row.getColComeInTime() != null && row.getColApptTime() != null && row.getColComeInTime().isGreaterThan(row.getColApptTime()))
				errors.add("'Come In Time' must be before 'Start Time'");
			
			//trap overlapping appointments
			if(row.getColApptTime() != null)
			{
				grdApptsRow previousRow;
				if(i > 0)
				{
					previousRow = form.grdAppts().getRows().get(i-1);
					if(previousRow != null)// 	WDEV-15585
					{
						if(previousRow.getColApptTime() != null && previousRow.getColApptTime().isGreaterThan(row.getColApptTime()))// 	WDEV-15585
							errors.add("The 'Start Time' of the appointment entered is invalid as the time entered is after the next appointment 'Start Time'");		
					}
				}
			}			
		}
		
		return errors.size() > 0 ? errors.toArray(new String[0]) : null;
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Sch_Session_Appointment_OrderVo voSessApptOrder = populateDataFromScreen();
		if(save(voSessApptOrder))
		{
			open();
		}
	}
	private Sch_Session_Appointment_OrderVo populateDataFromScreen()
	{
		Sch_Session_Appointment_OrderVo voSessApptOrder = form.getLocalContext().getSessApptOrder();
		if(voSessApptOrder == null)
			return null;
		
		BookingAppointmentTheatreVoCollection voCollTheatreAppt = getGridValues();
		
		voSessApptOrder.setAppointments(voCollTheatreAppt);
			
		return voSessApptOrder;
	}

	/**
	 * @return
	 */
	private BookingAppointmentTheatreVoCollection getGridValues()
	{
		BookingAppointmentTheatreVoCollection voCollTheatreAppt = new BookingAppointmentTheatreVoCollection();
		for(int i=0;i<form.grdAppts().getRows().size();i++)
		{
			grdApptsRow apptsRow = form.grdAppts().getRows().get(i);
			
			if(apptsRow.getValue() == null)
				continue;
			
			BookingAppointmentTheatreVo voAppt = (BookingAppointmentTheatreVo) apptsRow.getValue().clone();//WDEV-13245
			
			voAppt.setAppointmentTCITime(apptsRow.getColComeInTime());
			voAppt.setApptStartTime(apptsRow.getColApptTime());
			
			boolean change = isApptChanged(voAppt);//	WDEV-13245
			
			Integer duration = voAppt.getCustomProcedureDuration();
			//WDEV-13242
			if(voAppt.getApptStartTimeIsNotNull())
			{
				voAppt.setApptEndTime(voAppt.getApptStartTime().copy());
				voAppt.getApptEndTime().addMinutes(duration);
			}
			
			//WDEV-13245 - starts here
			if(change)
			{
				Appointment_StatusVo status = (Appointment_StatusVo) voAppt.getCurrentStatusRecord().clone();
				
				status.clearIDAndVersion();
				
				status.setApptTime(voAppt.getApptStartTime());
				status.setComment("Appointment Re-ordered");
				status.setStatusChangeDateTime(new DateTime());
				
				voAppt.setCurrentStatusRecord(status);
				voAppt.getApptStatusHistory().add(status);
			}
			//WDEV-13245 - ends here
			
			voCollTheatreAppt.add(voAppt);
		}
		return voCollTheatreAppt;
	}

	//	WDEV-13245
	private boolean isApptChanged(BookingAppointmentTheatreVo voAppt) 
	{
		if(voAppt == null)
			return false;
		
		if(form.getLocalContext().getAppointmentsBeforeReorder() == null)
			return false;
		
		for(BookingAppointmentTheatreVo oldAppt : form.getLocalContext().getAppointmentsBeforeReorder())
		{
			if(oldAppt == null)
				continue;
			
			if(oldAppt.getID_Booking_Appointment().equals(voAppt.getID_Booking_Appointment()))
			{
				if(oldAppt.getApptStartTimeIsNotNull() && !oldAppt.getApptStartTime().equals(voAppt.getApptStartTime()))
					return true;
				else if(oldAppt.getAppointmentTCITimeIsNotNull() && !oldAppt.getAppointmentTCITime().equals(voAppt.getAppointmentTCITime()))
					return true;
			}
		}
		
		return false;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-11868
		if(form.getLocalContext().getEditingTimesIsNotNull() && form.getLocalContext().getEditingTimes())
			open();
		else
			engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.SchedulingNamespace.SortFixedTheatreAppointments.MOVEUP :
				
				//WDEV-16527
				if(form.grdAppts().getRows().get(form.grdAppts().getSelectedRowIndex() - 1).getColApptTime() == null)
				{
					engine.showMessage("Please enter Start Time for the upper row.");
					return;
				}
				
				form.grdAppts().moveUp();
				swapStartAndTCITimesForRows(MOVEDUP);
				updateContextMenuState();
			break;
			case GenForm.ContextMenus.SchedulingNamespace.SortFixedTheatreAppointments.MOVEDOWN :
				
				//WDEV-16527
				if(form.grdAppts().getSelectedRow().getColApptTime() == null)
				{
					engine.showMessage("Please enter Start Time for the selected row.");
					return;
				}
				
				form.grdAppts().moveDown();
				swapStartAndTCITimesForRows(MOVEDDOWN);
				updateContextMenuState();
			break;
			case GenForm.ContextMenus.SchedulingNamespace.SortFixedTheatreAppointments.SORTBYTCI :
				SortOrder sortOrder = form.getLocalContext().getTCISortOrder();
				if(sortOrder == null)
					sortOrder = SortOrder.ASCENDING;
				else if(sortOrder == SortOrder.ASCENDING)
					sortOrder = SortOrder.DESCENDING;
				else if(sortOrder == SortOrder.DESCENDING)
					sortOrder = SortOrder.ASCENDING;
				
				form.getLocalContext().setTCISortOrder(sortOrder);
							
				BookingAppointmentTheatreVoCollection voCollAppts = getGridValues();
				voCollAppts.sort(BookingAppointmentTheatreVo.getComeInTimeComparator(sortOrder));
				form.grdAppts().getRows().clear();
				populateAppointmentsGridFromData(voCollAppts);
				
				updateControlState();
			break;
			case GenForm.ContextMenus.SchedulingNamespace.SortFixedTheatreAppointments.EDITTIMES:
				form.getLocalContext().setEditingTimes(true);
				if(form.grdAppts().getSelectedRow() != null)
				{
					form.grdAppts().getSelectedRow().setColComeInTimeReadOnly(false);
					form.grdAppts().getSelectedRow().setColApptTimeReadOnly(false);
				}	
				
				updateContextMenuState();
				
				updateControlState();
			break;
			default:
		}
	}

	private void swapStartAndTCITimesForRows(int direction)
	{
		if(form.grdAppts().getRows().size() == 0)
			throw new CodingRuntimeException("rows collection empty in swapStartAndTCITimesForRows");
		
		int index = form.grdAppts().getSelectedRowIndex();
		
		switch(direction)
		{
			case MOVEDDOWN:
				grdApptsRow rowdowned1 = form.grdAppts().getSelectedRow();
				grdApptsRow rowupped1 = form.grdAppts().getRows().get(index-1);
				
				swapTCITimes(rowupped1, rowdowned1);
				
				break;
			case MOVEDUP:
				grdApptsRow rowupped = form.grdAppts().getSelectedRow();
				grdApptsRow rowdowned = form.grdAppts().getRows().get(index+1);
						
				swapTCITimes(rowupped, rowdowned);
				
				break;
			default:
		}
		
	}

	/**
	 * @param rowupped
	 * @param rowdowned
	 */
	private void swapTCITimes(grdApptsRow rowupped, grdApptsRow rowdowned)
	{
		Time newUppedApptTime = null;
		if(rowdowned.getColApptTime() != null)
			newUppedApptTime = rowdowned.getColApptTime().copy();	
		
		Time newDownedApptTime = null;
		if(newUppedApptTime != null)
			newDownedApptTime = newUppedApptTime.copy();
		
		if(rowupped.getValue().getCustomProcedureDuration() != null && newDownedApptTime != null)
			newDownedApptTime.addMinutes(rowupped.getValue().getCustomProcedureDuration());
			
		//calculate the new TCI times
		Time uppedTCiTime = null; 
		if(rowdowned.getColApptTime() != null)	
		{
			uppedTCiTime = rowdowned.getColApptTime().copy();
			if (rowupped.getColApptTime() != null && rowupped.getColComeInTime() != null)
				uppedTCiTime.addMinutes(calculateTCIMins(rowupped));
			else
				uppedTCiTime.addMinutes(calculateInitialTCIMins(rowupped.getValue()));
		}
		
		Time downedTCITime = null; 
		if(newDownedApptTime != null)	
		{
			downedTCITime = newDownedApptTime.copy();
			if (rowdowned.getColApptTime() != null && rowdowned.getColComeInTime() != null)
				downedTCITime.addMinutes(calculateTCIMins(rowdowned));
			else
				downedTCITime.addMinutes(calculateInitialTCIMins(rowdowned.getValue()));
		}
		
		rowdowned.setColComeInTime(downedTCITime);	
		rowdowned.setColApptTime(newDownedApptTime);		

		rowupped.setColApptTime(newUppedApptTime);
		rowupped.setColComeInTime(uppedTCiTime);	
	}

	private int calculateInitialTCIMins(BookingAppointmentTheatreVo value)
	{
		if(value.getApptStartTime() != null && value.getAppointmentTCITime() != null)
			return SlotGenerationUtils.calculateDuration(value.getApptStartTime().toString(), value.getAppointmentTCITime().toString());
		return 0;
	}

	private int calculateTCIMins(grdApptsRow row)
	{
		if(row.getColApptTime() != null && row.getColComeInTime() != null)
			return SlotGenerationUtils.calculateDuration(row.getColApptTime().toString(), row.getColComeInTime().toString());

		return 0;
	}

	@Override
	protected void onGrdSessionsSelectionChanged() throws PresentationLogicException
	{
		grdSessionsSelectionChanged();
	}

	private void grdSessionsSelectionChanged()
	{
		Sch_Session_Appointment_OrderVo voSessionApptOrder = domain.getSessionApptOrderBySession(form.grdSessions().getValue());
		clearInstanceControls();
		form.getLocalContext().setSessApptOrder(voSessionApptOrder);

		if(voSessionApptOrder  == null)
		{
			engine.showMessage("No Appts Booked for this Session");
			return;
		}
		
		//WDEV-13245
		populateAppointmentsBeforeReorderContext(voSessionApptOrder.getAppointments());
		
		populateScreenFromData(voSessionApptOrder);
		updateControlState();
	}

	@Override
	
	protected void onImbClearClick() throws PresentationLogicException
	{
		clearScreen();		
		form.btnEdit().setVisible(false);
		form.btnFinalise().setVisible(false);
	}

	private void clearScreen()
	{
		form.dteSession().setValue(null);
		form.grdSessions().getRows().clear();
		clearInstanceControls();
	}

	@Override
	protected void onImbSearchClick() throws PresentationLogicException
	{
		searchSessions();
	}

	private void searchSessions()
	{
		if(form.dteSession().getValue() == null)
		{
			engine.showErrors(new String[] {"Session Date is mandatory"});
			return;
		}
		
		form.grdSessions().getRows().clear();
		clearInstanceControls();		
		
		SessionLiteVoCollection voCollSession = domain.listSessionByDate(form.dteSession().getValue());
		if(voCollSession != null)
		{
			for(SessionLiteVo voSession : voCollSession)
			{
				grdSessionsRow sRow = form.grdSessions().getRows().newRow();
				sRow.setColSession(voSession.getName());
				sRow.setValue(voSession);
			}
		}
		
		if(form.getMode().equals(FormMode.VIEW)){
			form.btnEdit().setVisible(false);
			form.btnFinalise().setVisible(false);
		}
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlState();
	}
}