package com.erste.wordcount.service.count;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface CountService {

  long count() throws IOException;

  void setSplitter(String splitterPattern);

  void setAllowedPattern(String allowedPattern);

  default List<String> filterNotAllowedWords(String[] inputArray) throws IOException {
    return filterNotCharacters(inputArray);
  };

  static List<String> filterNotCharacters(String[] inputArray) {
    return Arrays.stream(inputArray)
        .filter(s -> s.chars().allMatch(Character::isLetter)).collect(Collectors.toList());
  };
  default void writeWelcomeMessage(){
    System.out.println("Enter text: ");
  }
}
