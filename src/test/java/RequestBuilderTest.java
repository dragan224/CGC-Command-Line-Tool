import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;

import args.ArgsMetadata;
import args.ArgsUpdateFile;
import helper.Helper;
import http.RequestBuilder;

public class RequestBuilderTest {

    @Test
    public void testBuildHeaders() {
        try {
            Map<String, String> expected = ImmutableMap.of("my_real_name", "1", "header", "2");
            assertEquals(expected, RequestBuilder.buildHeaders(new Helper(1, 2, null)));
        } catch (Exception e) {
            fail(e.getMessage());
        }
        try {
            Map<String, String> expected = ImmutableMap.of("header", "2");
            assertEquals(expected, RequestBuilder.buildHeaders(new Helper(null, 2, null)));
        } catch (Exception e) {
            fail(e.getMessage());
        }
        try {
            Map<String, String> expected = ImmutableMap.of("my_real_name", "1", "header", "2");
            assertEquals(
                    expected, 
                    RequestBuilder.buildHeaders(new Helper(null, 2, null), new Helper(1, null, null)));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testBuildQueryString() {
        try {
            Map<String, Object> expected = ImmutableMap.of("other_name", "100");
            assertEquals(expected, RequestBuilder.buildQueryString(new Helper(1, 2, 100)));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testBuildUpdateFileJsonBody() {
        ArgsMetadata meta = new ArgsMetadata();
        ArgsUpdateFile args = new ArgsUpdateFile();
        
        args.tags.add("tag_1");
        args.tags.add("tag_2");
        args.name = "dm";
        
        meta.age_at_diagnosis = 20;
        meta.aliquot_id = "some_id";
        meta.case_id = "case_id";
        
        try {
            String expected = "{\"metadata\":{\"age_at_diagnosis\":\"20\",\"aliquot_id\":\"some_id\",\"case_id\":\"case_id\"},\"name\":\"dm\",\"tags\":[\"tag_1\",\"tag_2\"]}";
            assertEquals(
                    expected.trim(),
                    RequestBuilder.buildUpdateFileJsonBody(args, meta).trim());
        } catch (Exception e) {
            
            fail(e.getMessage());
        }
    }
}
