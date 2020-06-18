package com.pengo.concurrency.exercise03;

import java.util.concurrent.TimeUnit;

public class TestFileSearch {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FileSearch fileSearch = new FileSearch("c:\\windows", "explorer.exe");
        Thread thread = new Thread(fileSearch);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
