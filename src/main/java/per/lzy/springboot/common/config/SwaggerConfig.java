package per.lzy.springboot.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 * http://localhost:8080/swagger-ui.html
 * @author zhiyuanliu
 * @date 2020/7/3 15:56
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return (new Docket(DocumentationType.SWAGGER_2))
                .apiInfo(this.buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo() {
        return (new ApiInfoBuilder())
                .title("iQuality后台站点")
                .description("iQuality后台站点api展示页面")
                .termsOfServiceUrl("http://iquality.ctripcorp.com")
                .version("1.0")
                .build();
    }
}
