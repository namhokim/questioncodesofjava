package com.naver.cafe.javachobostudy.jujitsu;

import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URI;

public class ByteArrayClass extends SimpleJavaFileObject {
    private ByteArrayOutputStream out;

    private ByteArrayClass(URI uri, Kind kind) {
        super(uri, kind);
    }

    ByteArrayClass(String name) {
        this(URI.create("bytes:///" + name.replace('.', '/') + ".class"), Kind.CLASS);
    }

    byte[] getCode() {
        return out.toByteArray();
    }

    public OutputStream openOutputStream() {
        out = new ByteArrayOutputStream();
        return out;
    }
}
