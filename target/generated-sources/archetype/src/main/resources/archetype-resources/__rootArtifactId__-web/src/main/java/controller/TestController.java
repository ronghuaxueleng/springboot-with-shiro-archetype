#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: caoqiang
 * @create: 2020/7/8 0008 上午 10:56
 **/
@RestController
@RequestMapping("/api/test")
public class TestController {

  @GetMapping("/hello")
  public String test() {
    return "test controller hello";
  }

}
