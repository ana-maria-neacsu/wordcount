package com.erste.wordcount.service;

public class CountServiceFromKeyboardToDisplay implements CountService {


  private ReadService readService;
  private WriteService writeService;

  public CountServiceFromKeyboardToDisplay(ReadService readService,
      WriteService writeService) {
    this.readService = readService;
    this.writeService = writeService;
  }

  String count(){

    return null;
  }
}
