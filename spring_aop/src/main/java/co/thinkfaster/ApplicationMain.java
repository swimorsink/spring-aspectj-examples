
package co.thinkfaster;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.thinkfaster.config.SpringConfig;
import co.thinkfaster.controller.UserController;

public class ApplicationMain {

  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(SpringConfig.class);
    
    /**
    UserController userController = new UserController();
    // Will throw a null pointer exception because
    // we new'd the object without the help of Spring.
    // So this object is not managed by Spring, and Spring
    // doesn't 'magically' know about it.
    userController.tryService();
    */

    UserController userController = context.getBean(UserController.class);
    // Will not throw a null pointer when we try to access
    // the @Autowired because we created the object using Spring,
    // so Spring handles the instantiation and can properly
    // inject all required dependencies.
    userController.tryService();


  }
}