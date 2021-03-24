package com.erste.wordcount.service.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadFromFile implements ReadService{

  private final String FILE_PATH=".";

  @Override
  public InputStream read() {

    try {
      FileInputStream fileInputStream=new FileInputStream("stopwords.txt");
      return fileInputStream;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }
}
