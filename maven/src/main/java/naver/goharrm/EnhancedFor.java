package naver.goharrm;

import java.util.List;

public class EnhancedFor {
    public static void main(String[] args) {
        EnhancedFor[] ef = new EnhancedFor[4];
        ef[0] = new EnhancedFor();
        ef[1] = new EnhancedFor();
        ef[2] = new EnhancedFor();
        ef[3] = new EnhancedFor();
        System.err.println("print");

        for (EnhancedFor elem : ef) {
            System.out.println(elem);
        }

        for (int i = 0; i < ef.length; i++) {
            System.err.println(ef[i]);
        }

        List<String> strings = List.of("1", "2");
        for (String str : strings) {
            System.out.println(str);
        }


    }
}
