package com.airui.restfulcrud.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 国际化
 *      可以在连接上携带国际化区域信息
 * @author dangbaoqi
 * @date 2019/10/30-12:25
 */
@Configuration
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String local = request.getParameter("local");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(local)){
            String[] split = local.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
