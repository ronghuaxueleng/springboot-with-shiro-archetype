#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

/**
 * 文件异常
 * @author Ye Feng
 * @date 2020/2/21 21:59
 */
public class FileException extends SystemException {
  public FileException(int errorCode, String errorMsg) {
    super(errorCode, errorMsg);
  }

  public static FileException uploadFileException() {
    return new FileException(CodeConstant.FILE_UPLOAD_FAILURE_ERROR, ExceptionConsts.FILE_UPLOAD_FAILURE_ERROR);
  }

  public static FileException fileIsNullException() {
    return new FileException(CodeConstant.FILE_IS_NULL_ERROR, ExceptionConsts.FILE_IS_NULL_ERROR);
  }
}
