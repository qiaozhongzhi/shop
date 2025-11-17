package org.wendu.dye.base.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wendu.dye.base.BaseDao;
import org.wendu.dye.base.BaseService;
import org.wendu.dye.common.DataStatusEnum;
import org.wendu.dye.model.Department;
import org.wendu.dye.model.Info;
import org.wendu.dye.model.ProcessDef;

import java.util.List;

@Service
@Transactional
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<Info> getInfoList(Integer info_type) {
        return baseDao.findInfoList(info_type, DataStatusEnum.ACTIVED.getCode());
    }

    @Override
    public List<Info> getInfoList() {
        return baseDao.findAllTypeInfoList(DataStatusEnum.ACTIVED.getCode());
    }

    @Override
    public List<ProcessDef> getProdessDefList() {
        return baseDao.findAllProcessDefList();
    }


}
