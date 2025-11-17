package org.wendu.dye.plan.service;

import org.wendu.dye.common.page.Page;
import org.wendu.dye.model.DyePlan;
import org.wendu.dye.plan.dto.PlanDto;
import org.wendu.dye.plan.dto.PlanQueryDto;

public interface ManagerService {

    public Page<DyePlan> getPage(PlanQueryDto dto);

    Integer getXh(PlanQueryDto dto);

    void saveNewPlan(PlanDto dto);

    void updatePlan(PlanDto dto);

    void execDel(String... ids);

    void execConfirm(Long id, String token);
}
