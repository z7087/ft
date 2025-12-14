package me.z7087;

public class Mag1c {
    public static volatile boolean aBoolean = true;
    public static void main(String[] args) {
        System.out.println("Java version: " + System.getProperty("java.version"));
        //Main.setMessage("1");
        while (aBoolean) {
            String a;
            for (int i = 0; i < 40000000; ++i) {
                a = Main.getMessage();
            }
            int b = 2; // modify this line to notify idea recompile all and hot update
            System.out.println(1); // breakpoint here
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
