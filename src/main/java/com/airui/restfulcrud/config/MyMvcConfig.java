package com.airui.restfulcrud.config;

import com.airui.restfulcrud.component.LoginHandlerInterceptor;
import com.airui.restfulcrud.component.MyLocaleResolver;
import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dangbaoqi
 * @date 2019/10/30-10:37
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    //将组件注册在容器中
    @Bean
    //所有的WebMvcAutoConfiguration组件会一起起作用
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer  =  new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/main").setViewName("dashboard");
                registry.addViewController("/main.html").setViewName("dashboard");
            }


            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //springBoot已经做好了静态资源的映射  所以不必考虑静态资源
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login.html","/login","/","/user/login","/asserts/**","/webjars/**");
            }
        };
        return configurer;
    }

    @Bean
    public LocaleResolver localResolver(){
        return new MyLocaleResolver();
    }


}
