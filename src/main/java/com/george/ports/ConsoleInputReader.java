package com.george.ports;

import com.george.domain.InputReader;

public class ConsoleInputReader implements InputReader {

    private final UserInteractor userInteractor;

    public ConsoleInputReader(UserInteractor interactor){
        this.userInteractor = interactor;
    }

    @Override
    public String read() {
        return userInteractor.requestInput();
    }
}
