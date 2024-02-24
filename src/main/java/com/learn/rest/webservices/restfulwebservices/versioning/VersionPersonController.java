package com.learn.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {

    @GetMapping("/v1/person")
    public PersonV1 personV1(){
        return new PersonV1("sandy kmr");
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2(){
        return new PersonV2("sandy","kmr");
    }

    @GetMapping(value = "/person",params = "version=1")
    public PersonV1 paramVersionPersonV1(){
        return new PersonV1("sandy kmr");
    }

    @GetMapping(value = "/person",params = "version=2")
    public PersonV2 paramVersionPersonV2(){
        return new PersonV2("sandy","kmr");
    }

    @GetMapping(value = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 headerVersionPersonV1(){
        return new PersonV1("sandy kmr");
    }

    @GetMapping(value = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 headerVersionPersonV2(){
        return new PersonV2("sandy","kmr");
    }
}
