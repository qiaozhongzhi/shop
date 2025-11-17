package org.wendu.dye.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.wendu.dye.serviceapi.BaseApi;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//将该注解注释掉，过滤器将不起作用
@WebFilter("/*")//配置本过滤器对所有的路径进行过滤
@Slf4j
public class SecurityFilter implements Filter {

    @Autowired
    private BaseApi baseApi;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info(this.getClass().getName()+"：初始化了！");


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String path = req.getServletPath();
        //log.info("path==="+path);

        /*
            无条件放行的地址：/login
         */
        if("/login".equals(path)){
            //放行（不拦截）
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //获取请求头名称为Token的信息(即客户端Token)
        String  clientToken = req.getHeader(DyeConstants.HEADER_NAME_TOKEN);

        //校验客户端token

        Result result = baseApi.verifyToken(clientToken);
        if(result.isSuccess()){
            //校验通过
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);//将result对象转成json串
        out.print(json);
        out.flush();
        out.close();

    }
}
