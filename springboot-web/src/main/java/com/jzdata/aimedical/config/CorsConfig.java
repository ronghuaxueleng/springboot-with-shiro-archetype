package com.jzdata.aimedical.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域访问支持
 *
 * @author caoqiang
 * @date 2020/1/7 0007下午 15:17
 */
@Configuration
public class CorsConfig {
  private CorsConfiguration buildConfig() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    //放行哪些原始域
    corsConfiguration.addAllowedOrigin("*");
    //是否发送Cookie信息
    corsConfiguration.setAllowCredentials(true);
    //放行哪些原始域(请求方式)
    corsConfiguration.addAllowedMethod("*");
    //放行哪些原始域(头部信息)
    corsConfiguration.addAllowedHeader("*");
    //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
    corsConfiguration.addExposedHeader("Content-Type");

    return corsConfiguration;
  }

  @Bean
  public FilterRegistrationBean<CorsFilter> corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", buildConfig());
    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
    // 这个顺序很重要哦，为避免麻烦请设置在最前
    bean.setOrder(0);
    return bean;
  }
}
