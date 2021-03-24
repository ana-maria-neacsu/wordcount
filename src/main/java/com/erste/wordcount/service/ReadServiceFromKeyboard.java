package com.erste.wordcount.service;

import java.io.InputStream;
import java.util.Scanner;


public class ReadServiceFromKeyboard implements ReadService {

  private Scanner scanner;
  private InputStream inputStream;

  public ReadServiceFromKeyboard() {
    this.inputStream = System.in;
  }

  @Override
  public Scanner read(InputStream in) {
    return null;
  }

  @Override
  public Scanner getInstance() {
    return scanner = new Scanner(inputStream);
  }


}
