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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo;

/**
 * Linked to core.clinical.VitalSignsMonitoring business object (ID: 1003100073).
 */
public class VitalSignMonitoringVo extends ims.core.clinical.vo.VitalSignsMonitoringRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public VitalSignMonitoringVo()
	{
	}
	public VitalSignMonitoringVo(Integer id, int version)
	{
		super(id, version);
	}
	public VitalSignMonitoringVo(ims.core.vo.beans.VitalSignMonitoringVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.vitalsigngroup = bean.getVitalSignGroup() == null ? null : bean.getVitalSignGroup().buildVo();
		this.groupfrequency = bean.getGroupFrequency() == null ? null : ims.core.vo.lookups.VitalSignsMonitoringFrequency.buildLookup(bean.getGroupFrequency());
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.durationvalue = bean.getDurationValue();
		this.durationunit = bean.getDurationUnit() == null ? null : ims.core.vo.lookups.VitalSignsMonitoringDuration.buildLookup(bean.getDurationUnit());
		this.requestedby = bean.getRequestedBy() == null ? null : bean.getRequestedBy().buildVo();
		this.requestdetails = bean.getRequestDetails();
		this.stoppedby = bean.getStoppedBy() == null ? null : bean.getStoppedBy().buildVo();
		this.stoppeddatetime = bean.getStoppedDateTime() == null ? null : bean.getStoppedDateTime().buildDateTime();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.itemfrequency = ims.core.vo.VitalSignItemFrequencyVoCollection.buildFromBeanCollection(bean.getItemFrequency());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.VitalSignMonitoringVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.vitalsigngroup = bean.getVitalSignGroup() == null ? null : bean.getVitalSignGroup().buildVo(map);
		this.groupfrequency = bean.getGroupFrequency() == null ? null : ims.core.vo.lookups.VitalSignsMonitoringFrequency.buildLookup(bean.getGroupFrequency());
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.durationvalue = bean.getDurationValue();
		this.durationunit = bean.getDurationUnit() == null ? null : ims.core.vo.lookups.VitalSignsMonitoringDuration.buildLookup(bean.getDurationUnit());
		this.requestedby = bean.getRequestedBy() == null ? null : bean.getRequestedBy().buildVo(map);
		this.requestdetails = bean.getRequestDetails();
		this.stoppedby = bean.getStoppedBy() == null ? null : bean.getStoppedBy().buildVo(map);
		this.stoppeddatetime = bean.getStoppedDateTime() == null ? null : bean.getStoppedDateTime().buildDateTime();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.itemfrequency = ims.core.vo.VitalSignItemFrequencyVoCollection.buildFromBeanCollection(bean.getItemFrequency());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.VitalSignMonitoringVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.VitalSignMonitoringVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.VitalSignMonitoringVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("VITALSIGNGROUP"))
			return getVitalSignGroup();
		if(fieldName.equals("GROUPFREQUENCY"))
			return getGroupFrequency();
		if(fieldName.equals("STARTDATETIME"))
			return getStartDateTime();
		if(fieldName.equals("DURATIONVALUE"))
			return getDurationValue();
		if(fieldName.equals("DURATIONUNIT"))
			return getDurationUnit();
		if(fieldName.equals("REQUESTEDBY"))
			return getRequestedBy();
		if(fieldName.equals("REQUESTDETAILS"))
			return getRequestDetails();
		if(fieldName.equals("STOPPEDBY"))
			return getStoppedBy();
		if(fieldName.equals("STOPPEDDATETIME"))
			return getStoppedDateTime();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("ITEMFREQUENCY"))
			return getItemFrequency();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.admin.vo.ClinicalContactRefVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.admin.vo.ClinicalContactRefVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getVitalSignGroupIsNotNull()
	{
		return this.vitalsigngroup != null;
	}
	public ims.core.vo.VitalSignMonitoringGroupVo getVitalSignGroup()
	{
		return this.vitalsigngroup;
	}
	public void setVitalSignGroup(ims.core.vo.VitalSignMonitoringGroupVo value)
	{
		this.isValidated = false;
		this.vitalsigngroup = value;
	}
	public boolean getGroupFrequencyIsNotNull()
	{
		return this.groupfrequency != null;
	}
	public ims.core.vo.lookups.VitalSignsMonitoringFrequency getGroupFrequency()
	{
		return this.groupfrequency;
	}
	public void setGroupFrequency(ims.core.vo.lookups.VitalSignsMonitoringFrequency value)
	{
		this.isValidated = false;
		this.groupfrequency = value;
	}
	public boolean getStartDateTimeIsNotNull()
	{
		return this.startdatetime != null;
	}
	public ims.framework.utils.DateTime getStartDateTime()
	{
		return this.startdatetime;
	}
	public void setStartDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.startdatetime = value;
	}
	public boolean getDurationValueIsNotNull()
	{
		return this.durationvalue != null;
	}
	public Integer getDurationValue()
	{
		return this.durationvalue;
	}
	public void setDurationValue(Integer value)
	{
		this.isValidated = false;
		this.durationvalue = value;
	}
	public boolean getDurationUnitIsNotNull()
	{
		return this.durationunit != null;
	}
	public ims.core.vo.lookups.VitalSignsMonitoringDuration getDurationUnit()
	{
		return this.durationunit;
	}
	public void setDurationUnit(ims.core.vo.lookups.VitalSignsMonitoringDuration value)
	{
		this.isValidated = false;
		this.durationunit = value;
	}
	public boolean getRequestedByIsNotNull()
	{
		return this.requestedby != null;
	}
	public ims.core.vo.HcpLiteVo getRequestedBy()
	{
		return this.requestedby;
	}
	public void setRequestedBy(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.requestedby = value;
	}
	public boolean getRequestDetailsIsNotNull()
	{
		return this.requestdetails != null;
	}
	public String getRequestDetails()
	{
		return this.requestdetails;
	}
	public static int getRequestDetailsMaxLength()
	{
		return 500;
	}
	public void setRequestDetails(String value)
	{
		this.isValidated = false;
		this.requestdetails = value;
	}
	public boolean getStoppedByIsNotNull()
	{
		return this.stoppedby != null;
	}
	public ims.core.vo.HcpLiteVo getStoppedBy()
	{
		return this.stoppedby;
	}
	public void setStoppedBy(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.stoppedby = value;
	}
	public boolean getStoppedDateTimeIsNotNull()
	{
		return this.stoppeddatetime != null;
	}
	public ims.framework.utils.DateTime getStoppedDateTime()
	{
		return this.stoppeddatetime;
	}
	public void setStoppedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.stoppeddatetime = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getItemFrequencyIsNotNull()
	{
		return this.itemfrequency != null;
	}
	public ims.core.vo.VitalSignItemFrequencyVoCollection getItemFrequency()
	{
		return this.itemfrequency;
	}
	public void setItemFrequency(ims.core.vo.VitalSignItemFrequencyVoCollection value)
	{
		this.isValidated = false;
		this.itemfrequency = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.requestedby != null)
		{
			if(!this.requestedby.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.stoppedby != null)
		{
			if(!this.stoppedby.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.itemfrequency != null)
		{
			if(!this.itemfrequency.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.vitalsigngroup == null)
			listOfErrors.add("Observations Required is mandatory");
		if(this.startdatetime == null)
			listOfErrors.add("StartDateTime is mandatory");
		if(this.durationvalue == null)
			listOfErrors.add("DurationValue is mandatory");
		if(this.durationunit == null)
			listOfErrors.add("DurationUnit is mandatory");
		if(this.requestedby != null)
		{
			String[] listOfOtherErrors = this.requestedby.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.requestdetails != null)
			if(this.requestdetails.length() > 500)
				listOfErrors.add("The length of the field [requestdetails] in the value object [ims.core.vo.VitalSignMonitoringVo] is too big. It should be less or equal to 500");
		if(this.stoppedby != null)
		{
			String[] listOfOtherErrors = this.stoppedby.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.itemfrequency != null)
		{
			String[] listOfOtherErrors = this.itemfrequency.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		VitalSignMonitoringVo clone = new VitalSignMonitoringVo(this.id, this.version);
		
		clone.clinicalcontact = this.clinicalcontact;
		clone.carecontext = this.carecontext;
		if(this.vitalsigngroup == null)
			clone.vitalsigngroup = null;
		else
			clone.vitalsigngroup = (ims.core.vo.VitalSignMonitoringGroupVo)this.vitalsigngroup.clone();
		if(this.groupfrequency == null)
			clone.groupfrequency = null;
		else
			clone.groupfrequency = (ims.core.vo.lookups.VitalSignsMonitoringFrequency)this.groupfrequency.clone();
		if(this.startdatetime == null)
			clone.startdatetime = null;
		else
			clone.startdatetime = (ims.framework.utils.DateTime)this.startdatetime.clone();
		clone.durationvalue = this.durationvalue;
		if(this.durationunit == null)
			clone.durationunit = null;
		else
			clone.durationunit = (ims.core.vo.lookups.VitalSignsMonitoringDuration)this.durationunit.clone();
		if(this.requestedby == null)
			clone.requestedby = null;
		else
			clone.requestedby = (ims.core.vo.HcpLiteVo)this.requestedby.clone();
		clone.requestdetails = this.requestdetails;
		if(this.stoppedby == null)
			clone.stoppedby = null;
		else
			clone.stoppedby = (ims.core.vo.HcpLiteVo)this.stoppedby.clone();
		if(this.stoppeddatetime == null)
			clone.stoppeddatetime = null;
		else
			clone.stoppeddatetime = (ims.framework.utils.DateTime)this.stoppeddatetime.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.itemfrequency == null)
			clone.itemfrequency = null;
		else
			clone.itemfrequency = (ims.core.vo.VitalSignItemFrequencyVoCollection)this.itemfrequency.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(VitalSignMonitoringVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A VitalSignMonitoringVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((VitalSignMonitoringVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((VitalSignMonitoringVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.clinicalcontact != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.vitalsigngroup != null)
			count++;
		if(this.groupfrequency != null)
			count++;
		if(this.startdatetime != null)
			count++;
		if(this.durationvalue != null)
			count++;
		if(this.durationunit != null)
			count++;
		if(this.requestedby != null)
			count++;
		if(this.requestdetails != null)
			count++;
		if(this.stoppedby != null)
			count++;
		if(this.stoppeddatetime != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.itemfrequency != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.VitalSignMonitoringGroupVo vitalsigngroup;
	protected ims.core.vo.lookups.VitalSignsMonitoringFrequency groupfrequency;
	protected ims.framework.utils.DateTime startdatetime;
	protected Integer durationvalue;
	protected ims.core.vo.lookups.VitalSignsMonitoringDuration durationunit;
	protected ims.core.vo.HcpLiteVo requestedby;
	protected String requestdetails;
	protected ims.core.vo.HcpLiteVo stoppedby;
	protected ims.framework.utils.DateTime stoppeddatetime;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.vo.VitalSignItemFrequencyVoCollection itemfrequency;
	private boolean isValidated = false;
	private boolean isBusy = false;
}