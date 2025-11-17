package org.wendu.dye.base;

import org.wendu.dye.model.Department;
import org.wendu.dye.model.Info;
import org.wendu.dye.model.ProcessDef;

import java.util.List;

public interface BaseService {


    List<Info> getInfoList(Integer info_type);

    List<Info> getInfoList();

    List<ProcessDef> getProdessDefList();
}
