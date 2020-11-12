package cn.zuijianren.model;

import lombok.Getter;
import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * @author zuijianren
 * @date 2020/11/12 10:18
 */
@Getter
public class ResultV0<T> {
    private int code;
    private String msg;
    private T data;

    public ResultV0(T data){
        this(ResultCode.SUCCESS, data);
    }

    public ResultV0(ResultCode resultCode, T data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
