package http;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.management.Query;

import annotations.*;
import args.ArgsBase;
import args.ArgsMetadata;
import args.ArgsUpdateFile;
import org.json.*;

/**
 * Class that filters out non null parameters to be used in http requsts.
 */
public class RequestBuilder {
    
    private static Map<String, String> names = new HashMap<>();
    
    // Retrieves all non null fields with a certain annotation
    private static List<Field> getAllNonNullFields(Object object, Class annotation) throws Exception {
        List<Field> result = new ArrayList<>();
        Field[] allFields = object.getClass().getFields();
        for (Field field: allFields) {
            if (field.get(object) == null || field.getAnnotation(annotation) == null) {
                continue;
            }
            result.add(field);
        }
        return result;
    }
    
    // Finds all fields with specified annotations
    private static Map<String, Object> findAllObject(Class annotation, Object... objects) throws Exception {
        Map<String, Object> result = new HashMap<>();
        for (Object object: objects) {
            List<Field> fields = getAllNonNullFields(object, annotation);
            for (Field field: fields) {
                if (field.getAnnotation(Name.class) != null) {
                    result.put(field.getAnnotation(Name.class).value(), field.get(object).toString());
                } else {
                    result.put(field.getName(), field.get(object).toString());
                }
            }
        }
        return result;
    }
    
    private static Map<String, String> findAllString(Class annotation, Object... objects) throws Exception {
        Map<String, Object> result = findAllObject(annotation, objects);
        return result // convert to Map<String, String>
               .entrySet()
               .stream()
               .collect(Collectors.toMap(Map.Entry::getKey, e -> (String)e.getValue()));
    }
    
    public static Map<String, Object> buildQueryString(Object... objects) throws Exception {
        return findAllObject(QueryString.class, objects);
    }
    
    public static Map<String, String> buildHeaders(Object... objects) throws Exception {
        return findAllString(Header.class, objects);
    }
    
    public static String buildUpdateFileJsonBody(ArgsUpdateFile args, ArgsMetadata metadata) throws Exception {
        JSONObject json = new JSONObject();
        if (args.name != null) {
            json.put("name", args.name);
        }
        List<Field> fields = getAllNonNullFields(metadata, QueryString.class);
        if (!fields.isEmpty()) {
            JSONObject metadataJson = new JSONObject();
            for (Field field: fields) {
                metadataJson.put(field.getName(), field.get(metadata).toString());
            }
            json.put("metadata", metadataJson);
        }
        if (!args.tags.isEmpty()) {
            json.put("tags", args.tags);
        }
        return json.toString();
    }
}
