package com.pengo.concurrency.thread;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestCalculator {
    public static void main(String[] args) {
        System.out.printf("Minimum Priority:%s\n",Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority:%s\n",Thread.NORM_PRIORITY);
        System.out.printf("Maximum Priority:%s\n",Thread.MAX_PRIORITY);

        Thread threads[];
        Thread.State states[];
        threads = new Thread[10];
        states = new Thread.State[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator());
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("MyThread[" + i + "]===>");
        }

        try (FileWriter file = new FileWriter(".\\data\\log.txt"); PrintWriter pw = new PrintWriter(file);) {

            for (int i = 0; i < 10; i++) {
                pw.println("Main : Status of Thread " + i + ":" + threads[i].getState());
                states[i] = threads[i].getState();
            }
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
