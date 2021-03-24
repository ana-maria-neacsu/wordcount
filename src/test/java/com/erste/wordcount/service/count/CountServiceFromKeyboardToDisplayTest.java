package com.erste.wordcount.service.count;

import com.erste.wordcount.service.read.ReadService;
import com.erste.wordcount.service.write.WriteServiceToDisplay;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountServiceFromKeyboardToDisplayTest {

  private ReadService readService;
  private CountService countService;


  @Test
  void count_when_givenSampleWithOneSpaceBetweenWords_returnCorrectNumber() throws Exception {
    mockDependencies("here is a sample String");
    Long numberOfTheWords = countService.count();
    Assertions.assertEquals(numberOfTheWords, 5);
  }

  @Test
  void count_when_givenSampleStringWithMoreThanOneSpace_returnCorrectNumber() throws Exception {
    mockDependencies("here is a sample       String");
    Long numberOfTheWords = countService.count();
    Assertions.assertEquals(numberOfTheWords, 5);
  }

  @Test
  void count_when_givenSampleStringHasNotAllowedChars_returnCorrectNumber() throws Exception {
    mockDependencies("here ! ? is && a sampleString");
    Long numberOfTheWords = countService.count();
    Assertions.assertEquals(4, numberOfTheWords);
  }

  @Test
  public void filterNotAllowedWords_when_giveStringWithNotAllowedChars_returnFilteredArray()
      throws Exception {
    mockDependencies("just to instantiate");
    String[] sampleArray = {"correctString", "!!!", " stop!", "AnotherCorrectString"};
    List<String> strings = countService.filterNotAllowedWords(sampleArray);
    Assertions.assertEquals(2, strings.size());
  }

  private void mockDependencies(String sampleString) {

    readService = new ReadService() {
      @Override
      public InputStream read() {
        return new ByteArrayInputStream(sampleString.getBytes(StandardCharsets.UTF_8));
      }
    };
    countService = new CountServiceFromKeyboardToDisplay(readService, new WriteServiceToDisplay());
  }
}
