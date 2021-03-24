package com.erste.wordcount;

import com.erste.wordcount.service.count.CountService;
import com.erste.wordcount.service.count.CountServiceFromKeyboardToDisplay;
import com.erste.wordcount.service.read.ReadService;
import com.erste.wordcount.service.read.ReadServiceFromKeyboard;
import com.erste.wordcount.service.write.WriteService;
import com.erste.wordcount.service.write.WriteServiceToDisplay;

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
