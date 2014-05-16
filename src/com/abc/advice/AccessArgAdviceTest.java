package com.abc.advice;

import java.util.Date;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AccessArgAdviceTest {
    @AfterReturning(
            pointcut="execution(* com.abc.service.*.access*(..)) && args(time, name)",
            returning="returnValue")
    public void access(Date time, Object returnValue, String name) {
        System.out.println("Ŀ�귽���еĲ���String = " + name);
        System.out.println("Ŀ�귽���еĲ���Date = " + time);
        System.out.println("Ŀ�귽���ķ��ؽ��returnValue = " + returnValue);
    }
}
