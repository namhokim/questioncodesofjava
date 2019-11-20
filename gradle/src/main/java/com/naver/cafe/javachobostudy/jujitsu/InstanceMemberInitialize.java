package com.naver.cafe.javachobostudy.jujitsu;

import lombok.Getter;

import javax.tools.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class InstanceMemberInitialize {
    public static final String SAMPLE_CLASS_NAME = "Sample";

    public static void main(String[] args) throws ClassNotFoundException {
        final String sampleCode = "public class " + SAMPLE_CLASS_NAME
                + " { public @Override String toString() { return \"my first sample\"; } }";
        List<StringSource> sources = Collections.singletonList(new StringSource(SAMPLE_CLASS_NAME, sampleCode));

        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        List<ByteArrayClass> outputClasses = new ArrayList<>();
        final JavaFileManager fileManagerForClassFile = getFileManagerForClassFile(compiler, outputClasses);
        final JavaCompiler.CompilationTask task = compiler.getTask(
                null, fileManagerForClassFile, null, null, null, sources);

        Boolean success = task.call();
        if (Boolean.TRUE.equals(success)) {
            loadTest(outputClasses);
        } else {
            System.out.println("Compile failed");
        }
    }

    private static JavaFileManager getFileManagerForClassFile(JavaCompiler compiler, List<ByteArrayClass> classes) {
        StandardJavaFileManager stdFileManager =
                compiler.getStandardFileManager(null, null, null);

        return new ForwardingJavaFileManager<JavaFileManager>(stdFileManager) {
            public JavaFileObject getJavaFileForOutput(Location location,
                                                       String className,
                                                       JavaFileObject.Kind kind,
                                                       FileObject sibling) throws IOException {
                if (kind == JavaFileObject.Kind.CLASS) {
                    ByteArrayClass outfile = new ByteArrayClass(className);
                    classes.add(outfile);
                    return outfile;
                } else {
                    return super.getJavaFileForOutput(location, className, kind, sibling);
                }
            }
        };
    }

    private static void loadTest(List<ByteArrayClass> classes) throws ClassNotFoundException {
        ByteArrayClassLoader loader = new ByteArrayClassLoader(classes);
        Class<?> cl = Class.forName(SAMPLE_CLASS_NAME, true, loader);
        if (cl.getName().equals(SAMPLE_CLASS_NAME)) {
            try {
                Object instance = cl.newInstance();
                System.out.println("toString: " + instance.toString());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("instanceof: false");
        }
    }
}

//class Sample {
//    private int integer;
//}
