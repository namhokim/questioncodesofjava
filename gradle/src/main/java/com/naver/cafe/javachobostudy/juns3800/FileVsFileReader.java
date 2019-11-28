package com.naver.cafe.javachobostudy.juns3800;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileVsFileReader {
    public static void main(String[] args) throws FileNotFoundException {
        final String pathname = "/data/some.dat";
        File file = new File(pathname);
        FileReader fileReaderByFile = new FileReader(file);
        FileReader fileReaderByPathname = new FileReader(pathname);
    }
}
