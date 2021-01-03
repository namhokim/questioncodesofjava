package com.naver.cafe.thisisjava.cis940320;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Printing {
    public static void main(String[] args) throws IOException {
        Path path= Paths.get("src/sec16_2_4/linedata.txt"); // 파일의 경로 정보를 가지고 있는 Path 객체 생성
        Stream<String> stream;

        // Files.lines() 메소드 이용
        stream= Files.lines(path, Charset.defaultCharset()); // 운영체제의 기본 문자셋
        stream.forEach(System.out::println); // 메소드 참조(s->System.out.println(s)와 동일)
        System.out.println();

        //BufferedReader의 lines() 메소드 이용
        File file= path.toFile();
        FileReader fileReader=new FileReader(file);
        BufferedReader br= new BufferedReader(fileReader);
        stream=br.lines();
        stream.forEach(System.out::println);
    }
}
