package naver.kuroneko2;

import java.util.function.Function;
import java.util.stream.Stream;

public class InnerStream {
    public static void main(String[] args) {
        Stream<String> str1 = Stream.of("A", "B", "C");
        Stream<String> str2 = Stream.of("a", "b", "c");
        Stream<Stream<String>> strStream = Stream.of(str1, str2);

        strStream.flatMap(Function.identity()).forEach(System.out::println);
    }
}
