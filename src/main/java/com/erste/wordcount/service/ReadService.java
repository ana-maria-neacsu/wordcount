package com.erste.wordcount.service;

import java.io.InputStream;
import java.util.Scanner;

public interface ReadService {


 String read();

 Scanner getInputInstance();

 String getWelcomeMessage();
}
