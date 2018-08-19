package helper;

import java.io.File;
import java.net.URL;

import args.ArgsFileDownload;
import args.ArgsGetFileDetails;
import args.ArgsListFiles;
import args.ArgsListProjects;
import args.ArgsMetadata;
import args.ArgsUpdateFile;
import http.Api;
import http.RequestBuilder;

public class MockedApi extends Api {
    public String help() {
        return "help";
    }
    
    public String listProjects(ArgsListProjects args) throws Exception {
        return "listProjects";
    }
    
    public String listProjectFiles(ArgsListFiles args, ArgsMetadata metadata) throws Exception {
        return "listProjectFiles";
    }
    
    public String getFileDetails(ArgsGetFileDetails args) throws Exception {
        return "getFileDetails";
    }
    
    public String fileDownload(ArgsFileDownload args) throws Exception {
        return "fileDownload";
    }
    
    public String updateFile(ArgsUpdateFile args, ArgsMetadata metadata) throws Exception {
        return "updateFile";
    }
}
