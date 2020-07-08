package per.lzy.springboot.model.contract;

import per.lzy.springboot.model.base.BaseResponse;
import lombok.Data;

/**
 * @author zhiyuanliu
 * @date 2020/7/3 16:00
 */
@Data
public class TestResponse extends BaseResponse {
    private String info;
}
