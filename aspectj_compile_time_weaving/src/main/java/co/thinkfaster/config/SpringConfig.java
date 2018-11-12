
package co.thinkfaster.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;


@Configuration
@ComponentScan({
    "co.thinkfaster.service",
    "co.thinkfaster.controller",
})
@EnableSpringConfigured
public class SpringConfig {

}