package com.jzdata.aimedical.secret.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * MD5加密工具类
 *
 * @author caoqiang
 * @date 2019/5/14 0014上午 11:15
 */
@Slf4j
public class Md5Util {

  /**
   * 密码加密
   *
   * @param password          原始
   * @param salt              盐
   * @param hashAlgorithmName 加密方式
   * @param hashIterations    加密次数
   * @return
   */
  public static final String md5(String password, String salt, String hashAlgorithmName, int hashIterations) {
    //盐：为了即使相同的密码不同的盐加密后的结果也不同
    ByteSource byteSalt = ByteSource.Util.bytes(salt);
    SimpleHash result = new SimpleHash(hashAlgorithmName, password, byteSalt, hashIterations);
    return result.toString();
  }

  public static final String md5(String password) {
    return md5(password, "", "MD5", 1);
  }

  public static void main(String[] args) {
    String password = md5("f", "", "MD5", 1);
    System.out.println(password);
    //加密后的结果
    //b41cb62ec6767f2e41f9df7a2d161515
  }
}
