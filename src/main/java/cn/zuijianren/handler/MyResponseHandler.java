package cn.zuijianren.handler;

import cn.zuijianren.exception.APIException;
import cn.zuijianren.model.ResultV0;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author zuijianren
 * @date 2020/11/12 10:45
 */
@RestControllerAdvice
public class MyResponseHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return !methodParameter.getParameterType().equals(ResultV0.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // String 类型不能直接包装，所以要进行特别的处理
        if(methodParameter.getParameterType().equals(String.class)){
            ObjectMapper objectMapper = new ObjectMapper();
            try{
                // 将数据包装在ResultV0中后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(new ResultV0<>(0));
            }catch (JsonProcessingException e){
                throw new APIException("返回String类型错误");
            }
        }
        // 将原本的数据包装在ResultV0中
        return new ResultV0<>(o);
    }
}
