package com.practice.spring.rest.exception_handling;

//Exception вылет при условии если не найдет employee
public class NoSuchEmployeeException extends RuntimeException {
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
