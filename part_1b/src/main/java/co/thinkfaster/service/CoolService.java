
package co.thinkfaster.service;

import org.springframework.stereotype.Service;

@Service
public class CoolService {

  public CoolService() {

  }

  public void sayHello() {
    System.out.println("Hello from my cool service");
  }

}