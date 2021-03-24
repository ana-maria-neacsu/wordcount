package com.erste.wordcount.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class ReadServiceFromKeyboard implements ReadService {


  private InputStream inputStream;

  private OutputStream outputStream;

  public ReadServiceFromKeyboard() {
    this.inputStream = System.in;
  }

  @Override
  public Scanner read(InputStream in) {
    System.out.println();

    return null;
  }

  @Override
  public Scanner getInstance() {
    return new Scanner(inputStream);
  }


}
