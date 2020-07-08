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
public enum EnumAckCodeType {
    SUCCESS(0),
    FAILURE(1);

    private int value;

}
