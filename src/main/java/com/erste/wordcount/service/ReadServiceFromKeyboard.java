package com.erste.wordcount.service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class ReadServiceFromKeyboard implements ReadService {


  private final String WELCOME_MESSAGE = "Enter text: ";
  String inputString = "";
  private InputStream inputStream;

  public ReadServiceFromKeyboard() {
    this.inputStream = System.in;
  }

  @Override
  public String read() {
    return inputString = getInputInstance().next();
  }

  @Override
  public String getWelcomeMessage() {
    return WELCOME_MESSAGE;
  }

  @Override
  public Scanner getInputInstance() {
    return new Scanner(inputStream);
  }


  public String getInputString() {
    return inputString;
  }


}
