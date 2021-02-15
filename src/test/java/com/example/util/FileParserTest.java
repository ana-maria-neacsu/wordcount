package com.example.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileParserTest {

    @Test
    public void testParseListIncorrectPath() {
        FileParser fp = new FileParser(Paths.get("invalidpath/file.txt"));
        List<String> list = fp.parseList();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testParseListEmptyFile() {
        FileParser fp = new FileParser(Paths.get("src/test/resources/emptyfile.txt"));
        List<String> list = fp.parseList();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testParseListValidFileLongList() {
        List<String> testList = Arrays.asList("the", "a", "on", "off");
        FileParser fp = new FileParser(Paths.get("src/test/resources/stopwords.txt"));
        List<String> list = fp.parseList();
        Assertions.assertEquals(testList, list);
    }


}
