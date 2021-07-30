package ddd.leave.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Response {

    private Status status;
    private String msg;
    private Object data;

    public static Response ok(){
        return new Response().setStatus( Status.SUCCESS);
    }

    public static Response ok(Object data){
        return new Response().setStatus( Status.SUCCESS).setData( data);
    }

    public static Response failed(String msg){
        return new Response().setStatus( Status.FAILED);
    }

    public enum Status{
        SUCCESS, FAILED
    }
}
