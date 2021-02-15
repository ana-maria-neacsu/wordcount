package com.example.util;

import com.example.interfaceExample.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader implements InputReader {
    private String userInput;

    @Override
    public String readLine() {
        System.out.print("Enter text: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            userInput = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }
}
