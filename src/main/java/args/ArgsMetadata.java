package args;

import com.beust.jcommander.*;

import annotations.*;
import validators.*;

/**
 * Metadata fields, please see: https://docs.cancergenomicscloud.org/docs/metadata-for-private-data
 */
@Parameters(separators = "= ")
public class ArgsMetadata extends ArgsBase {
    @QueryString
    @Parameter(names = "metadata.library_id")
    public String library_id;
    
    @QueryString
    @Parameter(names = "metadata.platform")
    public String platform;
    
    @QueryString
    @Parameter(names = "metadata.platform_unit_id")
    public String platform_unit_id;
    
    @QueryString
    @Parameter(names = "metadata.paired_end", validateWith=IntegerOneTwo.class)
    public Integer paired_end;
    
    @QueryString
    @Parameter(names = "metadata.file_segment_number", validateWith=NonNegativeInteger.class)
    public Integer file_segment_number;
    
    @QueryString
    @Parameter(names = "metadata.quality_scale", validateWith=QualityScale.class)
    public String quality_scale;
    
    @QueryString
    @Parameter(names = "metadata.experimental_strategy")
    public String experimental_strategy;
    
    @QueryString
    @Parameter(names = "metadata.reference_genome")
    public String reference_genome;
    
    @QueryString
    @Parameter(names = "metadata.sample_id")
    public String sample_id;
    
    @QueryString
    @Parameter(names = "metadata.sample_type")
    public String sample_type;
    
    @QueryString
    @Parameter(names = "metadata.sample_uuid")
    public String sample_uuid;
    
    @QueryString
    @Parameter(names = "metadata.aliquot_id")
    public String aliquot_id;
    
    @QueryString
    @Parameter(names = "metadata.aliquot_uuid")
    public String aliquot_uuid;
    
    @QueryString
    @Parameter(names = "metadata.case_id")
    public String case_id;
    
    @QueryString
    @Parameter(names = "metadata.case_uuid")
    public String case_uuid;
    
    @QueryString
    @Parameter(names = "metadata.primary_site")
    public String primary_site;
    
    @QueryString
    @Parameter(names = "metadata.disease_type")
    public String disease_type;
    
    @QueryString
    @Parameter(names = "metadata.gender", validateWith=MaleFemale.class)
    public String gender;
    
    @QueryString
    @Parameter(names = "metadata.age_at_diagnosis", validateWith=NonNegativeInteger.class)
    public Integer age_at_diagnosis;
    
    @QueryString
    @Parameter(names = "metadata.vital_status", validateWith=VitalStatus.class)
    public String vital_status;
    
    @QueryString
    @Parameter(names = "metadata.days_to_death")
    public Integer days_to_death;
    
    @QueryString
    @Parameter(names = "metadata.race")
    public String race;
    
    @QueryString
    @Parameter(names = "metadata.ethnicity")
    public String ethnicity;
    
    @QueryString
    @Parameter(names = "metadata.investigation")
    public String investigation;
}
