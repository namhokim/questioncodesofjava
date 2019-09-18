package com.example.springboot.sandbox.naver.wnckszzz;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum StaticInitializationBlock {
    FIELD_INITIALIZATION("field"),
    CONSTRUCTOR_INITIALIZATION("construcor"),
    DUMMY1("construcor1"),
    DUMMY2("construcor2"),
    DUMMY3("construcor3"),
    DUMMY4("construcor4"),
    DUMMY5("construcor5"),
    DUMMY6("construcor6"),
    DUMMY7("construcor7"),
    DUMMY8("construcor8"),
    DUMMY9("construcor9"),
    DUMMY10("construcor10"),
    DUMMY11("construcor11"),
    DUMMY12("construcor12"),
    DUMMY13("construcor13"),
    DUMMY14("construcor14"),
    DUMMY15("construcor15"),
    DUMMY16("construcor16"),
    DUMMY17("construcor17"),
    DUMMY18("construcor18"),
    DUMMY19("construcor19"),
    DUMMY20("construcor20"),
    DUMMY21("construcor21"),
    DUMMY22("construcor22"),
    DUMMY23("construcor23"),
    DUMMY24("construcor24"),
    DUMMY25("construcor25"),
    DUMMY26("construcor26"),
    DUMMY27("construcor27"),
    INITIALIZATION_BLOCK("block");

    @Getter
    private String location;

    StaticInitializationBlock(String location) {
        this.location = location;
    }

    public static StaticInitializationBlock findByLocation(String location) {
        for (StaticInitializationBlock block : StaticInitializationBlock.values()) {
            if (block.location.equals(location)) {
                return block;
            }
        }
        return null;
    }

    private static final Map<String, StaticInitializationBlock> findMap = new HashMap<>();
    static {
        for (StaticInitializationBlock block : StaticInitializationBlock.values()) {
            findMap.put(block.location, block);
        }
    }

    public static StaticInitializationBlock findByLocation2(String location) {
        return findMap.get(location);
    }
}
