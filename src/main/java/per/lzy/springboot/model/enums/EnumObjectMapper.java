package per.lzy.springboot.model.enums;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS;
import static com.fasterxml.jackson.databind.MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS;
import static com.fasterxml.jackson.databind.MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES;

/**
 * 创建单例ObjectMapper
 * @author zhiyuanliu
 * @date 2020/7/6 14:06
 */
public enum EnumObjectMapper {
    INSTANCE;

    private ObjectMapper dataMapper = new ObjectMapper();

    private EnumObjectMapper() {
        config(dataMapper);
    }

    public ObjectMapper getMapper() {
        return dataMapper;
    }


    public void config(ObjectMapper mapper) {
        objectConfig(mapper);
    }

    private void objectConfig(ObjectMapper mapper) {

        mapper.registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        mapper.configure(ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(ACCEPT_CASE_INSENSITIVE_ENUMS, true);

        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }
}
