package com.erste.wordcount.service.read;

import java.io.InputStream;
import java.util.Scanner;


public class ReadServiceFromKeyboard implements ReadService {

  private InputStream inputStream;

  public ReadServiceFromKeyboard() {
    this.inputStream = System.in;
  }

  @Override
  public String read() {
    return new Scanner(inputStream).nextLine();
  }


}
