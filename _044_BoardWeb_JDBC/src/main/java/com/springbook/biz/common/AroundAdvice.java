package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	/*ProceedingJoinPoint : 지금 실행중인 포인트컷 메소드, JoinPoint 를 상속받아서 proceed라는 메소드를 구현한 객체
	 * 						proceed() : 포인컷 메소드를 실핸하는 메소드
	 * JoinPoint의 유용한 메소드들
	 * 	getSignature() : 호출된 비즈니스 메소드의 시그니처(리턴타입, 이름, 매개변수) 를 signature 객체로 담아서 리턴
	 * 	getTarget() : 호출된 비즈니스 메소드에 포함하는 비즈니스 객체를 리턴
	 * 	getArgs() : 호출된 비즈니스 메소드들의 매개변수 값들을 Object 배열로 리턴
	 * aop:before, after-returning, after-throwing, after : joinPoint 인터페이스 직접사용
	 * aop:around : ProceedingJoinPoint 객체를 사용해야함.
	 * 
	 * get Signature() -> Signater객체 리턴 후 signature 객체에서 사용 가능한 메소드
	 * 	getName(): 호출된 포인트컷 메소드의 메소드면 스트링타입으로 리턴
	 * 	toLongString() : 호출된 포인트컷 메소드의 리턴타입, 이름, 매개변수를 패키지경로까지 포함한 스트링타입으로 리턴
	 * 	toShortString() : 호출된 포인트컷 메소드의 리턴타입, 이름 , 매개변수를 축약해서 스트링타입으로 리턴
	 * */
	@Around("allPointcut")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[Before] : 비즈니스 로직 수행 전 처리할 내용");
		Object returnObj = pjp.proceed();
		System.out.println("[After] : 비즈니스 로직 수행 후 처리할 내용");
		return returnObj;
	}
}
