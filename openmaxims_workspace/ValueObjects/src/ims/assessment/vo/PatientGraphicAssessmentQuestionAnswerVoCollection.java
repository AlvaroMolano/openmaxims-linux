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
 * Linked to Assessment.Instantiation.PatientGraphicAssessmentQuestionAnswer business object (ID: 1003100058).
 */
public class PatientGraphicAssessmentQuestionAnswerVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PatientGraphicAssessmentQuestionAnswerVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PatientGraphicAssessmentQuestionAnswerVo> col = new ArrayList<PatientGraphicAssessmentQuestionAnswerVo>();
	public String getBoClassName()
	{
		return "ims.assessment.instantiation.domain.objects.PatientGraphicAssessmentQuestionAnswer";
	}
	public boolean add(PatientGraphicAssessmentQuestionAnswerVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PatientGraphicAssessmentQuestionAnswerVo value)
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
	public int indexOf(PatientGraphicAssessmentQuestionAnswerVo instance)
	{
		return col.indexOf(instance);
	}
	public PatientGraphicAssessmentQuestionAnswerVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PatientGraphicAssessmentQuestionAnswerVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PatientGraphicAssessmentQuestionAnswerVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PatientGraphicAssessmentQuestionAnswerVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PatientGraphicAssessmentQuestionAnswerVoCollection clone = new PatientGraphicAssessmentQuestionAnswerVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PatientGraphicAssessmentQuestionAnswerVo)this.col.get(x).clone());
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
	public PatientGraphicAssessmentQuestionAnswerVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PatientGraphicAssessmentQuestionAnswerVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PatientGraphicAssessmentQuestionAnswerVoCollection sort(SortOrder order)
	{
		return sort(new PatientGraphicAssessmentQuestionAnswerVoComparator(order));
	}
	public PatientGraphicAssessmentQuestionAnswerVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PatientGraphicAssessmentQuestionAnswerVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PatientGraphicAssessmentQuestionAnswerVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.assessment.instantiation.vo.PatientGraphicAssessmentQuestionAnswerRefVoCollection toRefVoCollection()
	{
		ims.assessment.instantiation.vo.PatientGraphicAssessmentQuestionAnswerRefVoCollection result = new ims.assessment.instantiation.vo.PatientGraphicAssessmentQuestionAnswerRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PatientGraphicAssessmentQuestionAnswerVo[] toArray()
	{
		PatientGraphicAssessmentQuestionAnswerVo[] arr = new PatientGraphicAssessmentQuestionAnswerVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PatientGraphicAssessmentQuestionAnswerVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PatientGraphicAssessmentQuestionAnswerVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PatientGraphicAssessmentQuestionAnswerVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PatientGraphicAssessmentQuestionAnswerVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PatientGraphicAssessmentQuestionAnswerVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PatientGraphicAssessmentQuestionAnswerVo voObj1 = (PatientGraphicAssessmentQuestionAnswerVo)obj1;
			PatientGraphicAssessmentQuestionAnswerVo voObj2 = (PatientGraphicAssessmentQuestionAnswerVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.assessment.vo.beans.PatientGraphicAssessmentQuestionAnswerVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.assessment.vo.beans.PatientGraphicAssessmentQuestionAnswerVoBean[] getBeanCollectionArray()
	{
		ims.assessment.vo.beans.PatientGraphicAssessmentQuestionAnswerVoBean[] result = new ims.assessment.vo.beans.PatientGraphicAssessmentQuestionAnswerVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PatientGraphicAssessmentQuestionAnswerVo vo = ((PatientGraphicAssessmentQuestionAnswerVo)col.get(i));
			result[i] = (ims.assessment.vo.beans.PatientGraphicAssessmentQuestionAnswerVoBean)vo.getBean();
		}
		return result;
	}
	public static PatientGraphicAssessmentQuestionAnswerVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PatientGraphicAssessmentQuestionAnswerVoCollection coll = new PatientGraphicAssessmentQuestionAnswerVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.assessment.vo.beans.PatientGraphicAssessmentQuestionAnswerVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PatientGraphicAssessmentQuestionAnswerVoCollection buildFromBeanCollection(ims.assessment.vo.beans.PatientGraphicAssessmentQuestionAnswerVoBean[] beans)
	{
		PatientGraphicAssessmentQuestionAnswerVoCollection coll = new PatientGraphicAssessmentQuestionAnswerVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
