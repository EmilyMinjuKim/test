package edu.bit.board.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Component
@Aspect		
public class LogAdvice {
	
	@Before("within(edu.bit.board.service.*)")//서비스패키지에서 실행될 때 printLogging()가 가장 윗부분에서 실행
	//@Before("within(edu.bit.board.*)")		
	public void printLogging() {	//얘를 공통기능으로 만들겠다
		System.out.println("공통기능 - 프린트 로그");
		
	}
}
