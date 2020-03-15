package com.ocm.bootApp.aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;

/**
 * AOP切面处理
 */
@Aspect
@Component
public class HpptAspect {

    //引用日志
    private final static Logger logger = LoggerFactory.getLogger(HpptAspect.class) ;

    //设置切面
    @Pointcut("execution(public * com.ocm.bootApp.controller.LuckymoneyController.*(..))") //每个方法执行之前就开始执行了
    public void log(){
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //IP
        logger.info("IP={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() +"."+joinPoint.getSignature().getName());
        //paramters
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfterLog(){
        logger.info("5678907");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void  doAfterReturning(Object object){
        logger.info("respon={}",object.toString());

    }

    /**
     *  原始写法
     *  拦截单个的
     * @Before("execution(public * com.ocm.bootApp.controller.LuckymoneyController.list(..))")
     * 拦截该controller下的所有方法
     *  @Before("execution(public * com.ocm.bootApp.controller.LuckymoneyController.*(..))") //每个方法执行之前就开始执行了
     *     public void log(){
     *         System.out.println("12345678");
     *     }
     *  @After("execution(public * com.ocm.bootApp.controller.LuckymoneyController.*(..))")
     *     public void doAfterLog(){
     *         System.out.println("56789064567");
     *     }
     */


}
