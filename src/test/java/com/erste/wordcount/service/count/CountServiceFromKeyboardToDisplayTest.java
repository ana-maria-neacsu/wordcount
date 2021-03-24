package com.erste.wordcount.service.count;

import com.erste.wordcount.service.read.ReadService;
import com.erste.wordcount.service.write.WriteService;
import com.erste.wordcount.service.write.WriteServiceToDisplay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CountServiceFromKeyboardToDisplayTest {

  private ReadService readService;
  private WriteService writeService;
  private CountService countService;


 // @BeforeEach
  public void setup() {

  }

  @Test
  void count_when_givenSampleWithOneSpaceBetweenWords_returnCorrectNumber() {
    getMockReadService("here is a sample String");
    writeService = new WriteServiceToDisplay();
    countService = new CountServiceFromKeyboardToDisplay(readService, writeService);
    Long numberOfTheWords = countService.count();
    Assertions.assertEquals(numberOfTheWords, 5);
  }

  @Test
  void count_when_givenSampleStringWithMoreThanOneSpace_returnCorrectNumber() {
    getMockReadService("here is a sample       String");
    writeService = new WriteServiceToDisplay();
    countService = new CountServiceFromKeyboardToDisplay(readService, writeService);
    Long numberOfTheWords = countService.count();
    Assertions.assertEquals(numberOfTheWords, 5);
  }



  private ReadService getMockReadService(String sampleString) {
    return readService = new ReadService() {
      @Override
      public String read() {
        return sampleString;
      }
    };

  }
}
