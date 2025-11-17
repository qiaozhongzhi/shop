package org.wendu.dye.plan.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wendu.dye.common.TokenUtils;
import org.wendu.dye.common.page.Page;
import org.wendu.dye.exception.BusinessException;
import org.wendu.dye.exception.SysExceptioin;
import org.wendu.dye.model.DyePlan;
import org.wendu.dye.plan.dao.ManagerDao;
import org.wendu.dye.plan.dto.PlanDto;
import org.wendu.dye.plan.dto.PlanQueryDto;
import org.wendu.dye.plan.service.ManagerService;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Transactional
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;


    private AtomicLong xh = new AtomicLong(System.currentTimeMillis());

    private Long getNewXh(){
       return xh.incrementAndGet();
    }

    @Override
    public Page<DyePlan> getPage(PlanQueryDto dto) {
        System.out.println(dto.getPlan_num_end()>1);
        return Page.getPage(dto,()->managerDao.findList(dto));
    }

    @Override
    public Integer getXh(PlanQueryDto dto) {
        return managerDao.findNewXh(dto);
    }

    @Override
    public void saveNewPlan(PlanDto dto) {

        dto.setPlan_id(getNewXh());
        dto.setPlan_status(false);
        managerDao.insertOne(dto);
    }

    @Override
    public void updatePlan(PlanDto dto) {
        managerDao.updateOne(dto);
    }

    @Override
    public void execDel(String... ids) {
        if(ids == null || ids.length == 0){
            throw new BusinessException("没有需要删除信息的编号！");
        }
        try {
            managerDao.deleteByIds(ids);
        } catch (Exception e) {
            throw new SysExceptioin("系统错误！",e);
        }
    }

    @Override
    public void execConfirm(Long id, String token) {
        managerDao.updateOne(
                new PlanDto()
                        .setPlan_id(id)
                        .setPlan_person(TokenUtils.getCurrentUser(token).getUserName())
                        .setPlan_date(new Date())
                        .setPlan_status(true)
        );
    }
}
