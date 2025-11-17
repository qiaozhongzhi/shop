package org.wendu.dye.info;

import org.wendu.dye.common.page.Page;
import org.wendu.dye.dto.InfoAddUpdDto;
import org.wendu.dye.dto.InfoQueryDto;
import org.wendu.dye.model.Info;

import java.util.List;

public interface InfoService {

    Page getPage(InfoQueryDto infoQueryDto);

    void addOne(InfoAddUpdDto infoAddUpdDto);

    void removeByIds(int info_type,String... ids);

    void updateInfo(InfoAddUpdDto infoAddUpdDto);

    String execChangeStatus(int info_type,String info_id, String currentStatus);

}
