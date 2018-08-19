package args;

import com.beust.jcommander.*;
import annotations.*;

/**
 * Arguments for listing files in a project, 
 * please see: https://docs.cancergenomicscloud.org/docs/list-files-in-a-project
 */
@Parameters(separators = "= ")
public class ArgsListFiles extends ArgsBase {
    
    @QueryString
    @Parameter(names = "--project", required=true)
    public String project;
    
    @QueryString
    @Parameter(names = "name")
    public String name;
    
    @QueryString
    @Parameter(names = "origin.task")
    public String origin_task;
    
    @QueryString
    @Parameter(names = "origin.dataset")
    public String origin_dataset;
    
    @QueryString
    @Parameter(names = "fields")
    public String fields;
    
    @QueryString
    @Parameter(names = "tag")
    public String tag;
}
