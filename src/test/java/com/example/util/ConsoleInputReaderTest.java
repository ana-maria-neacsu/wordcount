package com.example.util;

import com.example.interfaceExample.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ConsoleInputReaderTest {

    @Test
    public void testReadLineNewLine(){
        ByteArrayInputStream in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);
        InputReader reader = new ConsoleInputReader();
        String input = reader.readLine();
        Assertions.assertEquals("", input);
    }
    @Test
    public void testReadLineValidString(){
        ByteArrayInputStream in = new ByteArrayInputStream("word\n".getBytes());
        System.setIn(in);
        InputReader reader = new ConsoleInputReader();
        String input = reader.readLine();
        Assertions.assertEquals("word", input);
    }
}
