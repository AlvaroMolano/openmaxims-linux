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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:31
 *
 */
package ims.emergency.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author George Cristian Josan
 */
public class EmergencyAttendanceOutcomeVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.emergency.vo.EmergencyAttendanceOutcomeVo copy(ims.emergency.vo.EmergencyAttendanceOutcomeVo valueObjectDest, ims.emergency.vo.EmergencyAttendanceOutcomeVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_EmergencyAttendance(valueObjectSrc.getID_EmergencyAttendance());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// EmergencyEpisode
		valueObjectDest.setEmergencyEpisode(valueObjectSrc.getEmergencyEpisode());
		// ConclusionDateTime
		valueObjectDest.setConclusionDateTime(valueObjectSrc.getConclusionDateTime());
		// BedTypeRequested
		valueObjectDest.setBedTypeRequested(valueObjectSrc.getBedTypeRequested());
		// Outcome
		valueObjectDest.setOutcome(valueObjectSrc.getOutcome());
		// Destination
		valueObjectDest.setDestination(valueObjectSrc.getDestination());
		// Patient
		valueObjectDest.setPatient(valueObjectSrc.getPatient());
		// DischargeDateTime
		valueObjectDest.setDischargeDateTime(valueObjectSrc.getDischargeDateTime());
		// CareContext
		valueObjectDest.setCareContext(valueObjectSrc.getCareContext());
		// RegistrationDateTime
		valueObjectDest.setRegistrationDateTime(valueObjectSrc.getRegistrationDateTime());
		// DischargingHCP
		valueObjectDest.setDischargingHCP(valueObjectSrc.getDischargingHCP());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createEmergencyAttendanceOutcomeVoCollectionFromEmergencyAttendance(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.admin.domain.objects.EmergencyAttendance objects.
	 */
	public static ims.emergency.vo.EmergencyAttendanceOutcomeVoCollection createEmergencyAttendanceOutcomeVoCollectionFromEmergencyAttendance(java.util.Set domainObjectSet)	
	{
		return createEmergencyAttendanceOutcomeVoCollectionFromEmergencyAttendance(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.admin.domain.objects.EmergencyAttendance objects.
	 */
	public static ims.emergency.vo.EmergencyAttendanceOutcomeVoCollection createEmergencyAttendanceOutcomeVoCollectionFromEmergencyAttendance(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.emergency.vo.EmergencyAttendanceOutcomeVoCollection voList = new ims.emergency.vo.EmergencyAttendanceOutcomeVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.admin.domain.objects.EmergencyAttendance domainObject = (ims.core.admin.domain.objects.EmergencyAttendance) iterator.next();
			ims.emergency.vo.EmergencyAttendanceOutcomeVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.core.admin.domain.objects.EmergencyAttendance objects.
	 */
	public static ims.emergency.vo.EmergencyAttendanceOutcomeVoCollection createEmergencyAttendanceOutcomeVoCollectionFromEmergencyAttendance(java.util.List domainObjectList) 
	{
		return createEmergencyAttendanceOutcomeVoCollectionFromEmergencyAttendance(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.admin.domain.objects.EmergencyAttendance objects.
	 */
	public static ims.emergency.vo.EmergencyAttendanceOutcomeVoCollection createEmergencyAttendanceOutcomeVoCollectionFromEmergencyAttendance(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.emergency.vo.EmergencyAttendanceOutcomeVoCollection voList = new ims.emergency.vo.EmergencyAttendanceOutcomeVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.admin.domain.objects.EmergencyAttendance domainObject = (ims.core.admin.domain.objects.EmergencyAttendance) domainObjectList.get(i);
			ims.emergency.vo.EmergencyAttendanceOutcomeVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.core.admin.domain.objects.EmergencyAttendance set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractEmergencyAttendanceSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.EmergencyAttendanceOutcomeVoCollection voCollection) 
	 {
	 	return extractEmergencyAttendanceSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractEmergencyAttendanceSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.EmergencyAttendanceOutcomeVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.EmergencyAttendanceOutcomeVo vo = voCollection.get(i);
			ims.core.admin.domain.objects.EmergencyAttendance domainObject = EmergencyAttendanceOutcomeVoAssembler.extractEmergencyAttendance(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.core.admin.domain.objects.EmergencyAttendance list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractEmergencyAttendanceList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.EmergencyAttendanceOutcomeVoCollection voCollection) 
	 {
	 	return extractEmergencyAttendanceList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractEmergencyAttendanceList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.EmergencyAttendanceOutcomeVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.EmergencyAttendanceOutcomeVo vo = voCollection.get(i);
			ims.core.admin.domain.objects.EmergencyAttendance domainObject = EmergencyAttendanceOutcomeVoAssembler.extractEmergencyAttendance(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.core.admin.domain.objects.EmergencyAttendance object.
	 * @param domainObject ims.core.admin.domain.objects.EmergencyAttendance
	 */
	 public static ims.emergency.vo.EmergencyAttendanceOutcomeVo create(ims.core.admin.domain.objects.EmergencyAttendance domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.admin.domain.objects.EmergencyAttendance object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.emergency.vo.EmergencyAttendanceOutcomeVo create(DomainObjectMap map, ims.core.admin.domain.objects.EmergencyAttendance domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.emergency.vo.EmergencyAttendanceOutcomeVo valueObject = (ims.emergency.vo.EmergencyAttendanceOutcomeVo) map.getValueObject(domainObject, ims.emergency.vo.EmergencyAttendanceOutcomeVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.emergency.vo.EmergencyAttendanceOutcomeVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.admin.domain.objects.EmergencyAttendance
	 */
	 public static ims.emergency.vo.EmergencyAttendanceOutcomeVo insert(ims.emergency.vo.EmergencyAttendanceOutcomeVo valueObject, ims.core.admin.domain.objects.EmergencyAttendance domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.admin.domain.objects.EmergencyAttendance
	 */
	 public static ims.emergency.vo.EmergencyAttendanceOutcomeVo insert(DomainObjectMap map, ims.emergency.vo.EmergencyAttendanceOutcomeVo valueObject, ims.core.admin.domain.objects.EmergencyAttendance domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_EmergencyAttendance(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// EmergencyEpisode
		valueObject.setEmergencyEpisode(ims.emergency.vo.domain.EmergencyEpisode_CatetoryOnlyVoAssembler.create(map, domainObject.getEmergencyEpisode()) );
		// ConclusionDateTime
		java.util.Date ConclusionDateTime = domainObject.getConclusionDateTime();
		if ( null != ConclusionDateTime ) 
		{
			valueObject.setConclusionDateTime(new ims.framework.utils.DateTime(ConclusionDateTime) );
		}
		// BedTypeRequested
		ims.domain.lookups.LookupInstance instance3 = domainObject.getBedTypeRequested();
		if ( null != instance3 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance3.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance3.getImage().getImageId(), instance3.getImage().getImagePath());
			}
			color = instance3.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.BedTypeRequested voLookup3 = new ims.core.vo.lookups.BedTypeRequested(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.core.vo.lookups.BedTypeRequested parentVoLookup3 = voLookup3;
			ims.domain.lookups.LookupInstance parent3 = instance3.getParent();
			while (parent3 != null)
			{
				if (parent3.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent3.getImage().getImageId(), parent3.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent3.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup3.setParent(new ims.core.vo.lookups.BedTypeRequested(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setBedTypeRequested(voLookup3);
		}
				// Outcome
		ims.domain.lookups.LookupInstance instance4 = domainObject.getOutcome();
		if ( null != instance4 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance4.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance4.getImage().getImageId(), instance4.getImage().getImagePath());
			}
			color = instance4.getColor();
			if (color != null) 
				color.getValue();

			ims.emergency.vo.lookups.AttendanceOutcome voLookup4 = new ims.emergency.vo.lookups.AttendanceOutcome(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.emergency.vo.lookups.AttendanceOutcome parentVoLookup4 = voLookup4;
			ims.domain.lookups.LookupInstance parent4 = instance4.getParent();
			while (parent4 != null)
			{
				if (parent4.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent4.getImage().getImageId(), parent4.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent4.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup4.setParent(new ims.emergency.vo.lookups.AttendanceOutcome(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setOutcome(voLookup4);
		}
				// Destination
		valueObject.setDestination(domainObject.getDestination());
		// Patient
		valueObject.setPatient(ims.core.vo.domain.Patient_DODVoAssembler.create(map, domainObject.getPatient()) );
		// DischargeDateTime
		java.util.Date DischargeDateTime = domainObject.getDischargeDateTime();
		if ( null != DischargeDateTime ) 
		{
			valueObject.setDischargeDateTime(new ims.framework.utils.DateTime(DischargeDateTime) );
		}
		// CareContext
		valueObject.setCareContext(ims.core.vo.domain.CareContextForAttendanceOutcomeVoAssembler.create(map, domainObject.getCareContext()) );
		// RegistrationDateTime
		java.util.Date RegistrationDateTime = domainObject.getRegistrationDateTime();
		if ( null != RegistrationDateTime ) 
		{
			valueObject.setRegistrationDateTime(new ims.framework.utils.DateTime(RegistrationDateTime) );
		}
		// DischargingHCP
		valueObject.setDischargingHCP(ims.core.vo.domain.AuthoringInformationVoAssembler.create(map, domainObject.getDischargingHCP()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.admin.domain.objects.EmergencyAttendance extractEmergencyAttendance(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.EmergencyAttendanceOutcomeVo valueObject) 
	{
		return 	extractEmergencyAttendance(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.admin.domain.objects.EmergencyAttendance extractEmergencyAttendance(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.EmergencyAttendanceOutcomeVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_EmergencyAttendance();
		ims.core.admin.domain.objects.EmergencyAttendance domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.admin.domain.objects.EmergencyAttendance)domMap.get(valueObject);
			}
			// ims.emergency.vo.EmergencyAttendanceOutcomeVo ID_EmergencyAttendance field is unknown
			domainObject = new ims.core.admin.domain.objects.EmergencyAttendance();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_EmergencyAttendance());
			if (domMap.get(key) != null)
			{
				return (ims.core.admin.domain.objects.EmergencyAttendance)domMap.get(key);
			}
			domainObject = (ims.core.admin.domain.objects.EmergencyAttendance) domainFactory.getDomainObject(ims.core.admin.domain.objects.EmergencyAttendance.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_EmergencyAttendance());

		domainObject.setEmergencyEpisode(ims.emergency.vo.domain.EmergencyEpisode_CatetoryOnlyVoAssembler.extractEmergencyEpisode(domainFactory, valueObject.getEmergencyEpisode(), domMap));
		ims.framework.utils.DateTime dateTime2 = valueObject.getConclusionDateTime();
		java.util.Date value2 = null;
		if ( dateTime2 != null ) 
		{
			value2 = dateTime2.getJavaDate();
		}
		domainObject.setConclusionDateTime(value2);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getBedTypeRequested() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getBedTypeRequested().getID());
		}
		domainObject.setBedTypeRequested(value3);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getOutcome() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getOutcome().getID());
		}
		domainObject.setOutcome(value4);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDestination() != null && valueObject.getDestination().equals(""))
		{
			valueObject.setDestination(null);
		}
		domainObject.setDestination(valueObject.getDestination());
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.patient.domain.objects.Patient value6 = null;
		if ( null != valueObject.getPatient() ) 
		{
			if (valueObject.getPatient().getBoId() == null)
			{
				if (domMap.get(valueObject.getPatient()) != null)
				{
					value6 = (ims.core.patient.domain.objects.Patient)domMap.get(valueObject.getPatient());
				}
			}
			else
			{
				value6 = (ims.core.patient.domain.objects.Patient)domainFactory.getDomainObject(ims.core.patient.domain.objects.Patient.class, valueObject.getPatient().getBoId());
			}
		}
		domainObject.setPatient(value6);
		ims.framework.utils.DateTime dateTime7 = valueObject.getDischargeDateTime();
		java.util.Date value7 = null;
		if ( dateTime7 != null ) 
		{
			value7 = dateTime7.getJavaDate();
		}
		domainObject.setDischargeDateTime(value7);
		domainObject.setCareContext(ims.core.vo.domain.CareContextForAttendanceOutcomeVoAssembler.extractCareContext(domainFactory, valueObject.getCareContext(), domMap));
		ims.framework.utils.DateTime dateTime9 = valueObject.getRegistrationDateTime();
		java.util.Date value9 = null;
		if ( dateTime9 != null ) 
		{
			value9 = dateTime9.getJavaDate();
		}
		domainObject.setRegistrationDateTime(value9);
		domainObject.setDischargingHCP(ims.core.vo.domain.AuthoringInformationVoAssembler.extractAuthoringInformation(domainFactory, valueObject.getDischargingHCP(), domMap));

		return domainObject;
	}

}
