package com.abc.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterReturningAdviceTest {
    //ƥ��com.abc.service�µ�������afterReturning��ʼ�ķ���
    @AfterReturning(returning="returnValue", pointcut="execution(* com.abc.service.*.afterReturning(..))")
    public void log(Object returnValue){
        System.out.println("Ŀ�귽������ֵ��" + returnValue);
        System.out.println("ģ����־��¼����...");
    }
}
