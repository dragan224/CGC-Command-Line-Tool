package args;

import java.util.ArrayList;
import java.util.List;  
import com.beust.jcommander.*;

import annotations.*;

/**
 * Class that controls user's command line arguments input. 
 * These commands are shared between all possible user inputs.
 */
public class ArgsBase {
    @Parameter // All remaining arguments (ones not specifically defined)
    public List<String> parameters = new ArrayList<>();
    
    @Header
    @Name("X-SBG-Auth-Token")
    @Parameter(names = "--token", required = true)
    public String token;
    
    @Parameter(names = "--help", help = true)
    public boolean help;
}
