package per.lzy.springboot.model.base;

import per.lzy.springboot.model.enums.EnumAckCodeType;
import per.lzy.springboot.model.enums.EnumErrorType;
import com.google.common.collect.Lists;

import java.io.Serializable;

/**
 * @author zhiyuanliu
 * @date 2020/7/3 16:01
 */
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = -9035396755887272093L;
    private ResponseStatusType responseStatusType;

    public void setSuccess() {
        this.responseStatusType = new ResponseStatusType();
        this.responseStatusType.setAckCodeType(EnumAckCodeType.SUCCESS);
    }

    public void setFailure() {
        this.responseStatusType = new ResponseStatusType();
        this.responseStatusType.setAckCodeType(EnumAckCodeType.FAILURE);
    }

    public void setFailure(EnumErrorType errorCodeType) {
        this.responseStatusType = new ResponseStatusType();
        this.responseStatusType.setAckCodeType(EnumAckCodeType.FAILURE);
        this.responseStatusType.setErrorType(errorCodeType);
    }

    public void setFailure(EnumErrorType errorCodeType, ExtensionType extensionType) {
        this.responseStatusType = new ResponseStatusType();
        this.responseStatusType.setAckCodeType(EnumAckCodeType.FAILURE);
        this.responseStatusType.setErrorType(errorCodeType);
        this.responseStatusType.setExtensions(Lists.newArrayList(extensionType));
    }

    public ResponseStatusType getResponseStatusType() {
        return this.responseStatusType;
    }

    public void setResponseStatusType(final ResponseStatusType responseStatusType) {
        this.responseStatusType = responseStatusType;
    }

    public BaseResponse() {
    }

    public BaseResponse(final ResponseStatusType responseStatusType) {
        this.responseStatusType = responseStatusType;
    }
}
