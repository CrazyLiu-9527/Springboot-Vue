package per.lzy.springboot.model.contract;

import per.lzy.springboot.model.base.BaseResponse;
import lombok.Data;

import java.util.Map;

/**
 * @author zhiyuanliu
 * @date 2020/7/3 16:06
 */
@Data
public class GetUserInfoResponse extends BaseResponse {
    private Map map;
}
