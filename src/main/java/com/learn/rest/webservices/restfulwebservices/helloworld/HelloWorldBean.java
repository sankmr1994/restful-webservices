package com.learn.rest.webservices.restfulwebservices.helloworld;


public class HelloWorldBean {

    private String firstName;
    private String lastName;

    private String message;

    public HelloWorldBean() {
    }

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public HelloWorldBean(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
