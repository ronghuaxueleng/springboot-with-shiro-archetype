#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.handler;

import com.alibaba.fastjson.JSON;
import ${package}.vo.RestResponse;

/**
 * 
 * @author caoqiang
 * @date 2020/1/7 0007下午 21:24
 */
public class ResponseWrapUtils {

  public static Object wrapResponse(Object data) {
    if (data instanceof RestResponse) {
      return data;
    } else {
      RestResponse restResponse = new RestResponse();
      restResponse.setData(data);
      if (data instanceof String) {
        return JSON.toJSONString(restResponse);
      }
      return restResponse;
    }
  }

}
