package validators;

import com.beust.jcommander.*;

/**
 * Checks if the command line argument is a male or female.
 */
public class MaleFemale implements IParameterValidator {
    public void validate(String name, String value) throws ParameterException {
        if (!value.equals("Female") && !value.equals("Male")) {      
            throw new ParameterException(name + " can only be 'Male' or 'Female'");
        }
    }
}
