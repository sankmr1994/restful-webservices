package com.learn.rest.webservices.restfulwebservices.versioning;

public class PersonV2 {

    private Name personName;

    public PersonV2(String firstName , String lastName){
        Name name = new Name(firstName,lastName);
        personName = name;
    }

    public Name getPersonName() {
        return personName;
    }

    public void setPersonName(Name personName) {
        this.personName = personName;
    }
}
