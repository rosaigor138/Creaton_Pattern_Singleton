package org.example;

import java.util.Objects;

public class Logger {

    private static Logger log;
    private Logger(){}


    public static Logger getInstance(){
        if(log == null){
            log = new Logger();
        }
        return log;
    }

    public void log(String logMessage){
        if(Objects.equals(logMessage, "")) {
            System.out.println(loggerDefault);
        }else System.out.println(logMessage);
    }

    private String loggerDefault;

    public void setLoggerDefault(String loggerDefault) {
        this.loggerDefault = loggerDefault;
    }

    public String isLoggerDefault() {
        return loggerDefault;
    }
}
