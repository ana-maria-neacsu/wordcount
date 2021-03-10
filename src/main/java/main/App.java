package main;

import service.WordCountService;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(new WordCountService().countWords(text));
    }
}
