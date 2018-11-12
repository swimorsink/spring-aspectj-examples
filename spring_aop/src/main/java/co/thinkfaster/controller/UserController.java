
package co.thinkfaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.thinkfaster.service.CoolService;

@Component
public class UserController {

  @Autowired
  private CoolService coolService;

  public UserController() {

  }

  public void tryService() {
    coolService.sayHello();
  }
}