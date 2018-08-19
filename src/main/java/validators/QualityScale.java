package validators;

import com.beust.jcommander.*;

/**
 * Checks if the command line argument is a valid entry for metadata.quality_scale.
 */
public class QualityScale implements IParameterValidator {
    public void validate(String name, String value) throws ParameterException {
        if (!value.equals("sanger") && 
            !value.equals("llumina13") && 
            !value.equals("solexa") &&
            !value.equals("illumina15") && 
            !value.equals("illumina18")) {
            
            throw new ParameterException(name + " needs to be one of [sanger, llumina13, solexa, illumina18, illumina15]");
        }
    }
}