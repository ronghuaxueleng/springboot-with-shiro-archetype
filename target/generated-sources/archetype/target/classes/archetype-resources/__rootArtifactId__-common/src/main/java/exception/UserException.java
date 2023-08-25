#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

/**
 * 用户异常
 * @author Ye Feng
 * @date 2020/2/3 18:54
 */
public class UserException extends SystemException{
  public UserException(String errorMsg){
    super(errorMsg);
  }

  public UserException(int errorCode, String errorMsg){
    super(errorCode, errorMsg);
  }
}
