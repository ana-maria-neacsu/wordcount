package com.erste.wordcount;

import com.erste.wordcount.service.CountService;
import com.erste.wordcount.service.CountServiceFromKeyboardToDisplay;
import com.erste.wordcount.service.ReadService;
import com.erste.wordcount.service.ReadServiceFromKeyboard;
import com.erste.wordcount.service.WriteService;
import com.erste.wordcount.service.WriteServiceToDisplay;

public class Main {

  public static void main(String[] args) {

    ReadService rs= new ReadServiceFromKeyboard();
    rs.read();
    WriteService ws=new WriteServiceToDisplay();
    ws.write("test");

    CountService cs=new CountServiceFromKeyboardToDisplay(rs,ws);
    cs.count();
  }
}
