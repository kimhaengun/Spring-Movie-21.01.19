package com.cos.movie.config;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.cos.movie.domain.CommonDto;

//공통 기능 집합
@Component
@Aspect
//주소요청이 오면 리플렉션으로 해당 함수를 찾아야 스택이 실행 
//= 컨트롤러가 메모리에 뜬 후 (configuration)
//  =이 함수를 실행하게 하고 싶으면 @valid BindingResult bindingResult을 주면된다.=
public class BindingAdvice {
	//validation 체크를 위해서는 함수의 매개변수를 알야한다. -> proceedingJoinPoint
	@Around("execution(* com.cos.movie.web..*Controller.*(..))")
	public Object validCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		//전처리
		String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
		String method = proceedingJoinPoint.getSignature().getName();
		System.out.println("type : "+type);
		System.out.println("method : "+method);
		//
		Object[] args = proceedingJoinPoint.getArgs();
		
		for(Object arg : args) {
			if(arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult)arg;
				
				System.out.println("bindingResult = "+bindingResult.getErrorCount());
				if(bindingResult.hasErrors()) {
					Map<String, String> errorMap = new HashMap<>();
					for(FieldError error : bindingResult.getFieldErrors()) {
						errorMap.put(error.getField(), error.getDefaultMessage());
					}
					return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),"false");
				}
			}
		}
		return proceedingJoinPoint.proceed();
		//해당 함수의 스택을 실행 하게
	}
}
