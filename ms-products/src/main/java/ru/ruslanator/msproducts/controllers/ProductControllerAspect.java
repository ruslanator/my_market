package ru.ruslanator.msproducts.controllers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class ProductControllerAspect {
    @Before("execution(public void ru.ruslanator.msproducts.controllers.*())")
    public void beforeAnyMethodInControllerWithDetails(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("В ProductController был вызван метод: " + methodSignature);
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            System.out.println("Аргументы:");
            for (Object o : args) {
                System.out.println(o);
            }
        }
    }
}
