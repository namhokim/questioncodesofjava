package com.naver.cafe.javachobostudy.tjdgns5968;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Tokenize {
    public static void main(String[] args) {
        String line = "public static void main(String[] args) {";
        Set<String> tokens = tokenize(line);
        System.out.println(tokens.size());
    }

    private static Set<String> tokenize(String line) {
        final String[] s = line.split(" ");
        return new HashSet<>(Arrays.asList(s));
    }
}
