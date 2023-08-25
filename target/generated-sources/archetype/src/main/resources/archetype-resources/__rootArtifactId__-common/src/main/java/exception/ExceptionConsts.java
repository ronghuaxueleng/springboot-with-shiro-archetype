#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

/**
 * 异常模板描述
 *
 * @author caoqiang
 * @date 2020/1/9 0009下午 17:27
 */
public class ExceptionConsts {

  public static final String SYSTEM_EXCEPTION = "系统异常！";

  public static final String DATA_IS_NOT_EXIST_ERROR = "【%s】数据不存在！";

  public static final String DATA_IS_EXIST_ERROR = "【%s】已经存在！";

  public static final String PARAM_TYPE_ERROR = "参数【%s】类型不对，期望为【%s】,实际为【%s】。";

  public static final String PARAM_VALUE_ERROR = "参数【%s】值不对，期望为【%s】。";

  public static final String DATA_CAUSES_ILLEGAL_OPERATION_ERROR = "%s，%s";

  public static final String PARAM_VALUE_ERROR_WITHOUT_EXPECTED_VALUE = "参数【%s】值不对";

  public static final String PARAM_NOT_NULL = "【%s】参数不允许为空";

  public static final String USER_IS_LOCK = "用户状态被锁定";

  public static final String USER_PWD_FAIL = "账号或密码错误，请重新输入！";

  public static final String LOGIN_EXCEPTION = "账号或密码错误，请重新输入！";

  public static final String USER_EXIST = "用户已经存在！";

  public static final String CAPTCHACODE_MISMATCH = "验证码错误，请重新输入！";

  public static final String FILE_UPLOAD_FAILURE_ERROR = "文件上传失败！";

  public static final String FILE_IS_NULL_ERROR = "上传的文件不能为空！";
}
