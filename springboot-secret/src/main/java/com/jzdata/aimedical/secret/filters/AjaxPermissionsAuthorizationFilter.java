package com.jzdata.aimedical.secret.filters;

import com.alibaba.fastjson.JSONObject;
import com.jzdata.aimedical.secret.consts.ErrorConst;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 对没有登录的请求进行拦截, 全部返回json信息. 覆盖掉shiro原本的跳转login.jsp的拦截方式
 *
 * @author caoqiang
 * @date 2019/5/14 0014上午 11:25
 */
public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {

  /**
   * 让Shiro对OPTIONS Request不进行鉴权操作，保证跨域post请求的正确
   * @param request
   * @param response
   * @param mappedValue
   * @return
   */
  @Override
  protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
    if (request instanceof HttpServletRequest) {
      if ("OPTIONS".equals(((HttpServletRequest) request).getMethod().toUpperCase())) {
        return true;
      }
    }
    return super.isAccessAllowed(request, response, mappedValue);
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("code", ErrorConst.LOGIN_EXPIRED);
    jsonObject.put("message", ErrorConst.LOGIN_EXPIRED_EXCEPTION);
    PrintWriter out = null;
    HttpServletResponse res = (HttpServletResponse) response;
    try {
      res.setCharacterEncoding("UTF-8");
      res.setContentType("application/json");
      out = response.getWriter();
      out.println(jsonObject);
    } catch (Exception ignored) {
    } finally {
      if (null != out) {
        out.flush();
        out.close();
      }
    }
    return false;
  }
}
