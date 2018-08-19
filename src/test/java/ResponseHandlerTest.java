import static org.junit.Assert.*;

import org.junit.Test;

import cli.ResponseHandler;
import helper.MockedApi;
import http.Api;
public class ResponseHandlerTest {
    
    ResponseHandler handler = new ResponseHandler(new MockedApi());
    
    @Test
    public void testHelp() {
        try {
            assertEquals(
                    "help", 
                    handler.handleResponse(new String[] 
                    {"--help", "files", "stat", "help should come first"}));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testFileStat() {
        try {
            assertEquals(
                    "getFileDetails", 
                    handler.handleResponse(new String[] 
                    {"files", "stat", "--token", "token", "--file", "whatever"}));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testProjectsList() {
        try {
            assertEquals(
                    "listProjects", 
                    handler.handleResponse(new String[] 
                    {"projects", "--token", "token", "list"}));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testFileList() {
        try {
            assertEquals(
                    "listProjectFiles", 
                    handler.handleResponse(new String[] 
                    {"files", "list", "--token", "token", "--project", "test"}));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testFileUpdate() {
        try {
            assertEquals(
                    "updateFile", 
                    handler.handleResponse(new String[] 
                    {"files", "update", "--token", "token", "--file", "test"}));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testFileDownload() {
        try {
            assertEquals(
                    "fileDownload", 
                    handler.handleResponse(new String[] 
                    {"files", "--token", "token", "download", "--dest", "/tmp/foo.bar", "--file", "test"}));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
