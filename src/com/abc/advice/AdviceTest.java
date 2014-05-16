package com.abc.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AdviceTest {
    @Around("execution(* com.abc.service.*.many*(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        System.out.println("@Around��ִ��Ŀ�귽��֮ǰ...");
        //����Ŀ�귽���Ĳ�����
        Object[] args = point.getArgs();
        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
            args[0] = "�ı��Ĳ���1";
        }
        //�øı��Ĳ���ִ��Ŀ�귽��
        Object returnValue = point.proceed(args);
        System.out.println("@Around��ִ��Ŀ�귽��֮��...");
        System.out.println("@Around����֯���Ŀ�����Ϊ��" + point.getTarget());
        return "ԭ����ֵ��" + returnValue + "�����Ƿ��ؽ���ĺ�׺";
    }
    @Before("execution(* com.abc.service.*.many*(..))")
    public void permissionCheck(JoinPoint point) {
        System.out.println("@Before��ģ��Ȩ�޼��...");
        System.out.println("@Before��Ŀ�귽��Ϊ��" + point.getSignature().getDeclaringTypeName() + 
                "." + point.getSignature().getName());
        System.out.println("@Before������Ϊ��" + Arrays.toString(point.getArgs()));
        System.out.println("@Before����֯���Ŀ�����Ϊ��" + point.getTarget());
    }
    @AfterReturning(pointcut="execution(* com.abc.service.*.many*(..))", returning="returnValue")
    public void log(JoinPoint point, Object returnValue) {
        System.out.println("@AfterReturning��ģ����־��¼����...");
        System.out.println("@AfterReturning��Ŀ�귽��Ϊ��" + point.getSignature().getDeclaringTypeName() + 
                "." + point.getSignature().getName());
        System.out.println("@AfterReturning������Ϊ��" + Arrays.toString(point.getArgs()));
        System.out.println("@AfterReturning������ֵΪ��" + returnValue);
        System.out.println("@AfterReturning����֯���Ŀ�����Ϊ��" + point.getTarget());
        
    }
    @After("execution(* com.abc.service.*.many*(..))")
    public void releaseResource(JoinPoint point) {
        System.out.println("@After��ģ���ͷ���Դ...");
        System.out.println("@After��Ŀ�귽��Ϊ��" + point.getSignature().getDeclaringTypeName() + 
                "." + point.getSignature().getName());
        System.out.println("@After������Ϊ��" + Arrays.toString(point.getArgs()));
        System.out.println("@After����֯���Ŀ�����Ϊ��" + point.getTarget());
    }
}
