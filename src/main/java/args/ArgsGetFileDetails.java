package args;

import com.beust.jcommander.*;
import annotations.*;

/**
 * Arguments for retrieving details of a file.
 * please see: https://docs.cancergenomicscloud.org/docs/get-file-details
 */
@Parameters(separators = "= ")
public class ArgsGetFileDetails extends ArgsBase {
    
    @Header
    @Name("X-SBG-Advance-Access")
    @Parameter(names = "advance")
    public String advance;
    
    @QueryString
    @Parameter(names = "fields")
    public String fields;
    
    @Parameter(names = "--file", required = true)
    public String file_id;
    
}
