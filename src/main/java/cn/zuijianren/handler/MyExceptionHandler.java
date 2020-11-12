package cn.zuijianren.handler;

import cn.zuijianren.exception.APIException;
import cn.zuijianren.model.ResultCode;
import cn.zuijianren.model.ResultV0;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zuijianren
 * @date 2020/11/12 10:00
 */
@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultV0 methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        String defaultMessage = objectError.getDefaultMessage();
        return new ResultV0(ResultCode.VALIDATE_FAILED, defaultMessage);
    }

    @ExceptionHandler(APIException.class)
    public ResultV0 APIExceptionHandler(APIException e){
        return new ResultV0(ResultCode.ERROR, e.getMsg());
    }

}
