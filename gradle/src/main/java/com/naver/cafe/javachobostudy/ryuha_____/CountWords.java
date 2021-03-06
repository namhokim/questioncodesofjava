package com.naver.cafe.javachobostudy.ryuha_____;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountWords {

    private static final String TOKENIZE_REGEX = " +|`|'|\"|-|_|\\(|\\)|:|\\.|,|!|;|\\?";

    public static void main(String[] args) throws IOException {
        final String fileName = "/Users/namo/Desktop/alice_in_wonderland.txt";
        final File file = new File(fileName);
        final Path path = file.toPath();
        Stream<String> lines = Files.lines(path);
        Stream<String> words = lines.flatMap(line -> Stream.of(line.split(TOKENIZE_REGEX)));
        Map<String, Long> counted = words
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(entriesSortedByValues(counted));
    }

    private static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        List<Map.Entry<K, V>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        return sortedEntries;
    }
}
