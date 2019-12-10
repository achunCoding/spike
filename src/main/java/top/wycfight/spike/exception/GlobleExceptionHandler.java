package top.wycfight.spike.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.wycfight.spike.util.Result;
import top.wycfight.spike.util.ResultGenerator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 全局异常处理
 * @create: 2019-12-10 07:55
 * @modify By:
 **/
@RestControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception e) {
        if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> allErrors = ex.getAllErrors();
            ObjectError objectError = allErrors.get(0);
            String message = objectError.getDefaultMessage();
            return ResultGenerator.genErrorResult(10008, "参数校验错误："+ message);
        } else {
            return ResultGenerator.genErrorResult(10010, "服务器错误");
        }

    }
}
