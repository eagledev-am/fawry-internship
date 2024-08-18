package system.util;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger obj;

    private Logger(){

    }

    public static Logger getInstance() {
        if(obj == null)
            obj = new Logger();
        return obj;
    }

    public void log(String message){
        try{
            FileWriter writer = new FileWriter("log.txt", true);
            writer.write("Message : '" + message + "' is logged to file\n");
            writer.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Message : '" + message + "' is logged to file");
    }

}
