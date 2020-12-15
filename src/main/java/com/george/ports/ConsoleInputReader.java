package com.george.ports;

import com.george.domain.InputReader;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

    @Override
    public String read() {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}
