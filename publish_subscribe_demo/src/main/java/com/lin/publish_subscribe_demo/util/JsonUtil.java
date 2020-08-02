package com.lin.publish_subscribe_demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.boot.json.JsonParseException;

import java.io.IOException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/1
 * \* Time: 15:40
 * \* Description:
 * \
 */
public class JsonUtil {

    public static String toJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toPrettyJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        try {
            return writer.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toJson(String json, TypeReference<T> ref) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, ref);
        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
