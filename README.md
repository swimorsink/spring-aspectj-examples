# Spring/AspectJ Gradle Examples

Examples of Spring Dependency Injection using

- Spring AOP
- AspectJ load time weaving
- AspectJ Compile time weaving

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

This project was motivated by many hours of debugging Spring @Autowired's being null when they shouldn't have been.

In the process, I was confused by the mixed documentation between the various ways you can use Spring and AspectJ.

What I needed were simple examples with the minimum set of annotations needed to make things 'work'.

I focused on using objects created outside of the Spring context. In other words, they were created using `new` instead of `context.getBean()`. I still needed the Autowireds to work properly because we were adding Spring to a legacy codebase where instantiating everything via Spring was not an option.

Hopefully these snippets save you time.

## External Links

[I wrote more about debugging Autowired problems here.](https://thinkfaster.co/2018/11/why-in-the-world-is-my-spring-autowired-null/)