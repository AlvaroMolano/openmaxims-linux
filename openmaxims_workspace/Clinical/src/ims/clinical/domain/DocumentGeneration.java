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

package ims.clinical.domain;

// Generated from form domain impl
public interface DocumentGeneration extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listClinicalCorrespondence
	*/
	public ims.clinical.vo.ClinicalCorrespondenceVo getLastClinicalCorrespondence(ims.core.admin.vo.CareContextRefVo careContext, ims.clinical.vo.lookups.ClinicalCorrespondenceType type, ims.core.admin.vo.ClinicalContactRefVo clinicalContact);

	// Generated from form domain interface definition
	/**
	* saveClinicalCorrespondence
	*/
	public ims.clinical.vo.ClinicalCorrespondenceVo saveClinicalCorrespondence(ims.clinical.vo.ClinicalCorrespondenceVo clinicalCorrespondence) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* listHCP
	*/
	public ims.core.vo.HcpLiteVoCollection listHCP(String name);

	// Generated from form domain interface definition
	/**
	* getPatient
	*/
	public ims.core.vo.Patient getPatient(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	/**
	* listProblemsByPatient
	*/
	public ims.core.vo.PatientProblemVoCollection listProblemsByPatient(ims.core.patient.vo.PatientRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* listDiagnosisComplicationsByPatient
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosisComplicationsByPatient(ims.core.patient.vo.PatientRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* listProceduresByPatient
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByPatient(ims.core.patient.vo.PatientRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* getLatestMedicationOverViewVo
	*/
	public ims.clinical.vo.MedicationOverViewVo getLatestMedicationOverViewVo(ims.clinical.vo.MedicationOverViewFilterVo filter);

	// Generated from form domain interface definition
	/**
	* getHcpById
	*/
	public ims.core.vo.HcpLiteVo getHcpById(ims.core.resource.people.vo.HcpRefVo hcpRefVo);

	// Generated from form domain interface definition
	/**
	* getOPDSummary
	*/
	public ims.clinical.vo.OutpatientNotesOutcomeVo getOPDSummary(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRefVo);

	// Generated from form domain interface definition
	/**
	* listAssignedReports
	*/
	public ims.admin.vo.ReportVoCollection listAssignedReports(Integer formId);

	// Generated from form domain interface definition
	/**
	* getReportAndTemplate
	*/
	public String[] getReportAndTemplate(Integer reportId, Integer templateId);

	// Generated from form domain interface definition
	/**
	* getClinicalNotesForContact
	*/
	public ims.core.vo.ClinicalNotesVo getClinicalNotesForContact(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRefId);

	// Generated from form domain interface definition
	/**
	* getClinicalNote
	*/
	public ims.core.vo.ClinicalNotesVo getClinicalNote(ims.core.clinical.vo.ClinicalNotesRefVo clinicalNoteRefVo);

	// Generated from form domain interface definition
	/**
	* getCareContextList
	*/
	public ims.core.vo.CareContextListVo getCareContextList(Integer id);

	// Generated from form domain interface definition
	/**
	* countClinicalCorrespondence
	*/
	public Integer countClinicalCorrespondence(ims.core.admin.vo.CareContextRefVo careContext, ims.clinical.vo.lookups.ClinicalCorrespondenceType type, ims.core.admin.vo.ClinicalContactRefVo clinicalContact);
}