package com.cos.movie.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Exception 낚아채기

@RestController
@RestControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler(value = IllegalArgumentException.class)
 public String argumentException(IllegalArgumentException e) {
	 return e.getMessage().toString();
 }
}
