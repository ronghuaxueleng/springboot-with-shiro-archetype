package com.jzdata.aimedical.secret.utils;

import com.alibaba.fastjson.JSONObject;
import com.jzdata.aimedical.secret.consts.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @author: caoqiang
 * @create: 2019-05-15 13:05
 **/
@Slf4j
public class UserUtil {

  /**
   * 用户登录
   *
   * @param username   用户名
   * @param password   密码
   * @param rememberMe 是否记住密码
   * @return
   * @throws AuthenticationException
   */
  public static boolean login(String username, String password, boolean rememberMe) {
    UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
    //获取当前的Subject
    Subject currentUser = SecurityUtils.getSubject();
    try {
      // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
      // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
      // 所以这一步在调用login(token)方法时,它会走到xxRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
      currentUser.login(token);
      return true;
    } catch (LockedAccountException e) {
      log.error("[{}]账号被锁定", username);
      token.clear();
      throw new LockedAccountException("账号被锁定");
    } catch (IncorrectCredentialsException e) {
      log.error("[{}]密码错误", username);
      token.clear();
      throw new IncorrectCredentialsException("密码错误");
    } catch (Exception e) {
      token.clear();
      throw new AuthenticationException(e);
    }
  }

  /**
   * 用户登录
   *
   * @param username 用户名
   * @param password 密码
   * @return
   */
  public static boolean login(String username, String password) {
    return login(username, password, false);
  }

  /**
   * 用户退出
   */
  public static void logout() {
    SecurityUtils.getSubject().logout();
  }

  /**
   * 获得session
   *
   * @return
   */
  public static Session getSession() {
    return SecurityUtils.getSubject().getSession();
  }

  /**
   * 设置session
   *
   * @param key
   * @param value
   */
  public static void setSessionAttribute(Object key, Object value) {
    getSession().setAttribute(key, value);
  }

  /**
   * 通过key从session中获取数据
   *
   * @param key
   * @return
   */
  public static Object getSessionAttribute(Object key) {
    return getSession().getAttribute(key);
  }

  /**
   * 获取用户信息
   *
   * @return
   */
  public static JSONObject getUser() {
    return (JSONObject)JSONObject.toJSON(getSessionAttribute(SessionConst.USER_SESSION_KEY));
  }

  /**
   * 是否管理员
   * @return
   */
  public static boolean isAdmin() {
    return SecurityUtils.getSubject().isPermitted("r1_g0");
  }

  /**
   * 保存用户信息
   *
   * @param user
   */
  public static void setUser(JSONObject user) {
    setSessionAttribute(SessionConst.USER_SESSION_KEY, user);
  }

}
