package me.z7087;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Java version: " + System.getProperty("java.version"));
        String a;
        for (int i = 0; i < 40000000; ++i) {
            a = Main.getMessage();
        }
        try {
            Object deadLock = new Object();
            //noinspection SynchronizationOnLocalVariableOrMethodParameter
            synchronized (deadLock) {
                deadLock.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
