package args;

import com.beust.jcommander.*;

import annotations.QueryString;

/**
 * Arguments for listing projects, 
 * please see: https://docs.cancergenomicscloud.org/docs/list-all-your-projects
 */
@Parameters(separators = "= ")
public class ArgsListProjects extends ArgsBase {
    @QueryString
    @Parameter(names = "fields")
    public String fields;
    
    @QueryString
    @Parameter(names = "offset")
    public Integer offset;
    
    @QueryString
    @Parameter(names = "limit")
    public Integer limit;
}
