package edu.bit.board.aop;

import javax.xml.ws.soap.Addressing;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Aspect
@Component
public class LogAOP {
	
	//@Around("within(edu.bit.board..*)")
	@Pointcut("execution(* edu.bit.board.*.getList())")	//리스트만 경과시간 나오도록 적용
	public void pointcutMethod() {
	}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		
		String signatureStr = joinpoint.getSignature().toShortString();
		//프락시가 핵심기능 list가져옴
		System.out.println(signatureStr +" is start.");
		
		
		long st = System.currentTimeMillis(); //시작시간
		
		try {
			Object obj = joinpoint.proceed(); //list 실행(핵심기능)
			return obj;
		}finally {
			
			long et = System.currentTimeMillis(); //공통기능 //마감시간
			
			System.out.println(signatureStr +" is finished.");
			System.out.println(signatureStr + " 경과시간 : "+ (et-st)); //걸린시간
		}
	}

}
