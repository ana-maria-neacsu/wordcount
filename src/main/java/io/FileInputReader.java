package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileInputReader implements InputReader{

    private String path;

    public FileInputReader(String path){
        this.path = path;
    }

    @Override
    public String readInput() {
        try {
            return Files.lines(Paths.get(path)).collect(Collectors.joining(""));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error reading file");
        }
        return "";
    }
}
