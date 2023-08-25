package com.jzdata.aimedical.util;

import com.jzdata.aimedical.exception.CodeConstant;
import com.jzdata.aimedical.exception.ExceptionConsts;
import com.jzdata.aimedical.exception.SystemException;
import com.jzdata.aimedical.vo.RestResponse;

/**
 * 
 * @author caoqiang
 * @date 2020/1/7 0007下午 15:45
 */
public class ExceptionHandlerUtils {

  /**
   * 处理Rest API的异常
   *
   * @param e
   * @return
   */
  public static RestResponse restApiExceptionHandler(Throwable e) {
    RestResponse restResponse = new RestResponse();
    if (e instanceof SystemException) {
      SystemException se = (SystemException) e;
      restResponse.setCode(se.getErrorCode());
      restResponse.setMessage(se.getErrorMsg());
    } else {
      restResponse.setCode(CodeConstant.SYSTEM_ERROR);
      restResponse.setMessage(ExceptionConsts.SYSTEM_EXCEPTION);
    }
    return restResponse;
  }

}
