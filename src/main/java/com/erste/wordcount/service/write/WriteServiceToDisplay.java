package com.erste.wordcount.service.write;

import java.io.PrintStream;

public class WriteServiceToDisplay implements WriteService {

  private PrintStream outputStream;

  public WriteServiceToDisplay() {
    this.outputStream = System.out;
  }

  @Override
  public void write(String s) {
    outputStream.println(s);
  }
}
