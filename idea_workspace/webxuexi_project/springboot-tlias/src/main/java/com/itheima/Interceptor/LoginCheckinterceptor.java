package com.itheima.Interceptor;

//拦截器实现

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.itheima.Pojo.Result;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Component
public class LoginCheckinterceptor implements HandlerInterceptor {
    @Override//会在目标资源方法运行前运行，返回true 代表放行，返回false 代表不放行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //1、获取请求url
        String url = req.getRequestURI().toString();
        log.info("请求的url：{}",url);

        //2、判断请求的url中是否有login，如果有 则说明是登录操作。放行
        if(url.contains("login")){
            log.info("登录操作，可以放行");
            return true;
        }

        //3、获取请求头中的令牌
        String jwt = req.getHeader("token");

        if (!StringUtils.hasLength(jwt)){
            log.info("token为空，不可放行");
            Result error = Result.error("NOT_LOGIN");
            String NoLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(NoLogin);
            return false;
        }

//        解析失败也不可放行
        try{
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            String NotLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(NotLogin);
            return false;
        }

        //令牌合法就放行
        log.info("令牌合法，放行");
        return true;

    }

    @Override//会在目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle运行");

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override//视图渲染完毕后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion运行");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
