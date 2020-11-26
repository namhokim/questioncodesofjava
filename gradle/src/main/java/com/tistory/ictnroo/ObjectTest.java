package com.tistory.ictnroo;

import java.util.ArrayList;
import java.util.List;

public class ObjectTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        String str = (String) list.get(0);

        System.out.println(str);
    }
}
/*
public class com/tistory/ictnroo/ObjectTest {

  // compiled from: ObjectTest.java

  // access flags 0x1
  public <init>()V
   L0
    LINENUMBER 6 L0
    ALOAD 0
    INVOKESPECIAL java/lang/Object.<init> ()V
    RETURN
   L1
    LOCALVARIABLE this Lcom/tistory/ictnroo/ObjectTest; L0 L1 0
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x9
  public static main([Ljava/lang/String;)V
   L0
    LINENUMBER 8 L0
    NEW java/util/ArrayList
    DUP
    INVOKESPECIAL java/util/ArrayList.<init> ()V
    ASTORE 1
   L1
    LINENUMBER 9 L1
    ALOAD 1
    LDC "hello"
    INVOKEINTERFACE java/util/List.add (Ljava/lang/Object;)Z (itf)
    POP
   L2
    LINENUMBER 10 L2
    ALOAD 1
    ICONST_0
    INVOKEINTERFACE java/util/List.get (I)Ljava/lang/Object; (itf)
    CHECKCAST java/lang/String
    ASTORE 2
   L3
    LINENUMBER 12 L3
    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
    ALOAD 2
    INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
   L4
    LINENUMBER 13 L4
    RETURN
   L5
    LOCALVARIABLE args [Ljava/lang/String; L0 L5 0
    LOCALVARIABLE list Ljava/util/List; L1 L5 1
    LOCALVARIABLE str Ljava/lang/String; L3 L5 2
    MAXSTACK = 2
    MAXLOCALS = 3
}
 */
