package com.erste.wordcount.service.count;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface CountService {

  long count();

  void setSplitter(String splitterPattern);

  void setAllowedPattern(String allowedPattern);

  default List<String> filterNotAllowedWords(String[] inputArray) {
    return Arrays.stream(inputArray)
        .filter(s -> s.chars().allMatch(Character::isLetter)).collect(Collectors.toList());
  }

  ;


}
