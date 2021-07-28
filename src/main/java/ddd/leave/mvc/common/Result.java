package ddd.leave.mvc.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Rao
 * @Date 2021/7/28
 **/
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {


    private int code = 200;

    private String message;

    private T data;


    public static <T> Result<T> success(T data){
        return new Result<T>().setData(data).setCode(200).setMessage("操作成功！");
    }


}

