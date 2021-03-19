package wordcount.input;

import wordcount.contract.input.InputReader;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {
    @Override
    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
