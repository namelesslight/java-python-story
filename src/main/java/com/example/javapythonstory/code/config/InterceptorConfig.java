package com.example.javapythonstory.code.config;

import com.example.javapythonstory.code.interceptor.CommonInterceptor;
import com.example.javapythonstory.code.interceptor.CorsInterceptor;
import com.example.javapythonstory.code.interceptor.SuperInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置需要用户权限的路径
        String[] commonPathPatterns = {
                "/user/common/**",
                "/direction/common/**",
                "/code/common/**",
                "/model/common/**",
                "/article/common/**",
                "/resource/common/**",
                "/note/common/**",
                "/video/common/**",
                "/question/common/**",
                "/select/common/**",
                "/book/common/**",
                "/news/common/**"
        };

        //配置需要管理员权限的路径
        String[] superPathPatterns = {
                "/user/super/**",
                "/direction/super/**",
                "/model/super/**",
                "/article/super/**",
                "/video/super/**",
                "/question/super/**",
                "/select/super/**",
                "/book/super/**",
                "/news/super/**"
        };
        //配置不需要拦截的路径
        String[] excludePathPatterns = {
                "/user/base/**",
                "/base/**",
                "/code/base/**",
                "/article/base/**",
                "/video/base/**",
                "/direction/base/**",
        };
        registry.addInterceptor(new SuperInterceptor())
                .addPathPatterns(superPathPatterns)
                .excludePathPatterns(excludePathPatterns);
        registry.addInterceptor(new CommonInterceptor())
                .addPathPatterns(commonPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}
