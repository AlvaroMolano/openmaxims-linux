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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.ocrr.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.ClinicLiteVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.domain.ClinicLiteVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.framework.interfaces.ILocation;
import ims.ocrr.domain.MyOrder;
import ims.ocrr.domain.base.impl.BaseNewResultsAllTabComponentImpl;

import java.util.ArrayList;
import java.util.List;

public class NewResultsAllTabComponentImpl extends BaseNewResultsAllTabComponentImpl
{
	private static final long serialVersionUID = 1L;

	public ims.core.vo.LocationLiteVoCollection listHospitals()
	{
		return listLocations(null, LocationType.HOSP);
	}
	
	private LocationLiteVoCollection listLocations(String name, LocationType locType)
	{
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		String hql = "from Location loc where (loc.type.id = :typeId";
		names.add("typeId");
		values.add(new Integer(locType.getId()));
		
		if (name != null)
		{
			hql += " and loc.upperName like :name ";
			names.add("name");
			values.add(name.toUpperCase() + "%");
		}
		hql += (" and loc.isVirtual = :virtual and loc.isActive = 1) order by loc.upperName asc");
		names.add("virtual");
		values.add(Boolean.FALSE);
		
		List<?> l = this.getDomainFactory().find(hql, names, values);
		return LocationLiteVoAssembler.createLocationLiteVoCollectionFromLocation(l);
	}

	public ims.core.vo.HcpLiteVoCollection listReviewingHCP(String name)
	{
		if (name == null || name.length() == 0)
			return null;
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		String query = "SELECT hcp FROM Hcp AS hcp LEFT JOIN hcp.mos AS mos WHERE (mos.name.upperSurname LIKE :HCP_NAME OR mos.name.upperForename LIKE :HCP_NAME) AND hcp.isActive = 1 AND hcp.hcpType.id = :MEDIC_TYPE ORDER BY mos.name.upperSurname";
		
		paramNames.add("HCP_NAME");
		paramValues.add(name.toUpperCase() + "%");
		
		paramNames.add("MEDIC_TYPE");
		paramValues.add(HcpDisType.MEDICAL.getID());
		
		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(getDomainFactory().find(query, paramNames, paramValues));
	}

	public LocationLiteVoCollection listWards(String name, LocationRefVo voLocRef) 
	{
		OrganisationAndLocation orgAdmin = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return orgAdmin.listActiveWardsForHospitalByNameLite(voLocRef, name);
	}

	public ClinicLiteVoCollection listClinics(String nameFilter, LocationRefVo voLocRef) 
	{
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		String prepend = " where ";
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer("from Clinic clin ");
		if (voLocRef != null)
		{
			hql.append(prepend + " clin.clinicLocation.id = :idLocation ");
			names.add("idLocation");
			values.add(voLocRef.getID_Location());
			prepend = " and ";
		}		
		if (nameFilter != null && nameFilter.length() > 0)
		{
			hql.append(prepend + " (upper(clin.clinicName) like :clinName) ");
			names.add("clinName");
			values.add("%" + nameFilter.toUpperCase() + "%");
			prepend = " and ";
		}
		
		hql.append(prepend + " clin.isActive = 1 ");
		
		List<?> clinics = factory.find(hql.toString(), names, values, 1000);
		return ClinicLiteVoAssembler.createClinicLiteVoCollectionFromClinic(clinics).sort(true);
	}

	public LocationLiteVoCollection listErDepts(String nameFilter, LocationRefVo voLocRef) 
	{
		OrganisationAndLocation orgAdmin = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return orgAdmin.listActiveAandEForHospitalByNameLite(voLocRef, nameFilter);
	}

	public LocationLiteVoCollection listOtherLocations(String nameFilter, LocationRefVo voLocRef) 
	{
		MyOrder myOrder = (MyOrder)getDomainImpl(MyOrderImpl.class);
		return myOrder.listUserEnteredLocationsForHospitalByNameLite(voLocRef, nameFilter);
	}

	public LocationLiteVoCollection listOutpatientDepartments(String name,	LocationRefVo hospital) 
	{
		OrganisationAndLocation orgAdmin = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return orgAdmin.listActiveOutpatDeptsForHospitalByNameLite(hospital, name);
	}

	//WDEV-17494
	public LocationLiteVo getCurrentHospital(ILocation currentLocation) 
	{
		if(currentLocation == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		Location currentHospital = getHospital((Location) factory.getDomainObject(Location.class, currentLocation.getID()));
		
		if(currentHospital instanceof Location)
			return LocationLiteVoAssembler.create((Location) currentHospital);
		
		return null;
	}
	
	private Location getHospital(Location doLocation)
	{
		if(doLocation == null)
			return null;
		
		if(doLocation instanceof Location && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
			return doLocation;
	
		while(doLocation.getParentLocation() != null) 
		{
			doLocation = doLocation.getParentLocation();
			if(doLocation instanceof Location && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
				return doLocation;
		}
		
		return null;
	}
}
