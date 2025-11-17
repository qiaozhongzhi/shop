package org.wendu.dye.info.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wendu.dye.common.DataStatusEnum;
import org.wendu.dye.common.InfoTypeEnum;
import org.wendu.dye.common.page.Page;
import org.wendu.dye.dto.InfoAddUpdDto;
import org.wendu.dye.dto.InfoQueryDto;
import org.wendu.dye.exception.BusinessException;
import org.wendu.dye.exception.SysExceptioin;
import org.wendu.dye.info.InfoDao;
import org.wendu.dye.info.InfoService;
import org.wendu.dye.model.Info;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoDao infoDao;


    @Override
    public Page getPage(InfoQueryDto infoQueryDto) {


        return Page.getPage(infoQueryDto,()->infoDao.findList(infoQueryDto));

    }

    @Override
    public void addOne(InfoAddUpdDto infoAddUpdDto) {

        try {
            infoAddUpdDto.setInfo_id(UUID.randomUUID().toString().replace("-", ""));
            infoAddUpdDto.setInfo_status(DataStatusEnum.UNDETERMINED.getCode());
            infoDao.insertInfo(infoAddUpdDto);
        } catch (Exception e) {
            throw new SysExceptioin("系统错误！",e);
        }

    }

    @Override
    public void removeByIds(int info_type,String... ids) {
        if(ids == null || ids.length == 0){
            throw new BusinessException("没有需要删除信息的编号！");
        }
        try {
            infoDao.deleteInfo(info_type,ids);
        } catch (Exception e) {
            throw new SysExceptioin("系统错误！",e);
        }
    }


    @Override
    public void updateInfo(InfoAddUpdDto infoAddUpdDto) {
        try {
            infoAddUpdDto.setInfo_status(DataStatusEnum.UNDETERMINED.getCode());
            infoDao.updateInfo(infoAddUpdDto);
        } catch (Exception e) {
            throw new SysExceptioin("系统错误！",e);
        }
    }

    private String getInfoTypeName(int info_type){
        switch(info_type){
            case 1: return "客户信息";
            case 2: return "规格信息";
            case 3: return "花色号信息";
            default: return null;
        }
    }

    @Override
    public String execChangeStatus(int info_type,String info_id, String currentStatus) {
        String targetStatus = null;
        String msg = null;
        if(DataStatusEnum.UNDETERMINED.getCode().equals(currentStatus)){
            targetStatus = DataStatusEnum.DETERMINED.getCode();
            msg = getInfoTypeName(info_type)+"确定成功！";
        }else if(DataStatusEnum.DETERMINED.getCode().equals(currentStatus)){
            targetStatus = DataStatusEnum.ACTIVED.getCode();
            msg = getInfoTypeName(info_type)+"启用成功！";
        }else if(DataStatusEnum.ACTIVED.getCode().equals(currentStatus)){
            targetStatus = DataStatusEnum.DISABLED.getCode();
            msg = getInfoTypeName(info_type)+"禁用成功！";
        }else if(DataStatusEnum.DISABLED.getCode().equals(currentStatus)){
            targetStatus = DataStatusEnum.ACTIVED.getCode();
            msg = getInfoTypeName(info_type)+"启用成功！";
        }
        if(targetStatus == null)throw new BusinessException("用户当前状态不正确！");
        int n = infoDao.updateStatus(info_id,currentStatus,targetStatus);
        if(n>0){
            return msg;
        }
        throw new BusinessException("更新"+info_id+"状态不失败！");
    }

}
