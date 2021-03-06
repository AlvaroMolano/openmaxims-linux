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

package ims.clinical.vo;

/**
 * Linked to core.vitals.VitalSigns business object (ID: 1022100004).
 */
public class VitalSignsForSurgicalAuditPreOpChecksVo extends ims.core.vitals.vo.VitalSignsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public VitalSignsForSurgicalAuditPreOpChecksVo()
	{
	}
	public VitalSignsForSurgicalAuditPreOpChecksVo(Integer id, int version)
	{
		super(id, version);
	}
	public VitalSignsForSurgicalAuditPreOpChecksVo(ims.clinical.vo.beans.VitalSignsForSurgicalAuditPreOpChecksVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.metrics = bean.getMetrics() == null ? null : bean.getMetrics().buildVo();
		this.vitalstakendatetime = bean.getVitalsTakenDateTime() == null ? null : bean.getVitalsTakenDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.VitalSignsForSurgicalAuditPreOpChecksVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.metrics = bean.getMetrics() == null ? null : bean.getMetrics().buildVo(map);
		this.vitalstakendatetime = bean.getVitalsTakenDateTime() == null ? null : bean.getVitalsTakenDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.VitalSignsForSurgicalAuditPreOpChecksVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.VitalSignsForSurgicalAuditPreOpChecksVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.VitalSignsForSurgicalAuditPreOpChecksVoBean();
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
		if(fieldName.equals("METRICS"))
			return getMetrics();
		if(fieldName.equals("VITALSTAKENDATETIME"))
			return getVitalsTakenDateTime();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMetricsIsNotNull()
	{
		return this.metrics != null;
	}
	public ims.core.vo.VSMetrics getMetrics()
	{
		return this.metrics;
	}
	public void setMetrics(ims.core.vo.VSMetrics value)
	{
		this.isValidated = false;
		this.metrics = value;
	}
	public boolean getVitalsTakenDateTimeIsNotNull()
	{
		return this.vitalstakendatetime != null;
	}
	public ims.framework.utils.DateTime getVitalsTakenDateTime()
	{
		return this.vitalstakendatetime;
	}
	public void setVitalsTakenDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.vitalstakendatetime = value;
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
		if(this.metrics != null)
		{
			if(!this.metrics.isValidated())
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
		if(this.metrics != null)
		{
			String[] listOfOtherErrors = this.metrics.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.vitalstakendatetime == null)
			listOfErrors.add("VitalsTakenDateTime is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		VitalSignsForSurgicalAuditPreOpChecksVo clone = new VitalSignsForSurgicalAuditPreOpChecksVo(this.id, this.version);
		
		if(this.metrics == null)
			clone.metrics = null;
		else
			clone.metrics = (ims.core.vo.VSMetrics)this.metrics.clone();
		if(this.vitalstakendatetime == null)
			clone.vitalstakendatetime = null;
		else
			clone.vitalstakendatetime = (ims.framework.utils.DateTime)this.vitalstakendatetime.clone();
		clone.carecontext = this.carecontext;
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
		if (!(VitalSignsForSurgicalAuditPreOpChecksVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A VitalSignsForSurgicalAuditPreOpChecksVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((VitalSignsForSurgicalAuditPreOpChecksVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((VitalSignsForSurgicalAuditPreOpChecksVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.metrics != null)
			count++;
		if(this.vitalstakendatetime != null)
			count++;
		if(this.carecontext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.VSMetrics metrics;
	protected ims.framework.utils.DateTime vitalstakendatetime;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
