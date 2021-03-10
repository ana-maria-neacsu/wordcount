package io;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader{
    @Override
    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
