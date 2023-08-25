#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

import lombok.Getter;

/**
 * 业务异常基类，其他业务异常需要继承次类
 */
@Getter
public abstract class SystemException extends RuntimeException {

  private static final long serialVersionUID = 424646336423235612L;

  /**
   * 错误码
   */
  private int errorCode;
  /**
   * 错误信息
   */
  private String errorMsg;

  public SystemException(String errorMsg) {
    super(errorMsg);
    this.errorMsg = errorMsg;
  }

  public SystemException(int errorCode, String errorMsg) {
    super(errorMsg);
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public SystemException(String errorMsg, Throwable cause) {
    super(errorMsg, cause);
    this.errorMsg = errorMsg;
  }
}
