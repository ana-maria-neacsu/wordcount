package com.erste.wordcount.service.read;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class ReadServiceFromKeyboard implements ReadService {

  private InputStream inputStream;

  public ReadServiceFromKeyboard() {
    this.inputStream = System.in;
  }

  @Override
  public InputStream read() {
    String s = new Scanner(inputStream).nextLine();
    return new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
  }


}
