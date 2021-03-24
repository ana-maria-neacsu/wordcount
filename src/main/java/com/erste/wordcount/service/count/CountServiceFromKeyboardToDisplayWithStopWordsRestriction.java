package com.erste.wordcount.service.count;

import com.erste.wordcount.exception.AllowedPatternNullException;
import com.erste.wordcount.exception.splitterNullException;
import com.erste.wordcount.service.read.ReadService;
import com.erste.wordcount.service.write.WriteService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountServiceFromKeyboardToDisplayWithStopWordsRestriction implements CountService {

  private String splitterRegexPattern = "\\s+";
  private String allowedRegexPattern = "[a-zA-Z]";
  private ReadService readServiceFromKeyboard;
  private WriteService writeServiceToDisplay;


  public CountServiceFromKeyboardToDisplayWithStopWordsRestriction(ReadService readService,
      WriteService writeService) {
    this.readServiceFromKeyboard = readService;
    this.writeServiceToDisplay = writeService;
  }


  @Override
  public List<String> filterNotAllowedWords(String[] inputArray) throws IOException {

    Path path = Paths.get("/home/moal/Desktop/erste/stopwords.txt");
    List<String> strings = Files.readAllLines(path);

    return Arrays.stream(inputArray)
        .filter(s -> !strings.contains(s)).collect(Collectors.toList());

  }

  @Override
  public long count() throws IOException {
    if (allowedRegexPattern == null || allowedRegexPattern.isEmpty()) {
      throw new AllowedPatternNullException();
    }
    if (splitterRegexPattern == null || splitterRegexPattern.isEmpty()) {
      throw new splitterNullException();
    }
    writeWelcomeMessage();
    String[] inputStringArray = ReadService
        .convertInputStreamTOString(readServiceFromKeyboard.read())
        .split(splitterRegexPattern);

    return filterNotAllowedWords(inputStringArray).size();
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
