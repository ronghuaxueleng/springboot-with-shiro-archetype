#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.enumhandle;

/**
 * @author: caoqiang
 * @create: 2019-05-17 18:17
 **/
public class CodeEnumUtil {

  public static <E extends Enum<?> & BaseEnum> E codeOf(Class<E> enumClass, int code) {
    E[] enumConstants = enumClass.getEnumConstants();
    for (E e : enumConstants) {
      if (e.getValue() == code) {
        return e;
      }
    }
    return null;
  }
}
