#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

import java.lang.reflect.Type;

/**
 * @author Ye Feng
 * @date 2020/2/19 11:15
 * json操作工具类
 */
public class JsonUtils {
  /**
   *将json字符串解析成相应对象
   * @param jsonStr json字符串
   * @param type
   * @param <T>
   * @return
   */
  public static <T> T parseString(String jsonStr, Type type){
    T result = null;
    if(null != jsonStr){
      result = JSON.parseObject(jsonStr, type,
              Feature.AllowUnQuotedFieldNames,
              // 自动关闭流
              Feature.AutoCloseSource,
              // 允许注释
              Feature.AllowComment,
              // 允许单引号
              Feature.AllowSingleQuotes,
              // 使用 Big decimal
              Feature.UseBigDecimal
      );
    }
    return result;
  }
}
