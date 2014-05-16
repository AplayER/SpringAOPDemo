package com.abc.advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterThrowingAdviceTest {
    @AfterThrowing(throwing="ex",pointcut="execution(* com.abc.service.*.afterThrow*(..))")
    public void handleException(Throwable ex) {
        System.out.println("Ŀ�귽���׳��쳣��" + ex);
        System.out.println("ģ���쳣����");
    }
}
