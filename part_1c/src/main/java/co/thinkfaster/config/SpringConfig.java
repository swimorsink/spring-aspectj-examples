
package co.thinkfaster.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;


@Configuration
@EnableSpringConfigured
@EnableLoadTimeWeaving
@ComponentScan({
    "co.thinkfaster.service",
    "co.thinkfaster.controller",
})
public class SpringConfig {

}