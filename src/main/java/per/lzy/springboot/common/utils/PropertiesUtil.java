package per.lzy.springboot.common.utils;

import ch.qos.logback.classic.gaffer.PropertyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 去中文工具类
 * @author zhiyuanliu
 * @date 2020/5/11 14:03
 */
@Slf4j
@Component
public class PropertiesUtil {
    private static Properties props;

    static {
        loadProps();
    }

    private static void loadProps() {
        log.info("loading language-properties.......");
        props = new Properties();
        InputStream in = null;
        try {
            in = PropertyUtil.class.getResourceAsStream("/language-mapping.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            log.error("language-mapping.properties not found");
        } catch (IOException e) {
            log.error("IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("jdbc.properties close exception");
            }
        }
        log.info("load properties finish...........");
        log.info("properties content：" + props);
    }

    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }

    public static void main(String[] args) {
        System.out.println(getProperty("HOTEL"));
        System.out.println(getProperty("FLIGHT"));
        System.out.println(getProperty("KeyWordComment"));
    }
}
