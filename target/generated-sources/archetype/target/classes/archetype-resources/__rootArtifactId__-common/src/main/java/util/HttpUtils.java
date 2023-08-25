#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * http工具类
 *
 * @author Ye Feng
 * @date 2020/2/18 17:23
 */
@Slf4j
public class HttpUtils {
  /**
   * 创建http的get请求参数
   *
   * @param param 包含请求参数的map
   * @return
   */
  public static String buildGetParamStr(Map<String, Object> param) {
    StringBuffer buffer = new StringBuffer();
    buffer.append("?");
    if (param == null || param.size() == 0) {
      return "";
    }
    for (Map.Entry<String, Object> entry : param.entrySet()) {
      String key = entry.getKey();
      Object value = entry.getValue();
      if (StringUtils.isNotBlank(key) && value != null) {
        buffer.append(key).append("=").append(value).append("&");
      }
    }
    if ("&".equals(buffer.charAt(buffer.length() - 1) + "")) {
      buffer = new StringBuffer(buffer.toString().substring(0, buffer.length() - 1));
    }
    return buffer.toString();
  }

  public static Object httpGet(String urlStr, boolean isStringResult) {
    System.out.println(urlStr);
    String res = httpGet(urlStr, null);
    if (res != null) {
      if (!isStringResult) {
        return JSONObject.parseObject(res, Object.class);
      }
      return res;
    }
    return null;
  }

  /**
   * 发送包含请求头的get请求
   *
   * @param urlStr  请求地址
   * @param headers 请求头
   * @return
   */
  public static String httpGet(String urlStr, Map<String, String> headers) {
    if (urlStr == null || "".equals(urlStr.trim())) {
      return null;
    }
    HttpURLConnection conn = null;
    InputStream bis = null;
    String location = null;
    try {
      conn = (HttpURLConnection) new URL(urlStr).openConnection();
      conn.setRequestProperty("User-Agent", "");
      conn.setConnectTimeout(3000 * 5);
      conn.setReadTimeout(3000 * 5);
      conn.addRequestProperty("Connection", "close");
      if (headers != null) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
          conn.setRequestProperty(entry.getKey(), entry.getValue());
        }
      }
      conn.setRequestMethod("GET");
      conn.connect();
      int retCode = conn.getResponseCode();
      if (retCode == 200) {
        bis = new BufferedInputStream(conn.getInputStream());
        if (conn.getHeaderFields().containsKey("Content-Encoding")
                && conn.getHeaderFields().get("Content-Encoding").contains("gzip")) {
          bis = new GZIPInputStream(bis);
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[4096];
        int len;
        while ((len = bis.read(buf)) > 0) {
          baos.write(buf, 0, len);
        }
        return baos.toString("utf-8");
      }
    } catch (Exception e) {
      log.error(String.format("request url: %s error.", urlStr), e);
    } finally {
      if (bis != null) {
        try {
          bis.close();
        } catch (IOException ignored) {
        }
      }
      if (conn != null) {
        conn.disconnect();
      }
    }
    return null;
  }
}
