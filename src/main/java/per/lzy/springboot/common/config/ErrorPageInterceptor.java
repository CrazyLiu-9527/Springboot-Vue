package per.lzy.springboot.common.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 使用拦截器拦截错误并重定向
 * 第一个if判断在内置tomcat中有效，但是打成war包部署在tomcat中response.getStatus()的值始终是200
 * @author zhiyuanliu
 * @date 2020/7/6 17:30
 */
@Component
public class ErrorPageInterceptor extends HandlerInterceptorAdapter {
    private static List<Integer> errorCodeList = Arrays.asList(404, 500);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (errorCodeList.contains(response.getStatus())) {
            //捕获异常后进行重定向，controller对应的requestMapping
            response.sendRedirect("/");
            return false;
        }
        if ("/error".equals(request.getRequestURI())) {
            response.sendRedirect("/");
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
