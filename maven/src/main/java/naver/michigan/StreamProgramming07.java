package naver.michigan;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class StreamProgramming07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("파일 이름을 입력하세요: ");
        String fileName = in.nextLine();
        System.out.print("세고자 하는 문자를 입력하세요 :");
        char lookfor = in.nextLine().charAt(0);

        int count = new CountLetter(lookfor, fileName).count();
        System.out.format("%s 파일에 %c 문자가 %d개 %n", fileName, lookfor, count);
    }
}

class CountLetter {

    private char lookFor;
    private String fileName;

    CountLetter(char lookFor, String fileName) {
        this.lookFor = lookFor;
        this.fileName = fileName;
    }

    int count() {
        final Path path = Path.of(fileName);
        if (!Files.exists(path)) {
            System.err.println("No file: " + fileName);
        }

        Charset charset = Charset.defaultCharset();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        long totalCount = 0;
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
            int byteCount;

            while (true) {
                byteCount = fileChannel.read(byteBuffer);

                if (byteCount == -1) {
                    break;
                }

                byteBuffer.flip();
                long count = charset.decode(byteBuffer).chars()
                        .filter(c -> c == lookFor)
                        .count();
                byteBuffer.clear();
                totalCount += count;
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return (int)totalCount;
    }
}