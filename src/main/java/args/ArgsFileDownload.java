package args;

import com.beust.jcommander.*;
import annotations.*;

/**
 * Download a file to a specified destination.
 * please see: https://docs.cancergenomicscloud.org/docs/get-download-url-for-a-file
 */
@Parameters(separators = "= ")
public class ArgsFileDownload extends ArgsBase {
    
    @QueryString
    @Parameter(names = "fields")
    public String fields;
    
    @Parameter(names = "--file", required = true)
    public String file_id;
    
    @Parameter(names = "--dest", required = true)
    public String dest;
    
}
