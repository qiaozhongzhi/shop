package org.wendu.dye.common.page;

/**
 * 分页参数对象
 */
public class PageParam {

    private int pageNum=1;//请求页码
    private int pageSize=5;//每页最大记录数

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
