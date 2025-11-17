package org.wendu.dye.common.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {


    public static <T> Page getPage(PageParam pageParam,QueryAction<T> queryAction){

        //QueryAction将是一个接口，设想该接口有一个方法executeQuery负责执行查询
        // 在MyBatis映射器执行查询前设置分页参数（PageParam）对象（请求页码和每页记录数）
        //  分页参数应当从页面传来，而页面传来的数据都封装在 EmpQueryDto对象，
        //  所以EmpQueryDto对象中应当放有分页参数（pageNum和pageSize）
        //  具体做法：让EmpQueryDto类继承PageParam类即可

        PageHelper.startPage(pageParam);//这句代码必须紧挨，并在映射器查询之前
        List<T> list = queryAction.executeQuery();//执行映射器查询方法
        //PageHelper提供的分页数据的封装对象，但是不一定符合我们的格式需要，往往需要转换
        PageInfo<T> pageInfo = new PageInfo<>(list);//此行代码必须紧挨查询之后

        Page page = new Page();
        page.setCurrent(pageInfo.getPageNum());//当前页
        page.setFirst(1);//首页
        page.setPrev(pageInfo.getPrePage());//上一页
        page.setNext(pageInfo.getNextPage());//下一页
        page.setLast(pageInfo.getPages());//最后一页
        page.setTotal((int)pageInfo.getTotal());//总记录数
        page.setPages(pageInfo.getPages());//总页数
        page.setPageSize(pageInfo.getPageSize());//每页允许最大记录数
        page.setCurrentSize(pageInfo.getSize());//当前页实际记录数
        page.setList(pageInfo.getList());//当前页是数据记录
        return page;
    }

    private int current;//当前页码
    private int prev;//上一页页码
    private int next;//下一页页码
    private int first;//首页页码
    private int last;//尾页页码

    private int total;//总记录数
    private int pages;//总页数

    private int pageSize;//每页允许最大记录数
    private int currentSize;//当前页实际记录数

    private List<T> list; //当前页数据记录

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
