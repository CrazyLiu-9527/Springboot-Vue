package per.lzy.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 放在tomcat内跑需要 extends SpringBootServletInitializer
 * @author zhiyuanliu
 * @date 2020/7/3 15:52
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class).bannerMode(Banner.Mode.OFF);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
