package validators;

import com.beust.jcommander.*;

/**
 * Checks if the command line argument is 1 or 2.
 */
public class IntegerOneTwo implements IParameterValidator {
    public void validate(String name, String value) throws ParameterException {
        int n = Integer.parseInt(value);
        if (n != 1 && n != 2) {
            throw new ParameterException(name + " needs to be 1 or 2");
        }
    }
}
