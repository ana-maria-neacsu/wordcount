package com.erste.wordcount.service.count;

import com.erste.wordcount.exception.AllowedPatternNullException;
import com.erste.wordcount.exception.splitterNullException;
import com.erste.wordcount.service.read.ReadService;
import com.erste.wordcount.service.write.WriteService;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CountServiceFromKeyboardToDisplay implements CountService {


  private ReadService readServiceFromKeyboard;
  private WriteService writeServiceToDisplay;
  private String allowedRegexPattern = "[a-zA-Z]^[ ?]*[?][ ?]*$";
  private String splitterRegexPattern = "\\s+";


  public CountServiceFromKeyboardToDisplay(ReadService readService,
      WriteService writeService) {
    this.readServiceFromKeyboard = readService;
    this.writeServiceToDisplay = writeService;
  }

  @Override
  public long count() {
    if (allowedRegexPattern == null || allowedRegexPattern.isEmpty()) {
      throw new AllowedPatternNullException();
    }
    if (splitterRegexPattern == null || splitterRegexPattern.isEmpty()) {
      throw new splitterNullException();
    }
    String inputString = readServiceFromKeyboard.read();
    String[] InputStringArray = inputString.split(splitterRegexPattern);

    return Arrays.stream(InputStringArray).count();
  }

  public List<String> filterNotAllowedWords(String[] inputArray) {
    Pattern pattern = Pattern.compile(allowedRegexPattern);
    List<String> matchList = Arrays.stream(inputArray)
        .filter(pattern.asPredicate())

        .collect(Collectors.toList());
    return matchList;
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
