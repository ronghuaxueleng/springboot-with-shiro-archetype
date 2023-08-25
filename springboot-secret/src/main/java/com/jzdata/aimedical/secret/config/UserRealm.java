package com.jzdata.aimedical.secret.config;

import com.alibaba.fastjson.JSONObject;
import com.jzdata.aimedical.secret.consts.SessionConst;
import com.jzdata.aimedical.secret.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义Realm
 *
 * @author caoqiang
 * @date 2019/5/14 0014上午 11:35
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

  @Autowired
  private IUserService userService;

  @Override
  @SuppressWarnings("unchecked")
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    //通过SimpleAuthenticationInfo做授权
    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
    //添加角色
    List<String> roles = userService.getRoles();
    if (roles != null) {
      simpleAuthorizationInfo.addRoles(roles);
    }
    //添加权限
    List<String> permissions = userService.getPermissions();
    if (permissions != null) {
      simpleAuthorizationInfo.addStringPermissions(permissions);
    }

    return simpleAuthorizationInfo;
  }

  /**
   * 验证当前登录的Subject
   * LoginController.login()方法中执行Subject.login()时 执行此方法
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
    String loginName = (String) authcToken.getPrincipal();
    // 获取用户密码
    JSONObject user = userService.getUserByName(loginName);
    if (user == null) {
      //没找到帐号
      throw new UnknownAccountException("账号不存在！");
    }

    //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
            user,
            user.getString("password"),
            //盐值
            ByteSource.Util.bytes(""),
            getName()
    );
    //session中不需要保存密码
    user.remove("password");
    //将用户信息放入session中
    SecurityUtils.getSubject().getSession().setAttribute(SessionConst.USER_SESSION_KEY, user);
    return authenticationInfo;
  }
}
