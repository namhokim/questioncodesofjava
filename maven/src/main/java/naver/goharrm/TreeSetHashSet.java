package naver.goharrm;

import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetHashSet {
    public static void main(String[] args) {
        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add("1");
        System.out.println(stringHashSet.size());

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("2");
        System.out.println(treeSet.size());
    }
}
