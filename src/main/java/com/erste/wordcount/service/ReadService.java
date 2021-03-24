package com.erste.wordcount.service;

import java.io.InputStream;
import java.util.Scanner;

public interface ReadService {


 Scanner read(InputStream in);

 Scanner getInstance();
}
