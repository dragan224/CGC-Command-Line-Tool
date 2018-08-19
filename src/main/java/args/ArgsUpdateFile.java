package args;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.*;
import annotations.*;

/**
 * Arguments for updating a file
 * please see: https://docs.cancergenomicscloud.org/docs/update-file-details
 */
@Parameters(separators = ",= ")
public class ArgsUpdateFile extends ArgsBase {
    
    @QueryString
    @Parameter(names = "tags", variableArity = true)
    public List<String> tags = new ArrayList<>();
    
    @QueryString
    @Parameter(names = "name")
    public String name;
    
    @Parameter(names = "--file", required = true)
    public String file_id;
    
}
