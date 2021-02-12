//package com.wordcounter;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.StringTokenizer;
//import java.util.stream.Collectors;
//
//public class TextParser {
//
//    public Long count(String text) {
//        List<String> tokens = this.getTokensWithCollection(text);
//        return Long.valueOf(tokens.size());
//    }
//
//    private List<String> getTokensWithCollection(String str) {
//        return Collections.list(new StringTokenizer(str, " ")).stream()
//                .map(token -> (String) token)
//                .collect(Collectors.toList());
//    }
//}
