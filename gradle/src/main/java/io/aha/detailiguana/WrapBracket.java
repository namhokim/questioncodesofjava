package io.aha.detailiguana;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WrapBracket {

    private static final Pattern ONE_WORD_PATTERN = Pattern.compile("\\S+");

    public static void main(String[] args) {
        String original = "나는 오늘도 회사에 가야 한다. ";
        System.out.println(wrap(original));
    }

    public static String wrap(String input) {
        if (input == null) {
            return null;
        }

        List<Group> twoWordGroup = getLastTwoWordGroup(input);

        if (twoWordGroup.isEmpty()) {
            return input;
        } else {
            switch (twoWordGroup.size()) {
                case 2:
                    StringBuilder sb2 = new StringBuilder(input.length());
                    sb2.append(input, 0, twoWordGroup.get(0).start);
                    sb2.append('[');
                    sb2.append(input, twoWordGroup.get(0).start, twoWordGroup.get(0).end);
                    sb2.append(']');
                    for (int i = twoWordGroup.get(0).end; i < twoWordGroup.get(1).start; i++) {
                        sb2.append(input.charAt(i));
                    }
                    sb2.append('[');
                    sb2.append(input, twoWordGroup.get(1).start, twoWordGroup.get(1).end);
                    sb2.append(']');
                    for (int i = twoWordGroup.get(1).end; i < input.length(); i++) {
                        sb2.append(input.charAt(i));
                    }
                    return sb2.toString();
                case 1:
                default:
                    StringBuilder sb1 = new StringBuilder(input.length());
                    sb1.append(input, 0, twoWordGroup.get(0).start);
                    sb1.append('[');
                    sb1.append(input, twoWordGroup.get(0).start, twoWordGroup.get(0).end);
                    sb1.append(']');
                    for (int i = twoWordGroup.get(0).end; i < input.length(); i++) {
                        sb1.append(input.charAt(i));
                    }
                    return sb1.toString();
            }
        }
    }

    private static List<Group> getLastTwoWordGroup(String input) {
        final Matcher matcher = ONE_WORD_PATTERN.matcher(input);

        List<Group> groups = new ArrayList<>();
        while (matcher.find()) {
            Group group = new Group(matcher.start(), matcher.end());
            groups.add(group);
        }

        while (groups.size() > 2) { // only within 2 words
            groups.remove(0);
        }

        return groups;
    }

    static class Group {
        int start;
        int end;

        public Group(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
