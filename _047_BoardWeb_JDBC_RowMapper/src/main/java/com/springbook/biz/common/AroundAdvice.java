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
	/*ProceedingJoinPoint : ���� �������� ����Ʈ�� �޼ҵ�, JoinPoint �� ��ӹ޾Ƽ� proceed��� �޼ҵ带 ������ ��ü
	 * 						proceed() : ������ �޼ҵ带 �����ϴ� �޼ҵ�
	 * JoinPoint�� ������ �޼ҵ��
	 * 	getSignature() : ȣ��� ����Ͻ� �޼ҵ��� �ñ״�ó(����Ÿ��, �̸�, �Ű�����) �� signature ��ü�� ��Ƽ� ����
	 * 	getTarget() : ȣ��� ����Ͻ� �޼ҵ忡 �����ϴ� ����Ͻ� ��ü�� ����
	 * 	getArgs() : ȣ��� ����Ͻ� �޼ҵ���� �Ű����� ������ Object �迭�� ����
	 * aop:before, after-returning, after-throwing, after : joinPoint �������̽� �������
	 * aop:around : ProceedingJoinPoint ��ü�� ����ؾ���.
	 * 
	 * get Signature() -> Signater��ü ���� �� signature ��ü���� ��� ������ �޼ҵ�
	 * 	getName(): ȣ��� ����Ʈ�� �޼ҵ��� �޼ҵ�� ��Ʈ��Ÿ������ ����
	 * 	toLongString() : ȣ��� ����Ʈ�� �޼ҵ��� ����Ÿ��, �̸�, �Ű������� ��Ű����α��� ������ ��Ʈ��Ÿ������ ����
	 * 	toShortString() : ȣ��� ����Ʈ�� �޼ҵ��� ����Ÿ��, �̸� , �Ű������� ����ؼ� ��Ʈ��Ÿ������ ����
	 * */
	@Around("allPointcut")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[Before] : ����Ͻ� ���� ���� �� ó���� ����");
		Object returnObj = pjp.proceed();
		System.out.println("[After] : ����Ͻ� ���� ���� �� ó���� ����");
		return returnObj;
	}
}
