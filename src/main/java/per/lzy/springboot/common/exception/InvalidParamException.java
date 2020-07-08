package per.lzy.springboot.common.exception;


/**
 * 非法请求参数异常
 * @author zhiyuanliu
 */
public class InvalidParamException extends RuntimeException {
    public InvalidParamException(String paramName) {
        super("Parameter [" + paramName + "] contains illegal value");
    }

    public InvalidParamException() {
        super("Parameter contains illegal value");
    }
}
