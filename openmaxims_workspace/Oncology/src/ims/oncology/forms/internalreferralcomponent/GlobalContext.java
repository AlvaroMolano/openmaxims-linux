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

package ims.oncology.forms.internalreferralcomponent;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		CareUk = new CareUkContext(context);
		Oncology = new OncologyContext(context);
		Clinical = new ClinicalContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPrepareForPrintingIsNotNull()
		{
			return !cx_CorePrepareForPrinting.getValueIsNull(context);
		}
		public Boolean getPrepareForPrinting()
		{
			return (Boolean)cx_CorePrepareForPrinting.getValue(context);
		}
		public void setPrepareForPrinting(Boolean value)
		{
			cx_CorePrepareForPrinting.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePrepareForPrinting = new ims.framework.ContextVariable("Core.PrepareForPrinting", "_cv_Core.PrepareForPrinting");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}
	public final class CareUkContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CareUkContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getIsComponentInEditModeIsNotNull()
		{
			return !cx_CareUkIsComponentInEditMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getIsComponentInEditMode()
		{
			return (ims.framework.enumerations.FormMode)cx_CareUkIsComponentInEditMode.getValue(context);
		}
		public void setIsComponentInEditMode(ims.framework.enumerations.FormMode value)
		{
			cx_CareUkIsComponentInEditMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkIsComponentInEditMode = new ims.framework.ContextVariable("CareUk.IsComponentInEditMode", "_cv_CareUk.IsComponentInEditMode");

		private ims.framework.Context context;
	}
	public final class OncologyContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OncologyContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getEpisodeOfCareDateIsNotNull()
		{
			return !cx_OncologyEpisodeOfCareDate.getValueIsNull(context);
		}
		public ims.framework.utils.Date getEpisodeOfCareDate()
		{
			return (ims.framework.utils.Date)cx_OncologyEpisodeOfCareDate.getValue(context);
		}
		public void setEpisodeOfCareDate(ims.framework.utils.Date value)
		{
			cx_OncologyEpisodeOfCareDate.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologyEpisodeOfCareDate = new ims.framework.ContextVariable("Oncology.EpisodeOfCareDate", "_cv_Oncology.EpisodeOfCareDate");
		public boolean getInternalReferralRefIsNotNull()
		{
			return !cx_OncologyInternalReferralRef.getValueIsNull(context);
		}
		public ims.oncology.vo.InternalReferralRefVo getInternalReferralRef()
		{
			return (ims.oncology.vo.InternalReferralRefVo)cx_OncologyInternalReferralRef.getValue(context);
		}
		public void setInternalReferralRef(ims.oncology.vo.InternalReferralRefVo value)
		{
			cx_OncologyInternalReferralRef.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologyInternalReferralRef = new ims.framework.ContextVariable("Oncology.InternalReferralRef", "_cv_Oncology.InternalReferralRef");

		private ims.framework.Context context;
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

			PatientSummary = new PatientSummaryContext(context);
		}
		public final class PatientSummaryContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PatientSummaryContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getEpisodeOfCareIsNotNull()
			{
				return !cx_ClinicalPatientSummaryEpisodeOfCare.getValueIsNull(context);
			}
			public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
			{
				return (ims.core.admin.vo.EpisodeOfCareRefVo)cx_ClinicalPatientSummaryEpisodeOfCare.getValue(context);
			}
		public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
		{
				cx_ClinicalPatientSummaryEpisodeOfCare.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientSummaryEpisodeOfCare = new ims.framework.ContextVariable("Clinical.PatientSummary.EpisodeOfCare", "_cv_Clinical.PatientSummary.EpisodeOfCare");
			private ims.framework.Context context;
		}


		public PatientSummaryContext PatientSummary;
		private ims.framework.Context context;
	}

	public CoreContext Core;
	public CareUkContext CareUk;
	public OncologyContext Oncology;
	public ClinicalContext Clinical;
}
