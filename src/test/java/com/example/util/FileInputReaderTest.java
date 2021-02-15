package com.example.util;

import com.example.interfaceExample.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileInputReaderTest {

    @Test
    public void testReadInputEmptyFile(){
        String emptyString = "";
        InputReader inputReader = new FileInputReader("mytextEmpty.txt");
        Assertions.assertEquals(emptyString, inputReader.readInput());
    }
    @Test
    public void testReadInputFileNotFound(){
        InputReader inputReader = new FileInputReader("invalidFile.txt");
        Assertions.assertEquals("", inputReader.readInput());
    }
    @Test
    public void testReadInputOneWordInFile(){
        String testInput = "sd "; //file contains "sd"
        InputReader inputReader = new FileInputReader("mytext.txt");
        Assertions.assertEquals(testInput, inputReader.readInput());
    }
}
