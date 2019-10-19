package com.naver.cafe.javachobostudy.fieldshyuk1030;

public class ThrowingException {
    public static void main(String[] args) {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException e) {
            System.out.println("에러: " + e.getMessage());
        } catch (MemoryException e) {
            System.out.println("에러: " + e.getMessage());
        }
    }

    private static void startInstall() throws SpaceException, MemoryException {
        if (!enoughSpace()) {
            throw new SpaceException("공간이 부족합니다.");
        }
        if (!enoughMemeory()) {
            throw new MemoryException("공간이 부족합니다.");
        }
    }

    private static boolean enoughSpace() {
        return false;
    }

    private static boolean enoughMemeory() {
        return true;
    }

    private static void copyFiles() {
    }

    static class SpaceException extends Exception {
        public SpaceException(String msg) {
            super(msg);
        }
    }

    static class MemoryException extends Exception {
        public MemoryException(String msg) {
            super(msg);
        }
    }
}
