# Spring/AspectJ Gradle Examples

Examples of Spring Dependency Injection using

- Spring Aspect Oriented Programming (AOP)
- AspectJ load time weaving
- AspectJ Compile time weaving

[I explained the contents of this repo in much greater detail here.](https://thinkfaster.co/2018/11/why-in-the-world-is-my-spring-autowired-null/) I try to give a summary below.

## Why is my @Autowired null!?

This project was motivated by many hours of debugging Spring @Autowired's being null when they shouldn't have been.

In the process, I was confused by the mixed documentation between the various ways you can use Spring and AspectJ.

What I needed were simple examples with the minimum set of annotations needed to make things 'work'. So, I built one each for compile time and load time weaving with AspectJ, and for Spring AOP.

Before you dive in, here is a laundry list of suggestions to try when you encounter a null @Autowire:
- If you’re @Autowiring an instance of Foo inside of Bar, make sure you have a @Component annotation (or @Service, etc) on top of class Foo.

- If you’re trying to new an instance of Bar with an @Autowired Foo (without calling SpringContext.getBean()), then you either need to be using AspectJ compile time or load time weaving. This will not work with regular Spring AOP.

- Again, if you’re new’ing up an instance of a class, make sure you have the @EnableSpringConfigured annotation on your Spring config, and make sure you have a @Configurable annotation on the class you’re trying to new.

- If you’re trying to use load time weaving, you need the @EnableLoadTimeWeaving annotation on your Spring config, and you need to add 2 -javaagent flags (see more details in the Gradle files) to your JVM:
  - spring-instrument.jar
  - aspectjweaver.jar

- If you’re encountering @Autowired instances being null only in unit tests:
  - Check your load orders. I’ve had lots of problems caused by conflicts between Spring and Powermock.
  - Make sure you’re always instantiating instances inside of methods instead of the class body or test constructor.
- If you’re encountering @Autowired instances being null only within IntelliJ but not when you run your code from the command line using Gradle:
  - Change the Test Runner in IntelliJ to use Gradle.


## Running

```
cd aspectj_compile_time_weaving
gradle run
```
or
```
cd aspectj_load_time_weaving
gradle run
```
or
```
cd spring_aop
gradle run
```


## Documentation

Running the programs isn't that useful, unless you want to see how they don't throw NullPointerExceptions, and that the @Autowired's are injected correctly.

It's more useful to browse the code and adapt the gradle files to your own use, especially in the compile time weaving and load time weaving cases, given that those builds are non-trivial.

I would also encourage you to play with the annotations required on the Spring classes. Experiment with adding and removing annotations to better understand how Spring and AspectJ work together.

I focused on using objects created outside of the Spring context. In other words, they were created using `new` instead of `context.getBean()`. I still needed the Autowireds to work properly because we were adding Spring to a legacy codebase where instantiating everything via Spring was not an option.

Hopefully these snippets save you time.
