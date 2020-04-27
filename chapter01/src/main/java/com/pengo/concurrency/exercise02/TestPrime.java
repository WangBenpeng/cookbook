package com.pengo.concurrency.exercise02;

import java.util.concurrent.TimeUnit;

public class TestPrime {

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try {
//            TimeUnit.SECONDS.sleep(5);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        task.interrupt();
        task.isInterrupted();
        System.out.printf("Main: Status of the Thread: %s\n", task.getState());
        System.out.printf("Main: isInterrupted: %s\n", task.isInterrupted());
        System.out.printf("Main: isAlive: %s\n", task.isAlive());
    }

}
