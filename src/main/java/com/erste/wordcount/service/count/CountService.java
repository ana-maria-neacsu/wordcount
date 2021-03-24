package com.erste.wordcount.service.count;

import java.util.List;

public interface CountService {

  long count();

  void setSplitter(String splitterPattern);

  void setAllowedPattern(String allowedPattern);

  List<String> filterNotAllowedWords(String[] inputArray);


}
