package com.naver.cafe.javachobostudy.tokii1212;

import com.naver.cafe.javachobostudy.jujitsu.StringSource;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JavaCompilerTest {

    public static void main(String[] args) throws IOException {
        final String className = "A";
        String sampleCode = "public class " + className +
                " { public static void main(String args[]){ static int a = 10; } }";

        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        try (StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null)) {
            List<StringSource> sources = Collections.singletonList(new StringSource(className, sampleCode));
            final JavaCompiler.CompilationTask task = compiler.getTask(
                    null, fileManager, null, null, null, sources);
            Boolean success = task.call();
            if (Boolean.TRUE.equals(success)) {
                System.out.println("Compile success");
            }
        }
    }
}
