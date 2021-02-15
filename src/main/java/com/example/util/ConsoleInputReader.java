package com.example.util;

import com.example.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader implements InputReader {

    @Override
    public String readLine() {
        System.out.print("Enter text: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";
        try {
            userInput = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }
}
