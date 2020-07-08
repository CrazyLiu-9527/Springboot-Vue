package per.lzy.springboot.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author zhiyuanliu
 * @date 2020/7/3 16:03
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum EnumErrorType {
    TOKEN_VALIDATION_FAILS(401, "TOKEN 验证失败"),
    ILLEGAL_REQUESTER(403, "请求方非法"),
    ILLEGAL_PARAMETER(406, "请求参数校验不合法"),
    DUPLICATION_DATA(409, "数据重复, 违反唯一性"),
    VERSION_OVERDUE(410, "版本已过期"),
    NOT_EXPECTATIONS(412, "数据不符合预期"),
    SERVER_ERROR(500, "服务端错误");

    private int code;
    private String message;

    public static EnumErrorType getTypeByCode(int code) {
        EnumErrorType[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            EnumErrorType errorType = var1[var3];
            if (errorType.code == code) {
                return errorType;
            }
        }

        return null;
    }

}
