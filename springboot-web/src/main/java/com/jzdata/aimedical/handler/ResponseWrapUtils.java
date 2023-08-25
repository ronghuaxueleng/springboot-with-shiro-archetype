package com.jzdata.aimedical.handler;

import com.alibaba.fastjson.JSON;
import com.jzdata.aimedical.vo.RestResponse;

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
