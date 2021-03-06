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
 * Linked to core.admin.TemplateBo business object (ID: 1004100008).
 */
public class TemplateBoLiteVo extends ims.core.admin.vo.TemplateBoRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TemplateBoLiteVo()
	{
	}
	public TemplateBoLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TemplateBoLiteVo(ims.core.vo.beans.TemplateBoLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.isactive = bean.getIsActive();
		this.lastdeployment = bean.getLastDeployment() == null ? null : bean.getLastDeployment().buildDateTime();
		this.lastupdated = bean.getLastUpdated() == null ? null : bean.getLastUpdated().buildDateTime();
		this.templatexml = bean.getTemplateXml();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.TemplateBoLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.isactive = bean.getIsActive();
		this.lastdeployment = bean.getLastDeployment() == null ? null : bean.getLastDeployment().buildDateTime();
		this.lastupdated = bean.getLastUpdated() == null ? null : bean.getLastUpdated().buildDateTime();
		this.templatexml = bean.getTemplateXml();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.TemplateBoLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.TemplateBoLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.TemplateBoLiteVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("LASTDEPLOYMENT"))
			return getLastDeployment();
		if(fieldName.equals("LASTUPDATED"))
			return getLastUpdated();
		if(fieldName.equals("TEMPLATEXML"))
			return getTemplateXml();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 255;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getLastDeploymentIsNotNull()
	{
		return this.lastdeployment != null;
	}
	public ims.framework.utils.DateTime getLastDeployment()
	{
		return this.lastdeployment;
	}
	public void setLastDeployment(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.lastdeployment = value;
	}
	public boolean getLastUpdatedIsNotNull()
	{
		return this.lastupdated != null;
	}
	public ims.framework.utils.DateTime getLastUpdated()
	{
		return this.lastupdated;
	}
	public void setLastUpdated(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.lastupdated = value;
	}
	public boolean getTemplateXmlIsNotNull()
	{
		return this.templatexml != null;
	}
	public String getTemplateXml()
	{
		return this.templatexml;
	}
	public static int getTemplateXmlMaxLength()
	{
		return 200000;
	}
	public void setTemplateXml(String value)
	{
		this.isValidated = false;
		this.templatexml = value;
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("name is mandatory");
		else if(this.name.length() > 255)
			listOfErrors.add("The length of the field [name] in the value object [ims.core.vo.TemplateBoLiteVo] is too big. It should be less or equal to 255");
		if(this.templatexml == null || this.templatexml.length() == 0)
			listOfErrors.add("templateXml is mandatory");
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
	
		TemplateBoLiteVo clone = new TemplateBoLiteVo(this.id, this.version);
		
		clone.name = this.name;
		clone.isactive = this.isactive;
		if(this.lastdeployment == null)
			clone.lastdeployment = null;
		else
			clone.lastdeployment = (ims.framework.utils.DateTime)this.lastdeployment.clone();
		if(this.lastupdated == null)
			clone.lastupdated = null;
		else
			clone.lastupdated = (ims.framework.utils.DateTime)this.lastupdated.clone();
		clone.templatexml = this.templatexml;
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
		if (!(TemplateBoLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TemplateBoLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TemplateBoLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TemplateBoLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.lastdeployment != null)
			count++;
		if(this.lastupdated != null)
			count++;
		if(this.templatexml != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String name;
	protected Boolean isactive;
	protected ims.framework.utils.DateTime lastdeployment;
	protected ims.framework.utils.DateTime lastupdated;
	protected String templatexml;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
