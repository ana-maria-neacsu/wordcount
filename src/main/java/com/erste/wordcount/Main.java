package com.erste.wordcount;

import com.erste.wordcount.service.count.CountService;
import com.erste.wordcount.service.count.CountServiceFromKeyboardToDisplay;
import com.erste.wordcount.service.count.CountServiceFromKeyboardToDisplayWithStopWordsRestriction;
import com.erste.wordcount.service.read.ReadService;
import com.erste.wordcount.service.read.ReadServiceFromKeyboard;
import com.erste.wordcount.service.write.WriteService;
import com.erste.wordcount.service.write.WriteServiceToDisplay;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    ReadService readService = new ReadServiceFromKeyboard();
    WriteService writeService = new WriteServiceToDisplay();
    CountService countService = new CountServiceFromKeyboardToDisplayWithStopWordsRestriction(readService, writeService);
    Long countedWords = countService.count();
    System.out.println(countedWords);


  }
}
