package com.abc.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAdviceTest {
    //ƥ��com.abc.service�µ�������before��ʼ�ķ���
    @Before("execution(* com.abc.service.*.before*(..))")
    public void PermissionCheck() {
        System.out.println("ģ��Ȩ�޼��");
    }
}