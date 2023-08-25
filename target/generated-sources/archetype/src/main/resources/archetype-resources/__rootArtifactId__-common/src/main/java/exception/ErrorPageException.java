#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

/**
 * 抛此异常，跳转到错误页
 *
 * @author caoqiang
 * @date 2020/1/7 0007下午 15:37
 */
public class ErrorPageException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  private Integer code = 500;
  private String msg = "未知错误";

  public ErrorPageException(Integer code, String msg) {
    super(msg);
    this.code = code;
    this.msg = msg;
  }

  public ErrorPageException(Throwable throwable) {
    super(throwable);
  }

  public ErrorPageException(String msg) {
    super(msg);
    this.msg = msg;
  }

  public Integer getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  @Override
  public String toString() {
    return "MedicalErrorPageException{" +
            "code=" + code +
            ", msg='" + msg + '${symbol_escape}'' +
            '}';
  }
}
