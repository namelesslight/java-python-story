package com.example.javapythonstory.code.config;

import com.example.javapythonstory.code.interceptor.RoleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置需要拦截的路径
        String[] pathPatterns = {"/**"};
        //配置不需要拦截的路径
        String[] excludePathPatterns = {"**/base/**"};
        registry.addInterceptor(new RoleInterceptor())
                .addPathPatterns(pathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}
