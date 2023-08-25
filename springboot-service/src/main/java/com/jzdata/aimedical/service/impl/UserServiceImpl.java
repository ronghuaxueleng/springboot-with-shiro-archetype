package com.jzdata.aimedical.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jzdata.aimedical.secret.service.IUserService;
import com.jzdata.aimedical.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: caoqiang
 * @create: 2020/7/30 0030 下午 15:53
 **/
@Service
public class UserServiceImpl implements UserService, IUserService {
  @Override
  public JSONObject getUserByName(String loginName) {
    return null;
  }

  @Override
  public List<String> getPermissions() {
    return null;
  }

  @Override
  public List<String> getRoles() {
    return null;
  }

  @Override
  public List<Map<String, String>> getPerms() {
    return null;
  }
}
