package com.jzdata.aimedical.secret.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author: caoqiang
 * @create: 2019-05-14 12:02
 **/
public interface IUserService {

  /**
   * 通过用户名获得用户信息
   *
   * @param loginName
   * @return
   */
  JSONObject getUserByName(String loginName);

  /**
   * 获得当前用户的权限
   * List格式，如下
   * [xx1, xx2]
   */
  List<String> getPermissions();

  /**
   * 获得当前用户角色
   * List格式，如下
   * [r1_g1, r2_g2]
   *
   * @return
   */
  List<String> getRoles();

  /**
   * 获得所有角色动态权限
   * Map格式，如下：
   * {
   * url: /api/xx,
   * permission: roles[r1_g1],perms[xx]
   * }
   *
   * @return
   */
  List<Map<String, String>> getPerms();


}
