package com.jzdata.aimedical.secret.filters;

import com.alibaba.fastjson.JSONObject;
import com.jzdata.aimedical.secret.consts.ErrorConst;
import com.jzdata.aimedical.secret.utils.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: caoqiang
 * @create: 2020-02-14 17:12
 **/
public class ShiroRolesFilter extends RolesAuthorizationFilter {
  /**
   * 在访问controller前判断是否登录，返回json，不进行重定向。
   * @param request
   * @param response
   * @return false-该filter过滤器已经处理，不继续执行其他过滤器
   * @throws Exception
   */
  @Override
  public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    Object user = UserUtil.getUser();
    if (null == user && !StringUtils.contains(httpServletRequest.getRequestURI(), "/login")) {
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
    return isAccessAllowed(request, response, mappedValue) || onAccessDenied(request, response, mappedValue);
  }

  /**
   * 修改多个角色为或的关系
   *
   * @param req
   * @param resp
   * @param mappedValue
   * @return
   */
  @Override
  public boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) {
    Subject subject = getSubject(req, resp);
    String[] rolesArray = (String[]) mappedValue;

    //没有角色限制，有权限访问
    if (rolesArray == null || rolesArray.length == 0) {
      return true;
    }
    for (String s : rolesArray) {
      //若当前用户是rolesArray中的任何一个，则有权限访问
      if (subject.hasRole(s)) {
        return true;
      }
    }

    return false;
  }

  /**
   * shiro认证roles权限失败后回调方法
   */
  @Override
  protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("code", 401);
    jsonObject.put("message", "当前角色没有资源的访问权限");
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