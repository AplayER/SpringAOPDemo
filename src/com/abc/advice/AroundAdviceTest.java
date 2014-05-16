package com.abc.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AroundAdviceTest {
    @Around(value="execution(* com.abc.service.*.around*(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        System.out.println("ģ��ִ��Ŀ�귽��ǰ����ǿ��������ʼ...");
        //�޸�Ŀ�귽���Ĳ���
        Object[] params = new Object[]{"param1", 2, "param3"};
        System.out.println("���صķ����� " + point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("������ " + Arrays.toString(point.getArgs()));
        //ִ��Ŀ�귽����������Ŀ�귽��ִ�к�ķ���ֵ
        Object returnValue = point.proceed(params);
        System.out.println("ģ��ִ��Ŀ�귽�������ǿ�����������...");
        //�����޸ĺ�ķ���ֵ
        return "����ʵ�ʷ���ֵ��" + returnValue + "�����Ƿ���ֵ�ĺ�׺";
    }
}
