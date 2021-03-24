package com.erste.wordcount.service.count;

import java.util.List;

public class CountServiceFromKeyboardToDisplayWithStopWordsRestriction implements CountService {

  private String splitterRegexPattern = "\\s+";
  private String allowedRegexPattern = "[a-zA-Z]";

  @Override
  public List<String> filterNotAllowedWords(String[] inputArray) {

    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void setSplitter(String splitterPattern) {
    splitterRegexPattern = splitterPattern;
  }

  @Override
  public void setAllowedPattern(String allowedPattern) {
    allowedRegexPattern = allowedPattern;
  }
}
