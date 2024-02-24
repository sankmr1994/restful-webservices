package com.learn.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String sayHelloWorld() {
        return "Hello Earth";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean sayHelloWorldBean() {
        return new HelloWorldBean("Hello", "Earth Hell");
    }

    @GetMapping("/hello-world/{name}")
    public HelloWorldBean sayHelloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello %s", name));
    }

    @GetMapping("/hello-world-i18n")
    public String sayHelloWorldI18N() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default message", locale
        );
    }
}
