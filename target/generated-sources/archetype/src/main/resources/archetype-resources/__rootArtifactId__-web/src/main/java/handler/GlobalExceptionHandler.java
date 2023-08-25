#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.handler;

import ${package}.exception.ErrorPageException;
import ${package}.util.ExceptionHandlerUtils;
import ${package}.vo.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 被用于处理全局异常，由于正常情况下，异常应该被映射到错误代码
 *
 * @author caoqiang
 * @date 2020/1/7 0007下午 15:36
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  private String errorPage;

  @ExceptionHandler(value = ErrorPageException.class)
  @ResponseBody
  public void exceptionMethod(HttpServletRequest request, HttpServletResponse response, ErrorPageException errorPageException) throws Exception {
    log.error("异常--" ,errorPageException);
    request.getRequestDispatcher(errorPage).forward(request, response);
  }

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public RestResponse dealException(HttpServletRequest req, Throwable e) {
    log.error("system error-", e);
    return ExceptionHandlerUtils.restApiExceptionHandler(e);
  }
}
