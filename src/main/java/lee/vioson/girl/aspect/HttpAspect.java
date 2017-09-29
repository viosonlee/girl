package lee.vioson.girl.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 统一处理切面
 */
@Aspect
@Component
public class HttpAspect {
    private Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * lee.vioson.girl.cotrollers.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //logger.info("拦截执行了");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url

        logger.info("url={}", request.getRequestURL());
        //method

        logger.info("method={}", request.getMethod());
        //ip

        logger.info("ip={}", request.getRemoteAddr());
        //类方法

        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数

        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("方法执行完毕了");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturn(Object object) {
        logger.info("response={}", object.toString());
    }
}
