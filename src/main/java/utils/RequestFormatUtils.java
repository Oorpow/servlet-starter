package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class RequestFormatUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 读取请求体并转换为指定对象
     */
    public static <T> T readJsonFromBody(HttpServletRequest request, Class<T> clazz)
            throws IOException {
        String jsonBody = readRequestBody(request);
        if (jsonBody == null || jsonBody.trim().isEmpty()) {
            return null;
        }
        return objectMapper.readValue(jsonBody, clazz);
    }

    /**
     * 将请求体JSON转换为Map
     */
    public static Map<String, Object> parseRequestBodyToMap(HttpServletRequest request)
            throws IOException {
        StringBuilder body = new StringBuilder();
        String line;

        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                body.append(line);
            }
        }

        String jsonBody = body.toString();
        if (jsonBody.isEmpty()) {
            return new java.util.HashMap<>();
        }

        try {
            return objectMapper.readValue(jsonBody, new TypeReference<Map<String, Object>>() {});
        } catch (Exception e) {
            throw new IOException("JSON解析失败: " + e.getMessage(), e);
        }
    }

    /**
     * 读取请求体内容
     */
    public static String readRequestBody(HttpServletRequest request) throws IOException {
        StringBuilder body = new StringBuilder();
        String line;

        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                body.append(line);
            }
        }

        return body.toString();
    }

    /**
     * 将对象转换为JSON字符串
     */
    public static String toJson(Object obj) throws IOException {
        return objectMapper.writeValueAsString(obj);
    }
}
