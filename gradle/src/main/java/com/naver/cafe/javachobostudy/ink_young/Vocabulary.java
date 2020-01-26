package com.naver.cafe.javachobostudy.ink_young;

import java.io.PrintStream;
import java.util.*;

public class Vocabulary {

    private ArrayList<String> vocabularies = new ArrayList<>();

    public void add(String word) {
        vocabularies.add(word);
    }

    public void change(String target, String newWord) {
        vocabularies.remove(target);
        vocabularies.add(newWord);
    }

    public void showTo(PrintStream printStream) {
        Collections.sort(vocabularies);
        for (String s : vocabularies) {
            printStream.println(s);
        }
    }

    public List<String> search(String[] targets) {
        List<String> result = new ArrayList<>();
        for (String vocabulary : vocabularies) {
            for (String target : targets) {
                if (vocabulary.startsWith(target)) {
                    result.add(vocabulary);
                }
            }
        }
        return result;
    }
}
