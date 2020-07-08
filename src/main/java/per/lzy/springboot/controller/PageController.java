package per.lzy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhiyuanliu
 * @date 2020/7/3 15:59
 */
@Controller
public class PageController {
    @RequestMapping({"/", "/home", "/index", "/main", "/error"})
    public String index() {
        return "redirect:index.html";
    }
}
