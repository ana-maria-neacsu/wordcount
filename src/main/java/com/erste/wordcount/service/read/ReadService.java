package com.erste.wordcount.service.read;

import com.erste.wordcount.exception.InputResourceNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public interface ReadService {


  static String convertInputStreamTOString(InputStream inputStream) {
    return new BufferedReader(
        new InputStreamReader(inputStream))
        .lines()
        .collect(Collectors.joining());

  }

  InputStream read() throws InputResourceNotFoundException, IOException;
}
