#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 在web的配置文件中，实例化登陆的拦截器，并添加规则
 *
 * @author caoqiang
 * @date 2020/1/7 0007下午 15:19
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

  /**
   * 添加静态资源文件，外部可以直接访问地址
   * 这个配置在前后端分离的情况下没啥用，因为没有静态资源
   *
   * @param registry
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
  }

  /**
   * 将字符串类型的数据，NULL转换成空字符串
   *
   * @param converters
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.removeIf(converter -> converter instanceof MappingJackson2HttpMessageConverter);

    FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
    //自定义配置...
    FastJsonConfig fastJsonConfig = new FastJsonConfig();

    fastJsonConfig.setSerializerFeatures(
            // List类型字段为null时输出[]而非null
            SerializerFeature.WriteNullListAsEmpty,
            // 输出为Null的字段
            SerializerFeature.WriteMapNullValue,
            // 数值字段如果为null,输出为0,而非null
            SerializerFeature.WriteNullNumberAsZero,
            // Null结果转为""
            SerializerFeature.WriteNullStringAsEmpty,
            // 时间格式yyyy-MM-dd HH: mm: ss  -- 会自动转换时间戳. 前端不需要将时间戳转换为date, 去除此配置
            // SerializerFeature.WriteDateUseDateFormat,
            // 禁用循环引用检测
            SerializerFeature.DisableCircularReferenceDetect
    );
    //3处理中文乱码问题
    List<MediaType> fastMediaTypes = new ArrayList<>();
    fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
    //4.在convert中添加配置信息.
    fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
    fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

    List<MediaType> supportedMediaTypes = new ArrayList<>();
    supportedMediaTypes.add(MediaType.APPLICATION_JSON);
    supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
    supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
    supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
    supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
    supportedMediaTypes.add(MediaType.APPLICATION_PDF);
    supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
    supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
    supportedMediaTypes.add(MediaType.APPLICATION_XML);
    supportedMediaTypes.add(MediaType.IMAGE_GIF);
    supportedMediaTypes.add(MediaType.IMAGE_JPEG);
    supportedMediaTypes.add(MediaType.IMAGE_PNG);
    supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
    supportedMediaTypes.add(MediaType.TEXT_HTML);
    supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
    supportedMediaTypes.add(MediaType.TEXT_PLAIN);
    supportedMediaTypes.add(MediaType.TEXT_XML);
    fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
    converters.add(fastJsonHttpMessageConverter);
  }
}
