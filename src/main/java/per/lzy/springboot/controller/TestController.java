package per.lzy.springboot.controller;

import per.lzy.springboot.model.contract.TestRequest;
import per.lzy.springboot.model.contract.TestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiyuanliu
 * @date 2020/7/3 15:59
 */
@RestController
@RequestMapping("/api")
public class TestController {
    public TestController() {
    }

    @PostMapping({"/test"})
    @ApiOperation(tags = {"测试接口"}, value = "测试接口")
    public TestResponse test(@RequestBody TestRequest request) {
        TestResponse response = new TestResponse();
        String ret = "测试id:" + request.getTestId();
        response.setInfo(ret);
        response.setSuccess();
        return response;
    }

}
