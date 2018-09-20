package cn.iceyax.utils;

import cn.iceyax.base.resp.ResponseEntity;
import cn.iceyax.constants.SystemConstant;

public class ResponseUtils {
	/**
     * 返回失败的信息
     * @param msg
     * @return
     */
    public static <T> ResponseEntity<T> fail(String msg){
        return fail(SystemConstant.FAIL, msg);
    }

    /**
     * 返回失败的信息
     * @param code
     * @param msg
     * @return
     */
    public static <T> ResponseEntity<T> fail(String code, String msg){
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(code);
        responseEntity.setMsg(msg);
        return responseEntity;
    }

    /**
     * 返回成功的信息
     * @param t
     * @return
     */
    public static <T> ResponseEntity<T> success(T t){
        ResponseEntity<T> result = new ResponseEntity<>();
        result.setCode(SystemConstant.SUCCESS);
        result.setMsg("");
        result.setData(t);
        return result;
    }
    /**
     * 返回成功的信息
     * @param t
     * @return
     */
    public static <T> ResponseEntity<T> success(String message , T t){
        ResponseEntity<T> result = new ResponseEntity<>();
        result.setCode(SystemConstant.SUCCESS);
        result.setMsg(message);
        result.setData(t);
        return result;
    }
}
