/*******************************************************************************
 * Copyright (c) Intel Corporation
 * Copyright (c) 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.osc.core.broker.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.osc.core.broker.service.api.ListApplianceModelSwVersionComboServiceApi;
import org.osc.core.broker.service.dto.ApplianceModelSoftwareVersionDto;
import org.osc.core.broker.service.persistence.ApplianceSoftwareVersionEntityMgr;
import org.osc.core.broker.service.request.ListApplianceModelSwVersionComboRequest;
import org.osc.core.broker.service.response.ListResponse;
import org.osgi.service.component.annotations.Component;

@Component
public class ListApplianceModelSwVersionComboService extends
ServiceDispatcher<ListApplianceModelSwVersionComboRequest, ListResponse<ApplianceModelSoftwareVersionDto>>
implements ListApplianceModelSwVersionComboServiceApi {

    ListResponse<ApplianceModelSoftwareVersionDto> response = new ListResponse<ApplianceModelSoftwareVersionDto>();

    @Override
    public ListResponse<ApplianceModelSoftwareVersionDto> exec(ListApplianceModelSwVersionComboRequest request,
            EntityManager em) {

        List<ApplianceModelSoftwareVersionDto> ls = ApplianceSoftwareVersionEntityMgr.findByMcType(em, request.getType());
        this.response.setList(ls);

        return this.response;

    }

}
