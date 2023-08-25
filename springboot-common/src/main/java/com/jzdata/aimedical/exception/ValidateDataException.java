package com.jzdata.aimedical.exception;

/**
 * 参数验证错误
 *
 * @author caoqiang
 * @date 2020/1/9 0009下午 17:24
 */
public class ValidateDataException extends SystemException {

  public ValidateDataException(int errorCode, String errorMsg) {
    super(errorCode, errorMsg);
  }

  public ValidateDataException(String errorMsg) {
    super(CodeConstant.VALIDATE_DATA_IS_REQUIRED_ERROR, errorMsg);
  }

  /**
   * 参数为空的异常
   *
   * @param field 字段
   * @return
   */
  public static ValidateDataException getIsRequiredError(String field) {
    return new ValidateDataException(String.format(ExceptionConsts.PARAM_NOT_NULL, field));
  }

  /**
   * 传递的了不被允许的参数
   *
   * @param field       字段
   * @param expectValue 期望值
   * @return
   */
  public static ValidateDataException getNotAllowValuesError(String field, String expectValue) {
    return new ValidateDataException(CodeConstant.VALIDATE_DATA_IS_NOT_ALLOW_VALUES_ERROR, String.format(ExceptionConsts.PARAM_VALUE_ERROR, field, expectValue));
  }

  /**
   * 传递的了不被允许的参数
   *
   * @param field 字段
   * @return
   */
  public static ValidateDataException getNotAllowValuesError(String field) {
    return new ValidateDataException(CodeConstant.VALIDATE_DATA_IS_NOT_ALLOW_VALUES_ERROR, String.format(ExceptionConsts.PARAM_VALUE_ERROR_WITHOUT_EXPECTED_VALUE, field));
  }

  /**
   * 传递了已经存在的参数值
   * @param value 参数值
   * @return
   */
  public static ValidateDataException getDuplicateValuesError(String value) {
    return new ValidateDataException(CodeConstant.DATA_IS_EXIST_ERROR, String.format(ExceptionConsts.DATA_IS_EXIST_ERROR, value));
  }

  /**
   * 传递了可能导致非法操作的参数
   * @param value 参数值
   * @param msg 信息
   * @return
   */
  public static ValidateDataException getIllegalOperationError(String value, String msg) {
    return new ValidateDataException(CodeConstant.VALIDATE_DATA_CAUSES_ILLEGAL_OPERATION_ERROR, String.format(ExceptionConsts.DATA_CAUSES_ILLEGAL_OPERATION_ERROR, value, msg));
  }
}
