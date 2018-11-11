
package co.thinkfaster;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.thinkfaster.config.SpringConfig;
import co.thinkfaster.controller.UserController;

public class ApplicationMain {

  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(SpringConfig.class);
    
    UserController userController = new UserController();
    // This works now because we added @Configurable to our class
    // as well as @EnableSpringConfigured to the config AND
    // we're doing AspectJ compile time weaving.
    userController.tryService();
  }
}