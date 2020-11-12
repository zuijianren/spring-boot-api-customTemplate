package cn.zuijianren.exception;

import lombok.Getter;

/**
 * @author zuijianren
 * @date 2020/11/12 10:28
 */
@Getter
public class APIException extends RuntimeException{
    private int code;
    private String msg;

    public APIException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public APIException(String msg){
        this(1001, msg);
    }

    public APIException(){
        this(1001, "接口错误");
    }
}
