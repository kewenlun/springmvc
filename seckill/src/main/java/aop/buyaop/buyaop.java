package aop.buyaop;


import bean.stru.buystru;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("buyaop")
@Aspect
public class buyaop {

    @Pointcut("execution(* datesource.tableserve.buyserve.findone(..))")
    public void save() throws Exception{

    }
//    @Before(value = "save()")
    public void savebefore(JoinPoint joinPoint) throws Exception{
        System.out.println("1....................");
        System.out.println(joinPoint);

    }
//    @AfterReturning("save()")
    public void saveafter() throws Exception{
        System.out.println("2....................");
//        System.out.println(joinPoint);
    }

    @Around("save()")
    public Object saveround(ProceedingJoinPoint pro){
        Object values = null;
        try {
            savebefore(pro);

            Object[] args = pro.getArgs();
            values = pro.proceed(args);
            saveafter();
            return values;

        }catch (Throwable t){
            System.out.println("抛出异常");
        }finally {
            System.out.println("最终什么也没有执行");
        }
        return values;
    }

}
