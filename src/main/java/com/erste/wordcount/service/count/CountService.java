package com.erste.wordcount.service.count;

public interface CountService {

  long count();

  void setSplitter(String splitterPattern);

  void setAllowedPattern(String allowedPattern);


}
