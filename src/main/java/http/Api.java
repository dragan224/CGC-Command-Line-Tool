package http;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import com.mashape.unirest.http.*;
import args.*;

/**
 * Wrapper for API calls to CGC.
 */
public class Api {
    
    private static int INDENTATION = 2; // JSON response indentation
    private static int STATUS_OK = 200;
    
    public String help() {
        return "Sample usage: \n"
             + "cgccli --token {token} projects list \n"
             + "cgccli --token {token} files list --project test/simons-genome-diversity-project-sgdp\n"
             + "cgccli --token {token} files stat --file {file_id}\n"
             + "cgccli --token {token} files update --file {file_id} name=bla\n"
             + "cgccli --token {token} files update --file {file_id} metadata.sample_id=asdasf\n"
             + "cgccli --token {token} files download --file {file_id} --dest /tmp/foo.bar\n"
             + "Please see: https://docs.cancergenomicscloud.org/docs/the-cgc-api​ for detailed parameter documentation \n";
    }
    
    public String listProjects(ArgsListProjects args) throws Exception {
        return Unirest.get("https://cgc-api.sbgenomics.com/v2/projects")
        .headers(RequestBuilder.buildHeaders(args))
        .queryString(RequestBuilder.buildQueryString(args))
        .asJson().getBody().getObject().toString(INDENTATION);
    }
    
    public String listProjectFiles(ArgsListFiles args, ArgsMetadata metadata) throws Exception {
        return Unirest.get("https://cgc-api.sbgenomics.com/v2/files")
        .headers(RequestBuilder.buildHeaders(args))
        .queryString(RequestBuilder.buildQueryString(args, metadata))
        .asJson().getBody().getObject().toString(INDENTATION);
    }
    
    public String getFileDetails(ArgsGetFileDetails args) throws Exception {
        return Unirest.get("https://cgc-api.sbgenomics.com/v2/files/{file_id}")
        .headers(RequestBuilder.buildHeaders(args))
        .queryString(RequestBuilder.buildQueryString(args))
        .routeParam("file_id", args.file_id)
        .asJson().getBody().getObject().toString(INDENTATION);
    }
    
    public String fileDownload(ArgsFileDownload args) throws Exception {
        HttpResponse<JsonNode> response = Unirest.get("https://cgc-api.sbgenomics.com/v2/files/{file_id}/download_info")
        .headers(RequestBuilder.buildHeaders(args))
        .queryString(RequestBuilder.buildQueryString(args))
        .routeParam("file_id", args.file_id)
        .asJson();
        
        if (response.getStatus() == STATUS_OK) {
            System.out.println("Downloading in progress...");
            String url = response.getBody().getObject().getString("url");
            FileUtils.copyURLToFile(new URL(url), new File(args.dest));
        }
        
        return "Response: " + response.getStatus();
    }
    
    public String updateFile(ArgsUpdateFile args, ArgsMetadata metadata) throws Exception {
        HttpResponse<JsonNode> response = Unirest.patch("https://cgc-api.sbgenomics.com/v2/files/{file_id}")
        .routeParam("file_id", args.file_id)
        .header("accept", "application/json")
        .header("Content-Type", "application/json")
        .header("X-SBG-Auth-Token", args.token)
        .body(RequestBuilder.buildUpdateFileJsonBody(args, metadata))
        .asJson();
        
        return "Response: " + response.getStatus();
    }
}
