package com.jzdata.aimedical;

import com.jzdata.aimedical.secret.annotation.EnableShiro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: caoqiang
 * @create: 2020-01-07 09:57
 **/
@EnableShiro
@SpringBootApplication(scanBasePackages = {"com.jzdata.**"})
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
