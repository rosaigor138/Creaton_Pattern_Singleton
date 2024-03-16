package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoggerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    @Test
    public void shouldReturnLoggerDefault(){
        Logger.getInstance().setLoggerDefault("error");
        assertEquals("error",
                Logger.getInstance().isLoggerDefault());
    }

    @Test
    public void shouldPrintRightMessage(){
        Logger.getInstance().log("hello");
        assertEquals("hello\n", outContent.toString());
    }

    @Test
    public void shouldPrintDefaultLog(){
        Logger.getInstance().setLoggerDefault("error");
        Logger.getInstance().log("");
        assertEquals("error\n", outContent.toString());
    }

}