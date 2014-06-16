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

package ims.assessment.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Assessment.Instantiation.PatientAssessmentGroup business object (ID: 1003100059).
 */
public class PatientAssessmentGroupListVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PatientAssessmentGroupListVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PatientAssessmentGroupListVo> col = new ArrayList<PatientAssessmentGroupListVo>();
	public String getBoClassName()
	{
		return "ims.assessment.instantiation.domain.objects.PatientAssessmentGroup";
	}
	public boolean add(PatientAssessmentGroupListVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PatientAssessmentGroupListVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(PatientAssessmentGroupListVo instance)
	{
		return col.indexOf(instance);
	}
	public PatientAssessmentGroupListVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PatientAssessmentGroupListVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PatientAssessmentGroupListVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PatientAssessmentGroupListVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PatientAssessmentGroupListVoCollection clone = new PatientAssessmentGroupListVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PatientAssessmentGroupListVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public PatientAssessmentGroupListVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PatientAssessmentGroupListVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PatientAssessmentGroupListVoCollection sort(SortOrder order)
	{
		return sort(new PatientAssessmentGroupListVoComparator(order));
	}
	public PatientAssessmentGroupListVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PatientAssessmentGroupListVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PatientAssessmentGroupListVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.assessment.instantiation.vo.PatientAssessmentGroupRefVoCollection toRefVoCollection()
	{
		ims.assessment.instantiation.vo.PatientAssessmentGroupRefVoCollection result = new ims.assessment.instantiation.vo.PatientAssessmentGroupRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PatientAssessmentGroupListVo[] toArray()
	{
		PatientAssessmentGroupListVo[] arr = new PatientAssessmentGroupListVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PatientAssessmentGroupListVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PatientAssessmentGroupListVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PatientAssessmentGroupListVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PatientAssessmentGroupListVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PatientAssessmentGroupListVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PatientAssessmentGroupListVo voObj1 = (PatientAssessmentGroupListVo)obj1;
			PatientAssessmentGroupListVo voObj2 = (PatientAssessmentGroupListVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.assessment.vo.beans.PatientAssessmentGroupListVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.assessment.vo.beans.PatientAssessmentGroupListVoBean[] getBeanCollectionArray()
	{
		ims.assessment.vo.beans.PatientAssessmentGroupListVoBean[] result = new ims.assessment.vo.beans.PatientAssessmentGroupListVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PatientAssessmentGroupListVo vo = ((PatientAssessmentGroupListVo)col.get(i));
			result[i] = (ims.assessment.vo.beans.PatientAssessmentGroupListVoBean)vo.getBean();
		}
		return result;
	}
	public static PatientAssessmentGroupListVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PatientAssessmentGroupListVoCollection coll = new PatientAssessmentGroupListVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.assessment.vo.beans.PatientAssessmentGroupListVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PatientAssessmentGroupListVoCollection buildFromBeanCollection(ims.assessment.vo.beans.PatientAssessmentGroupListVoBean[] beans)
	{
		PatientAssessmentGroupListVoCollection coll = new PatientAssessmentGroupListVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}