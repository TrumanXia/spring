package com.xyg.learn.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author 97994
 * @since 2020-08-02
 */
public class AspectWithPointcut {
    /**
     * 1、使用within表达式匹配
     * 下面示例表示匹配com.leo.controller包下所有的类的方法
     */
    @Pointcut("within(com.leo.controller..*)")
    public void pointcutWithin(){

    }

    /**
     * 2、this匹配目标指定的方法，此处就是HelloController的方法
     */
    @Pointcut("this(com.leo.controller.HelloController)")
    public void pointcutThis(){

    }

    /**
     * 3、target匹配实现UserInfoService接口的目标对象
     */
    @Pointcut("target(com.leo.service.UserInfoService)")
    public void pointcutTarge(){

    }

    /**
     * 4、bean匹配所有以Service结尾的bean里面的方法，
     * 注意：使用自动注入的时候默认实现类首字母小写为bean的id
     */
    @Pointcut("bean(*ServiceImpl)")
    public void pointcutBean(){

    }

    /**
     * 5、args匹配第一个入参是String类型的方法
     */
    @Pointcut("args(String, ..)")
    public void pointcutArgs(){

    }

    /**
     * 6、@annotation匹配是@Controller类型的方法
     */
    @Pointcut("@annotation(org.springframework.stereotype.Controller)")
    public void pointcutAnnocation(){

    }
    /**
     * 7、@within匹配@Controller注解下的方法，要求注解的@Controller级别为@Retention(RetentionPolicy.CLASS)
     */
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void pointcutWithinAnno(){

    }
    /**
     * 8、@target匹配的是@Controller的类下面的方法，要求注解的@Controller级别为@Retention(RetentionPolicy.RUNTIME)
     */
    @Pointcut("@target(org.springframework.stereotype.Controller)")
    public void pointcutTargetAnno(){

    }
    /**
     * 9、@args匹配参数中标注为@Sevice的注解的方法
     */
    @Pointcut("@args(org.springframework.stereotype.Service)")
    public void pointcutArgsAnno(){

    }


    /**
     * 10、使用excution表达式
     * execution(
     *  modifier-pattern?           //用于匹配public、private等访问修饰符
     *  ret-type-pattern            //用于匹配返回值类型，不可省略
     *  declaring-type-pattern?     //用于匹配包类型
     *  name-pattern(param-pattern) //用于匹配类中的方法，不可省略
     *  throws-pattern?             //用于匹配抛出异常的方法
     * )
     *
     * 下面的表达式解释为：匹配com.leo.controller.HelloController类中以hello开头的修饰符为public返回类型任意的方法
     */
    @Pointcut(value = "execution(public * com.leo.controller.HelloController.hello*(..))")
    public void pointCut() {

    }

    ThreadLocal<Long> startTime = new ThreadLocal<>();
    /**
     * 10、使用excution表达式
     * execution(
     *  modifier-pattern?           //用于匹配public、private等访问修饰符
     *  ret-type-pattern            //用于匹配返回值类型，不可省略
     *  declaring-type-pattern?     //用于匹配包类型
     *  name-pattern(param-pattern) //用于匹配类中的方法，不可省略
     *  throws-pattern?             //用于匹配抛出异常的方法
     * )
     *
     * 下面的表达式解释为：匹配com.leo.controller.HelloController类中以hello开头的修饰符为public返回类型任意的方法
     */
//    @Pointcut(value = "execution(public * com.leo.controller.HelloController.hello*(..))")
//    public void pointCut() {
//
//    }

    /**
     * 在方法执行之前执行
     *
     * @param joinPoint
     */
    @Before(value = "pointCut()")
    public void beforeLog(JoinPoint joinPoint) {
        System.out.println("进入LogAop的beforeLogger");
        startTime.set(System.currentTimeMillis());
    }

    /**
     * 在进入类之前执行，然后返回pjp.proceed()之前执行before，再执行方法体，在到after
     *
     * @param
     */
    @Around(value = "pointCut()")
    public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入LogAop的aroundLogger");
        return pjp.proceed();
    }

    /**
     * 在方法执行返回之后执行
     */
    @After(value = "pointCut()")
    public void afterLog() {
        System.out.println("进入LogAop的afterLogger");
        long start = startTime.get();
        System.out.println("方法体执行耗时：" + (System.currentTimeMillis() - start) + "ms");
        startTime.remove();
    }

    /**
     * 在返回之后执行
     * @param o
     */
    @AfterReturning(value = "pointCut()",returning = "o")
    public void afterRunningLog(Object o){
        System.out.println("进入LogAop的afterRunningLog");
        System.out.println(o.getClass());
    }

    /**
     * 在产生异常时执行
     */
    @AfterThrowing(value = "pointCut()")
    public void afterThrowingLog(){
        System.out.println("进入LogAop的afterThrowingLog");
    }


}
