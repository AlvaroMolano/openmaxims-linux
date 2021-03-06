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

package ims.admin.vo.beans;

public class RuleConditionRowVoBean extends ims.vo.ValueObjectBean
{
	public RuleConditionRowVoBean()
	{
	}
	public RuleConditionRowVoBean(ims.admin.vo.RuleConditionRowVo vo)
	{
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.numberofcolumns = vo.getNumberOfColumns();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.RuleConditionRowVo vo)
	{
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.numberofcolumns = vo.getNumberOfColumns();
	}

	public ims.admin.vo.RuleConditionRowVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.RuleConditionRowVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.RuleConditionRowVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.RuleConditionRowVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.RuleConditionRowVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public Integer getNumberOfColumns()
	{
		return this.numberofcolumns;
	}
	public void setNumberOfColumns(Integer value)
	{
		this.numberofcolumns = value;
	}

	private ims.vo.LookupInstanceBean type;
	private Integer numberofcolumns;
}
