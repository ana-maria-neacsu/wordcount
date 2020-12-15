package com.george.ports;

import java.util.Scanner;

public class UserInteractor {

    private final Scanner scanner;

    public UserInteractor(Scanner scanner) {
        this.scanner = scanner;
    }

    public String requestInput() {
        System.out.print("Enter text: ");
        return scanner.nextLine();
    }
}
