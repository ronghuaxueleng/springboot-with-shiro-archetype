#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.vo;

import ${package}.exception.CodeConstant;
import lombok.Data;

/**
 * 返回结果封装
 *
 * @author caoqiang
 * @date 2020/1/7 0007下午 15:39
 */
@Data
public class RestResponse {
  /**
   * 返回结果
   */
  private Object data;
  /**
   * error code
   */
  private int code = CodeConstant.SUCCESS;
  /**
   * 错误信息
   */
  private String message = "success";

  public static RestResponse success() {
    return new RestResponse();
  }

  public static RestResponse failed(String message) {
    return new RestResponse().setCode(CodeConstant.FAILE).setMessage(message);
  }

  public static RestResponse success(String message) {
    return new RestResponse().setMessage(message);
  }

  public RestResponse setCode(int code) {
    this.code = code;
    return this;
  }

  public RestResponse setMessage(String message) {
    this.message = message;
    return this;
  }

  public RestResponse setData(Object data) {
    this.data = data;
    return this;
  }
}
