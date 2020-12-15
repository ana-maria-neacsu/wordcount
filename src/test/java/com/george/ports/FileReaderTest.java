package com.george.ports;

import com.george.domain.InputReader;
import com.george.domain.InputUnreachableException;
import org.junit.Assert;
import org.junit.Test;

public class FileReaderTest  {

    private InputReader reader;

    @Test
    public void shouldReturnAStringWhenReadFromFileProperly(){
        reader  = new FileReader("stopwords.txt");
        String stopWordsSentence = "the a on off ";

        String sentenceFromFile = reader.read();

        Assert.assertEquals(stopWordsSentence, sentenceFromFile);
    }

    @Test(expected = InputUnreachableException.class)
    public void shouldThrowFileNotFoundIfInformedFileDoesNotExist(){
        reader  = new FileReader("invalid.txt");
        reader.read();
    }

}