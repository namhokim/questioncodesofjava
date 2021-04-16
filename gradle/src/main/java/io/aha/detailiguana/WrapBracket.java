package io.aha.detailiguana;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class WrapBracket {

    private static final Pattern ONE_WORD_PATTERN = Pattern.compile("\\S+");

    public static String wrapByList(String input) {
        if (input == null) {
            return null;
        }

        List<Group> twoWordGroup = getLastTwoWordGroupByList(input);

        if (twoWordGroup.isEmpty()) {
            return input;
        } else {
            final int firstStart = twoWordGroup.get(0).start;
            final int firstEnd = twoWordGroup.get(0).end;

            switch (twoWordGroup.size()) {
                case 2:
                    final int secondsStart = twoWordGroup.get(1).start;
                    final int secondEnd = twoWordGroup.get(1).end;

                    StringBuilder sb2 = new StringBuilder(input.length() + 4);
                    sb2.append(input, 0, firstStart)
                            .append('[')
                            .append(input, firstStart, firstEnd)
                            .append(']');
                    appendWhiteSpaceCharacters(sb2, input, firstEnd, secondsStart);
                    sb2.append('[')
                            .append(input, secondsStart, secondEnd)
                            .append(']');
                    appendWhiteSpaceCharacters(sb2, input, secondEnd, input.length());
                    return sb2.toString();
                case 1:
                default:
                    StringBuilder sb1 = new StringBuilder(input.length() + 2);
                    sb1.append(input, 0, firstStart)
                            .append('[')
                            .append(input, firstStart, firstEnd)
                            .append(']');
                    appendWhiteSpaceCharacters(sb1, input, firstEnd, input.length());
                    return sb1.toString();
            }
        }
    }

    public static String wrapByQueue(String input) {
        if (input == null) {
            return null;
        }

        Queue<Group> twoWordGroup = getLastTwoWordGroupByQueue(input);

        if (twoWordGroup.isEmpty()) {
            return input;
        } else {
            switch (twoWordGroup.size()) {
                case 2:
                    final Group first = twoWordGroup.poll();
                    final Group second = twoWordGroup.poll();

                    StringBuilder sb2 = new StringBuilder(input.length() + 4);
                    sb2.append(input, 0, first.start)
                            .append('[')
                            .append(input, first.start, first.end)
                            .append(']');
                    appendWhiteSpaceCharacters(sb2, input, first.end, second.start);
                    sb2.append('[')
                            .append(input, second.start, second.end)
                            .append(']');
                    appendWhiteSpaceCharacters(sb2, input, second.end, input.length());
                    return sb2.toString();
                case 1:
                default:
                    final Group onlyOne = twoWordGroup.poll();
                    StringBuilder sb1 = new StringBuilder(input.length() + 2);
                    sb1.append(input, 0, onlyOne.start)
                            .append('[')
                            .append(input, onlyOne.start, onlyOne.end)
                            .append(']');
                    appendWhiteSpaceCharacters(sb1, input, onlyOne.end, input.length());
                    return sb1.toString();
            }
        }
    }

    private static List<Group> getLastTwoWordGroupByList(String input) {
        final Matcher matcher = ONE_WORD_PATTERN.matcher(input);

        List<Group> groups = new ArrayList<>();
        while (matcher.find()) {
            Group group = new Group(matcher.start(), matcher.end());
            groups.add(group);
            if (groups.size() > 2) {    // only within 2 words
                groups.remove(0);
            }
        }

        return groups;
    }

    private static Queue<Group> getLastTwoWordGroupByQueue(CharSequence input) {
        final Matcher matcher = ONE_WORD_PATTERN.matcher(input);

        Queue<Group> groups = new LinkedList<>();
        while (matcher.find()) {
            Group group = new Group(matcher.start(), matcher.end());
            groups.add(group);
            if (groups.size() > 2) {    // only within 2 words
                groups.remove();
            }
        }

        return groups;
    }

    private static void appendWhiteSpaceCharacters(Appendable appendable, CharSequence source, int from, int to) {
        int currentPos = 0;
        try {
            for (int i = from; i < to; i++) {
                currentPos = i;
                char ch = source.charAt(i);
                appendable.append(ch);
            }
        } catch (IOException e) {
            log.error("Exception in appendWhiteSpaceCharacters - current position: {}", currentPos);
        }
    }

    private static class Group {
        int start;
        int end;

        public Group(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
