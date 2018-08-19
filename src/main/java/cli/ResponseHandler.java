package cli;

import com.beust.jcommander.*;
import java.util.ArrayList;
import java.util.Arrays;

import args.*;
import http.Api;

/**
 * Class that contains method for handling user input.
 */
public class ResponseHandler {
    public ResponseHandler(Api api)
    {
        this.api = api;
    }
    
    public String handleResponse(String[] argv) throws Exception {
        ArgsBase args = (ArgsBase) Parser.parseArgs(argv, ArgsBase.class);
        if (args.help) {
            return api.help();
        }
        if (args.parameters.containsAll(Arrays.asList("projects", "list"))) {
            return api.listProjects((ArgsListProjects) Parser.parseArgs(argv, ArgsListProjects.class));
        }
        if (args.parameters.containsAll(Arrays.asList("files", "list"))) {
            return api.listProjectFiles(
                    (ArgsListFiles) Parser.parseArgs(argv, ArgsListFiles.class),
                    (ArgsMetadata) Parser.parseArgs(argv, ArgsMetadata.class));
        }
        if (args.parameters.containsAll(Arrays.asList("files", "stat"))) {
            return api.getFileDetails((ArgsGetFileDetails) Parser.parseArgs(argv, ArgsGetFileDetails.class));
        }
        if (args.parameters.containsAll(Arrays.asList("files", "download"))) {
            return api.fileDownload((ArgsFileDownload) Parser.parseArgs(argv, ArgsFileDownload.class));
        }
        if (args.parameters.containsAll(Arrays.asList("files", "update"))) {
            return api.updateFile(
                    (ArgsUpdateFile) Parser.parseArgs(argv, ArgsUpdateFile.class),
                    (ArgsMetadata) Parser.parseArgs(argv, ArgsMetadata.class));
        }
        
        return "Unrecognized command. Please try running cgccli --help";
    }
    
    private Api api;
}
