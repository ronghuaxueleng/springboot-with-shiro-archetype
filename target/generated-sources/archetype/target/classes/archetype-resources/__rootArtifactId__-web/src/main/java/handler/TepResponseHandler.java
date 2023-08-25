#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.handler;


import ${package}.vo.RestResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 对返回数据进行封装
 */
@ControllerAdvice
public class TepResponseHandler implements ResponseBodyAdvice {

  /**
   * 用于可以根据方法类型和Controller名，确定进行返回数据包装的scope。
   *
   * @param methodParameter
   * @param aClass
   * @return
   */
  @Override
  public boolean supports(MethodParameter methodParameter, Class aClass) {
    return true;
  }

  /**
   * 将返回数据包装成{@link RestResponse}
   *
   * @param data
   * @param methodParameter
   * @param mediaType
   * @param aClass
   * @param serverHttpRequet
   * @param serverHttpResponse
   * @return
   */
  @Override
  public Object beforeBodyWrite(Object data, MethodParameter methodParameter,
                                MediaType mediaType, Class aClass,
                                ServerHttpRequest serverHttpRequet,
                                ServerHttpResponse serverHttpResponse) {
    if (data instanceof String) {
      serverHttpResponse.getHeaders().add("Content-Type",
              "application/json");
    }
    return ResponseWrapUtils.wrapResponse(data);
  }
}
