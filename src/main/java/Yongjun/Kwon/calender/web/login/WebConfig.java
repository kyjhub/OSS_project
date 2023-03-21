package Yongjun.Kwon.calender.web.login;

import Yongjun.Kwon.calender.web.interceptor.LogInterceptor;
import Yongjun.Kwon.calender.web.interceptor.LoginCheckInterceptor;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error", "/js/**");

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/home", "/login", "/logout",
                        "/css/**", "/*.ico", "/error", "/js/**",
                        "/members/new");
    }
}

