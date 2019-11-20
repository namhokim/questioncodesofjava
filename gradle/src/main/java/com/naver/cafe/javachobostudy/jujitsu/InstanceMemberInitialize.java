package com.naver.cafe.javachobostudy.jujitsu;

import lombok.Getter;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.util.Collections;
import java.util.List;

@Getter
public class InstanceMemberInitialize {
    private int integer;

    public static void main(String[] args) {
        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        String sampleCode = "class Sample { private int integer; }";
        List<StringSource> sources = Collections.singletonList(new StringSource("Sample", sampleCode));
        final JavaCompiler.CompilationTask task = compiler.getTask(
                null, null, null, null, null, sources);

        Boolean success = task.call();
        System.out.println("Compile result: " + success);
    }
}

//class Sample {
//    private int integer;
//}
