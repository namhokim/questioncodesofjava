package com.naver.cafe.javachobostudy.sa_nan;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class JavacCompile {
    public static void main(String[] args) throws Exception {
        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        final StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        final Iterable<? extends JavaFileObject> sources = fileManager.getJavaFileObjects("/Users/namo/Hello.java");

        final JavaCompiler.CompilationTask task = compiler.getTask(
                null, null, null, null, null, sources);

        Boolean success = task.call();
        System.out.println("Compile result: " + success);
    }
}

// Hello.java
class Hello {
    public static void main(String[] args) {
        System.out.println("hello compiler.");
    }
}
