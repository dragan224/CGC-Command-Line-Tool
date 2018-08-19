package args;

import com.beust.jcommander.*;

public class Parser {
    public static Object parseArgs(String[] argv, Class<?> clazz) throws Exception {
        Object args = clazz.newInstance();
            
        JCommander.newBuilder()
        .addObject(args)
        .build()
        .parse(argv);
        
        return args;  
    }
}
