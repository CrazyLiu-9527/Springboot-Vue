package per.lzy.springboot.model.base;

import per.lzy.springboot.model.enums.EnumAckCodeType;
import per.lzy.springboot.model.enums.EnumErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author zhiyuanliu
 * @date 2020/7/3 16:02
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStatusType {
    private EnumAckCodeType ackCodeType;
    private EnumErrorType errorType;
    private long timestamp = System.currentTimeMillis();
    private List<ExtensionType> extensions;
}
