package validators;

import com.beust.jcommander.*;

/**
 * Checks if the command line argument is valid entry for metadata.vital_status
 */
public class VitalStatus implements IParameterValidator {
    public void validate(String name, String value) throws ParameterException {
        if (!value.equals("Alive") && 
            !value.equals("Dead") && 
            !value.equals("Lost to follow-up") &&
            !value.equals("Unknown") && 
            !value.equals("Not available")) {
            
            throw new ParameterException(name + " needs to be one of [Not available, Unknown, Lost to follow-up, Dead, Alive]");
        }
    }
}