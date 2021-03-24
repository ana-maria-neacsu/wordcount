package com.erste.wordcount.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountServiceFromKeyboardToDisplay implements CountService {


  private ReadService readService;
  private WriteService writeService;

  public CountServiceFromKeyboardToDisplay(ReadService readService,
      WriteService writeService) {
    this.readService = readService;
    this.writeService = writeService;
  }

  @Override
  public int count() {

    return 0;
  }
}
