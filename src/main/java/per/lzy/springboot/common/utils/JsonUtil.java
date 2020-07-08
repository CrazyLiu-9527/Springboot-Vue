package per.lzy.springboot.common.utils;

import per.lzy.springboot.model.enums.EnumObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

/**
 * json工具类
 *
 * @author zhiyuanliu
 * @date 2020/7/6 14:05
 */
@Slf4j
public class JsonUtil {
    private static final ObjectMapper OBJECT_MAPPER = EnumObjectMapper.INSTANCE.getMapper();

    /**
     * json序列化
     *
     * @param obj 需要序列化的对象
     * @return
     */
    public static String toJson(Object obj) {
        if (null == obj) {
            return "";
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            log.error("JsonUtil toJson Exception:", e);
        }
        return "";
    }

    /**
     * 反序列化json格式字符串
     *
     * @param json  字符串
     * @param clazz 实体类型
     * @param <T>   泛型类
     * @return
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            log.error("JsonUtil fromJson Exception:", e);
        }
        return null;
    }

    /**
     * object类型转换为T类型
     *
     * @param json  obj
     * @param clazz 实体类型
     * @param <T>   泛型类
     * @return
     */
    public static <T> T fromObject(Object json, Class<T> clazz) {
        if (json == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.convertValue(json, clazz);
        } catch (Exception e) {
            log.error("JsonUtil fromObject Exception:", e);
        }
        return null;
    }

    /**
     * 反序列化为jsonNode格式
     *
     * @param json 字符串
     * @return
     */
    public static ObjectNode toObjectNode(String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return (ObjectNode) OBJECT_MAPPER.readTree(json);
        } catch (Exception e) {
            log.error("JsonUtil toObjectNode Exception:", e);
        }
        return null;
    }

    /**
     * 反序列化为ArrayNode类型
     *
     * @param json 字符串
     * @return
     */
    public static ArrayNode toArrayNode(String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return (ArrayNode) OBJECT_MAPPER.readTree(json);
        } catch (Exception e) {
            log.error("JsonUtil toObjectNode Exception:", e);
        }
        return null;
    }

    /**
     * 反序列化为List<T>类型
     *
     * @param str 字符串
     * @param cls 实体类型
     * @param <T> 泛型类
     * @return
     */
    public static <T> List<T> DeserializeArray(String str, Class<T> cls) {
        try {
            JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, cls);
            return (List<T>) OBJECT_MAPPER.readValue(str, javaType);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化为JsonNode格式
     *
     * @param json 字符串
     * @return
     */
    public static JsonNode toJsonNode(String json) {
        try {
            JsonNode node = OBJECT_MAPPER.readTree(json);
            return node;
        } catch (IOException e) {
            log.error("JsonUtil toJsonNode Exception:", e);
        }

        return null;
    }

}
