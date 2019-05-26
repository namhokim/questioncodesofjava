import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class QuizOfJongHyeon {
    private static final char CHARACTER_SPACE = ' ';
    private static int count = 0;

    public static void main(String[] args) {
        String xxx = "thank you very much Tschüß.";
        xxx = reform(xxx);
        System.out.println(xxx);
    }

    private static String reform(String original) {
        if (isBlank(original)) {
            return original;
        }
        return original.codePoints()
                .map(QuizOfJongHyeon::flip)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static boolean isBlank(final String original) {
        return original == null || original.isEmpty();
    }

    private static int flip(int codePage) {
        if (codePage == CHARACTER_SPACE) {
            return codePage;
        }

        if (count-- % 2 == 0) {
            return Character.toUpperCase(codePage);
        } else {
            return Character.toLowerCase(codePage);
        }
    }
}
