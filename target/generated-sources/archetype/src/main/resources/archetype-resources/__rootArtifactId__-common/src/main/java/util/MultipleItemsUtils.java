#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 对包含多个值的字符串进行拆分
 * 或
 * 将多个值合并成一个字符串
 * @author Ye Feng
 * @date 2020/2/22 10:36
 */
public class MultipleItemsUtils {

  /**
   * 对包含多个值（值之间通过分隔符分隔）的字符串进行拆分
   * @param separator 分隔符
   * @param multipleItemsStr 需要拆分的字符串
   * @return
   */
  public static List separateStringToIntList(String separator, String multipleItemsStr) {
    List list = null;
    if(StringUtils.isNotBlank(multipleItemsStr)){
      list = new ArrayList<>();
      String[] arr = multipleItemsStr.split(separator);
      for(String item : arr){
        list.add(Integer.valueOf(item));
      }
    }
    return list;
  }

  /**
   * 对包含多个值（值之间通过分隔符分隔）的字符串进行拆分
   * @param separator 分隔符
   * @param multipleItemsStr 需要拆分的字符串
   * @return
   */
  public static List<String> separateStringToStrList(String separator, String multipleItemsStr) {
    List<String> list = null;
    if(StringUtils.isNotBlank(multipleItemsStr)){
      list = new ArrayList<>();
      String[] arr = multipleItemsStr.split(separator);
      for(String item : arr){
        list.add(item);
      }
    }
    return list;
  }

  /**
   * 将ist中的多个整型值合并成一个字符串（通过分隔符分隔）
   * @param separator 分隔符
   * @param list
   * @return
   */
  public static String mergeIntList(String separator, List list) {
    String mergedStr = null;
    if(CollectionUtils.isNotEmpty(list)){
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<list.size(); i++){
        sb.append(list.get(i));
        if(i != list.size() - 1){
          sb.append(separator);
        }
      }
      mergedStr = sb.toString();
    }
    return mergedStr;
  }

  /**
   * 将ist中的多个字符串类型值合并成一个字符串（通过分隔符分隔）
   * @param separator 分隔符
   * @param list
   * @return
   */
  public static String mergeStrList(String separator, List<String> list) {
    String mergedStr = null;
    if(CollectionUtils.isNotEmpty(list)){
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<list.size(); i++){
        sb.append(list.get(i));
        if(i != list.size() - 1){
          sb.append(separator);
        }
      }
      mergedStr = sb.toString();
    }
    return mergedStr;
  }
}



