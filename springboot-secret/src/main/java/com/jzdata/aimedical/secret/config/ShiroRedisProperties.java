package com.jzdata.aimedical.secret.config;import lombok.Data;import lombok.extern.slf4j.Slf4j;import org.apache.commons.lang3.StringUtils;import org.springframework.beans.factory.InitializingBean;import org.springframework.boot.context.properties.ConfigurationProperties;import org.springframework.stereotype.Component;import java.util.List;/** * redis配置类 * * @author caoqiang * @date 2020/1/14 0014下午 13:15 */@Slf4j@Data@Component@ConfigurationProperties(prefix = "security.shiro.redis")public class ShiroRedisProperties implements InitializingBean {  private boolean enabled;  /**   * 带端口 如：127.0.0.1:6379   */  private String host;  private String port;  private int timeout;  private int soTimeout;  private int maxAttempts;  private String password;  private int database;  private Pool pool;  private Cluster cluster;  private Sentinel sentinel;  private String keyPrefix;  public String getHostWithPort() {    return this.host + ":" + this.port;  }  @Override  public void afterPropertiesSet() throws Exception {    if (StringUtils.isBlank(host)) {      throw new Exception("请设置security.shiro.redis.host");    }    if (StringUtils.isBlank(port)) {      throw new Exception("请设置security.shiro.redis.port");    }    if (StringUtils.isBlank(keyPrefix)) {      throw new Exception("请设置security.shiro.redis.keyPrefix");    }  }  @Data  public static class Pool {    private int maxIdle = 8;    private int minIdle = 0;    private int maxActive = 8;    private int maxWait = -1;  }  @Data  public static class Sentinel {    private String master;    private String nodes;  }  @Data  public static class Cluster {    private List<String> nodes;    public String getNodesString() {      StringBuilder sb = new StringBuilder();      nodes.forEach(node -> sb.append(node).append(","));      return sb.substring(0, sb.length() - 1);    }  }}