#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

/**
 * 对象不存在
 *
 * @author caoqiang
 * @date 2020/1/9 0009下午 17:24
 */
public class ObjectNotFindException extends SystemException {

  public ObjectNotFindException(String errorMsg) {
    super(CodeConstant.DATA_IS_NOT_EXIST_ERROR, String.format(ExceptionConsts.DATA_IS_NOT_EXIST_ERROR, errorMsg));
  }
}
