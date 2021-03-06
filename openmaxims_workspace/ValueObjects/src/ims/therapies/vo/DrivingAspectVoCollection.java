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

package ims.therapies.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to therapies.workLeisureDriving.DrivingAspect business object (ID: 1019100077).
 */
public class DrivingAspectVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<DrivingAspectVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<DrivingAspectVo> col = new ArrayList<DrivingAspectVo>();
	public String getBoClassName()
	{
		return "ims.therapies.workleisuredriving.domain.objects.DrivingAspect";
	}
	public boolean add(DrivingAspectVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, DrivingAspectVo value)
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
	public int indexOf(DrivingAspectVo instance)
	{
		return col.indexOf(instance);
	}
	public DrivingAspectVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, DrivingAspectVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(DrivingAspectVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(DrivingAspectVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		DrivingAspectVoCollection clone = new DrivingAspectVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((DrivingAspectVo)this.col.get(x).clone());
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
	public DrivingAspectVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public DrivingAspectVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public DrivingAspectVoCollection sort(SortOrder order)
	{
		return sort(new DrivingAspectVoComparator(order));
	}
	public DrivingAspectVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new DrivingAspectVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public DrivingAspectVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.therapies.workleisuredriving.vo.DrivingAspectRefVoCollection toRefVoCollection()
	{
		ims.therapies.workleisuredriving.vo.DrivingAspectRefVoCollection result = new ims.therapies.workleisuredriving.vo.DrivingAspectRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public DrivingAspectVo[] toArray()
	{
		DrivingAspectVo[] arr = new DrivingAspectVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<DrivingAspectVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class DrivingAspectVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public DrivingAspectVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public DrivingAspectVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public DrivingAspectVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			DrivingAspectVo voObj1 = (DrivingAspectVo)obj1;
			DrivingAspectVo voObj2 = (DrivingAspectVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.therapies.vo.beans.DrivingAspectVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.therapies.vo.beans.DrivingAspectVoBean[] getBeanCollectionArray()
	{
		ims.therapies.vo.beans.DrivingAspectVoBean[] result = new ims.therapies.vo.beans.DrivingAspectVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			DrivingAspectVo vo = ((DrivingAspectVo)col.get(i));
			result[i] = (ims.therapies.vo.beans.DrivingAspectVoBean)vo.getBean();
		}
		return result;
	}
	public static DrivingAspectVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		DrivingAspectVoCollection coll = new DrivingAspectVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.therapies.vo.beans.DrivingAspectVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static DrivingAspectVoCollection buildFromBeanCollection(ims.therapies.vo.beans.DrivingAspectVoBean[] beans)
	{
		DrivingAspectVoCollection coll = new DrivingAspectVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
