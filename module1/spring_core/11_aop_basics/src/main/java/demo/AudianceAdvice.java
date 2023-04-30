package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect //aspect =advice + pointcut (subset of jp)
public class AudianceAdvice {

    @After("execution( * demo.*.do*(int , *))")
    public void clappingAfter() {
        System.out.println("clapping we enjoyed a lot!======>  @After");
    }
}


//    @Pointcut("execution(public void doMagic())")
//    public void foo() {}
//
//    @After("foo()")
//    public void clappingAfter() {
//        System.out.println("clapping we enjoyed a lot!======>  @After");
//    }

















//    @Around("execution(public void doMagic())")
//    public Object aroundAdvice(ProceedingJoinPoint joinPoint)throws Throwable{
//        System.out.println("before calling target method");
//
//        Object result=joinPoint.proceed();
//
//        System.out.println("after calling target method : "+joinPoint.getSignature().getName());
//        return null;
//    }
//
//    @AfterThrowing(pointcut = "execution(public void doMagic())", throwing = "ex")
//    public void clappingAfterThrowning(Exception ex){
//        System.out.println(ex.getMessage());
//        System.out.println("clapping we enjoyed a lot!==> @AfterThrowing");
//    }

//    @AfterReturning("execution(public void doMagic())")
//    public void clappingAfterReturning(){
//        System.out.println("clapping we enjoyed a lot!=====>  @AfterReturning");
//    }
//



//}









