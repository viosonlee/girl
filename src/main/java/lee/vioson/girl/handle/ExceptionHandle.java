package lee.vioson.girl.handle;

import lee.vioson.girl.exceptions.GirlException;
import lee.vioson.girl.results.Result;
import lee.vioson.girl.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handleGirlAge(Exception e) {
        if (e instanceof GirlException) {
            return ResultUtils.error(((GirlException) e).getCode(), ((GirlException) e).getMsg());
        } else {
            logger.error("[系统错误]={}", e);
            return ResultUtils.error(-1, "未知错误");
        }
    }
}
