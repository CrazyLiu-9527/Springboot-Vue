package per.lzy.springboot.common.exception;


/**
 * 参数为空请求异常
 * @author zhiyuanliu
 */
public class BlankParamException extends RuntimeException {
    public BlankParamException(String paramName) {
        super("Parameter [" + paramName + "] cannot be blank");
    }

    public BlankParamException() {
        super("Parameter contains illegal null value");
    }
}
