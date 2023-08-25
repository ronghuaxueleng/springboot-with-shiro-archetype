#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

/**
 * 产生随机密码
 * @author Ye Feng
 * @date 2020/2/7 12:07
 */
public class PasswordGenerator {
  /**
   * 密码中可用字符集
   */
  private final static String[] PWD_CHAR_SET = {"qwertyuiopasdfghjkzxcvbnm", "0123456789"};

  private final static int PWD_LEN = 6;

  /**
   * 生成密码
   * @return
   */
  public static String generatePwd() {
    return generatePwd(PWD_LEN);
  }

  /**
   * 生成密码
   * @param pwdLen 密码长度
   * @return
   */
  public static String generatePwd(int pwdLen) {
    String pwd = " ";
    char[] chs = new char[pwdLen];

    for (int i = 0; i < PWD_CHAR_SET.length; i++) {
      int idx = (int) (Math.random() * PWD_CHAR_SET[i].length());
      chs[i] = PWD_CHAR_SET[i].charAt(idx);
    }

    for (int i = PWD_CHAR_SET.length; i < pwdLen; i++) {
      int arrIdx = (int) (Math.random() * PWD_CHAR_SET.length);
      int strIdx = (int) (Math.random() * PWD_CHAR_SET[arrIdx].length());
      chs[i] = PWD_CHAR_SET[arrIdx].charAt(strIdx);
    }

    for (int i = 0; i < 1000; i++) {
      int idx1 = (int) (Math.random() * chs.length);
      int idx2 = (int) (Math.random() * chs.length);
      if (idx1 == idx2) {
        continue;
      }
      char tempChar = chs[idx1];
      chs[idx1] = chs[idx2];
      chs[idx2] = tempChar;
    }

    pwd = new String(chs);
    System.out.println(pwd);
    return pwd;
  }

  public static void main(String[] args) {
    generatePwd(6);
  }
}
