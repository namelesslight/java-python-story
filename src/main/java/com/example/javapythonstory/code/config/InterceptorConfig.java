package com.example.javapythonstory.code.config;

import com.example.javapythonstory.code.interceptor.CommonInterceptor;
import com.example.javapythonstory.code.interceptor.SuperInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置需要拦截的路径
        String[] commonPathPatterns = {
                "/user/common/**",
                "/direction/common/**",
                "/code/common/**",
                "/model/common/**",
                "/article/common/**"
        };

        String[] superPathPatterns = {
                "/user/super/**",
                "/direction/super/**",
                "/model/super/**",
                "/article/super/**"
        };
        //配置不需要拦截的路径
        String[] excludePathPatterns = {
                "/user/base/**",
                "/base/**",
                "/code/base/**"
        };
        registry.addInterceptor(new SuperInterceptor())
                .addPathPatterns(superPathPatterns)
                .excludePathPatterns(excludePathPatterns);

        registry.addInterceptor(new CommonInterceptor())
                .addPathPatterns(commonPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}
