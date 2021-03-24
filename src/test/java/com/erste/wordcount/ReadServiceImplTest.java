package com.erste.wordcount;

import com.erste.wordcount.service.ReadService;
import com.erste.wordcount.service.ReadServiceFromKeyboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReadServiceImplTest {

  private ReadService readService;

  @BeforeEach
  public void setup(){
  readService =new ReadServiceFromKeyboard();
  }

  @Test
  public void getInstance_when_callInstance_instanceNotNull() {
    Assertions.assertNotNull(readService.getInstance());
  }

}
