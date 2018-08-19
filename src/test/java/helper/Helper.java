package helper;

import annotations.*;

public class Helper {
    @Name("my_real_name")
    @Header
    public Integer name;
    
    @Header
    public Integer header;
    
    @QueryString
    public Integer other_name;

    public Helper(Integer name, Integer header, Integer other_name) {
        super();
        this.name = name;
        this.header = header;
        this.other_name = other_name;
    }
}
