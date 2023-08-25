package com.jzdata.aimedical.secret.filters;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: caoqiang
 * @create: 2020-02-14 17:12
 **/
public class ShiroPermsFilter extends PermissionsAuthorizationFilter {

  /**
   * shiro认证perms资源失败后回调方法
   */
  @Override
  protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("code", 401);
    jsonObject.put("message", "当前用户没有资源的访问权限");
    PrintWriter out = null;
    HttpServletResponse res = (HttpServletResponse) servletResponse;
    try {
      res.setCharacterEncoding("UTF-8");
      res.setContentType("application/json");
      out = servletResponse.getWriter();
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