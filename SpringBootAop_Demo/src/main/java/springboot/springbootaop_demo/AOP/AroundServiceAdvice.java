package springboot.springbootaop_demo.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author Yu'S'hui'shen
 */
@Aspect
@Component
@Slf4j
public class AroundServiceAdvice {

    /*匹配语法,匹配UserService接口内的所有方法*/
    @Pointcut("execution(* springboot.springbootaop_demo.service.UserService.*(..))")
    public void userServicePointCut() {}

    /*使用@Around环绕通知进行切点方法监控*/
    @Around("userServicePointCut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        /*获取方法参数*/
        Object[] args = pjp.getArgs();
        /*获取方法名称*/
        String methodName = pjp.getSignature().getName();

        /*执行目标方法*/
        try {
            /*开始执行时间*/
            long startTime = System.currentTimeMillis();
            /*执行*/
            Object result = pjp.proceed();
            /*结束时间*/
            long endTime = System.currentTimeMillis();
            /*计算耗时*/
            long costTime = endTime - startTime;
            /*日志输出*/
            log.info("方法{}执行完成,参数:{},耗时:{},返回值为:{}", methodName, Arrays.toString(args), formatTime(costTime), result);
            return result;
        } catch (Throwable e) { // 捕获所有异常和错误
            log.error("方法 {} 执行异常 ❌ | 参数: {} | 异常类型: {} | 错误信息: {}",
                    methodName,
                    Arrays.toString(args),
                    e.getClass().getSimpleName(),
                    // 获取简短的异常类名
                    e.getMessage(),
                    // 获取异常信息
                    e);
            // 完整堆栈会输出到日志
            throw e;
            // 重新抛出异常，保持原有行为
        }
    }

    /*时间转换工具*/
    public static String formatTime(long millis) {
        if (millis < 1000) {
            return millis + "ms";
        } else if (millis < 60000) {
            return String.format("%.2fs", millis/1000.0);
        } else {
            long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) % 60;
            return String.format("%d分%d秒", minutes, seconds);
        }
    }
}
