
package co.thinkfaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import co.thinkfaster.service.CoolService;

@Component
@Configurable
public class UserController {

  @Autowired
  private CoolService coolService;

  public UserController() {

  }

  public void tryService() {
    if (coolService == null) {
      System.out.println("CRAP! Our service is NULL");
    } else {
      System.out.println("Wohoo!! The service got injected properly");
    }
    coolService.sayHello();
  }
}