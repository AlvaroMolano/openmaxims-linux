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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.30 build 2043.20884)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import ims.domain.impl.DomainImpl;
import ims.framework.interfaces.IAppRole;
import ims.ocrr.domain.OrderEntryTemplateEdit;
import ims.ocrr.domain.SelectandOrder;
import ims.ocrr.vo.OrderEntryTemplateVo;
import ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo;

public class OrderEntryTemplatePreviewImpl extends DomainImpl implements ims.ocrr.domain.OrderEntryTemplatePreview, ims.domain.impl.Transactional
{
	public OrderEntryTemplateVo getOrderEntryTemplate(Integer recordID) 
	{
		OrderEntryTemplateEdit impl = (OrderEntryTemplateEdit)getDomainImpl(OrderEntryTemplateEditImpl.class);
		return impl.getOrderEntryTemplate(recordID);
	}

	public RoleDisciplineSecurityLevelLiteGCVo getRoleDisciplineSecurityLevels(IAppRole role)
	{
		SelectandOrder impl = (SelectandOrder)getDomainImpl(SelectandOrderImpl.class);
		return impl.getRoleDisciplineSecurityLevels(role);
	}
}
