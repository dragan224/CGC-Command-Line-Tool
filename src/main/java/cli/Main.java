package cli;

import args.ArgsMetadata;
import http.Api;

public class Main {
    
    public static void main(String[] argv) throws Exception {
        ResponseHandler handler = new ResponseHandler(new Api());
        System.out.println(handler.handleResponse(argv));
    }
    
}
