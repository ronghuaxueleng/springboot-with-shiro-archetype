package com.jzdata.aimedical.exception;

/**
 * 系统异常码常量类，异常码需要在这里声明
 * 系统异常码默认为4位：高一位表示异常大类，后三位表示异常大类下的具体异常
 */
public class CodeConstant {

  /**
   * 参数未传递
   */
  public static final int VALIDATE_DATA_IS_REQUIRED_ERROR = 2000;

  /**
   * 含有不允许的参数
   */
  public static final int VALIDATE_DATA_IS_NOT_ALLOW_VALUES_ERROR = 2001;

  /**
   * 含有可能导致非法操作的参数值
   */
  public static final int VALIDATE_DATA_CAUSES_ILLEGAL_OPERATION_ERROR = 2002;

  /**
   * 权限异常
   */
  public static final int PERMISSION_EXCEPTION = 4000;

  /**
   * 登录过期
   */
  public static final int LOGIN_EXPIRED = 4001;

  /**
   * 登录失败
   */
  public static final int LOGIN_EXCEPTION = 4002;

  /**
   * 用户被锁定
   */
  public static final int USER_IS_LOCK = 4003;

  /**
   * 用户登录密码错误
   */
  public static final int USER_PWD_FAIL = 4004;

  /**
   * 用户存在异常
   */
  public static final int USER_EXIST = 4005;

  /**
   * 验证码不匹配异常
   */
  public static final int CAPTCHACODE_MISMATCH  = 4006;


  /**
   * 系统异常，其他未捕获异常统一归为系统异常
   */
  public static final int SYSTEM_ERROR = 9999;

  /**
   * 请求成功
   */
  public static final int SUCCESS = 200;

  /**
   * 请求成功但操作失败
   */
  public static final int FAILE = 5555;

  public static final int DOWNLOAD_ERROR = 6666;

  /**
   * 数据不存在
   */
  public static final int DATA_IS_NOT_EXIST_ERROR = 7001;


  /**
   * 数据已经存在
   */
  public static final int DATA_IS_EXIST_ERROR = 7002;

  /**
   * 文件上传失败
   */
  public static final int FILE_UPLOAD_FAILURE_ERROR = 8000;

  /**
   * 文件为空异常
   */
  public static final int FILE_IS_NULL_ERROR = 8001;
}
