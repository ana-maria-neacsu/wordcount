package com.george.app;

import com.george.ports.ConsoleInputReader;
import com.george.ports.FileReader;
import com.george.ports.UserInteractor;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Scanner;

public class InputMethodSelectorTest {

    private InputMethodSelector selector;



    @Test
    public void shouldReadFromFileWhenFileReaderIsProvidedAndGenerateCorrectOutput(){
        selector = new InputMethodSelector(new FileReader("mytext.txt"), "a");
        long count = selector.apply();

        Assert.assertEquals(4, count);
    }

    @Test
    @Ignore("this would require a mock lib")
    public void shouldReadFromUserWhenSimpleReaderIsProvidedAndGenerateCorrectOutput(){
        UserInteractor userInteractor = new UserInteractor(new Scanner(System.in));
        //TODO I would mock userInteractor.requestInput()
        selector = new InputMethodSelector(new ConsoleInputReader(userInteractor), "a");
        long count = selector.apply();

        Assert.assertEquals(4, count);

    }

}