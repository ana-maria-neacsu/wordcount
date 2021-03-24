package com.erste.wordcount.service.count;

import com.erste.wordcount.service.read.ReadService;
import com.erste.wordcount.service.write.WriteServiceToDisplay;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountServiceFromKeyboardToDisplayWithStopWordsRestrictionTest {


  private ReadService readService;
  private CountService countService;

  @Test
  public void count_when_stringWithStopWords_countCorrectly() throws IOException {
    mockDependencies("this is also a sample string");
    Long countedWords = countService.count();
    Assertions.assertEquals(5,countedWords);
  }


  private void mockDependencies(String sampleString) {

    readService = new ReadService() {
      @Override
      public InputStream read() {
        return new ByteArrayInputStream(sampleString.getBytes(StandardCharsets.UTF_8));
      }
    };
    countService = new CountServiceFromKeyboardToDisplayWithStopWordsRestriction(readService,
        new WriteServiceToDisplay());
  }
}
