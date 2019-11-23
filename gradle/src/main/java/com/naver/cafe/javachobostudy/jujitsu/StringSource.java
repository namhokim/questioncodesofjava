package com.naver.cafe.javachobostudy.jujitsu;

import javax.tools.SimpleJavaFileObject;
import java.net.URI;

public class StringSource extends SimpleJavaFileObject {
    private String code;

    private StringSource(URI uri, Kind kind) {
        super(uri, kind);
    }

    public StringSource(String name, String code) {
        this(URI.create("string:///" + name.replace('.', '/') + ".java"), Kind.SOURCE);
        this.code = code;
    }

    public CharSequence getCharContent(boolean ignoreEncodingErros) {
        return code;
    }
}
