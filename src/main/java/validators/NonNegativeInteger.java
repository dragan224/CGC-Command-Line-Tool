package validators;

import com.beust.jcommander.*;

/**
 * Checks if the command line argument is non negative number.
 */
public class NonNegativeInteger implements IParameterValidator {
    public void validate(String name, String value) throws ParameterException {
        int n = Integer.parseInt(value);
        if (n < 0) {
            throw new ParameterException(name + " is negative.");
        }
    }
}