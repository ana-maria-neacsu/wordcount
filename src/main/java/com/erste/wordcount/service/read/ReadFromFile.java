package com.erste.wordcount.service.read;

import com.erste.wordcount.exception.InputResourceNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadFromFile implements ReadService {


  private String filePath;
  private FileInputStream fileInputStream;

  @Override
  public InputStream read() throws InputResourceNotFoundException, IOException {

    try {
      fileInputStream = new FileInputStream(getFilePath());
      return fileInputStream;

    } catch (FileNotFoundException e) {
      throw new InputResourceNotFoundException();
    }


  }

  void closeTheStream() throws IOException {
    fileInputStream.close();
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }
}
