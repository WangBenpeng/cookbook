package com.pengo.concurrency.exercise03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue
{
  private Lock queueLock;

  public PrintQueue(boolean fairMode)
  {
    queueLock = new ReentrantLock(fairMode);
  }

  public void printJob(Object document)
  {
    queueLock.lock();
    try
    {
      Long duration = (long)(Math.random() * 10000);
      System.out.printf(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during " + (duration / 1000) + " seconds\n");
      Thread.sleep(duration);
    }
    catch(InterruptedException e)
    {
      e.printStackTrace();
    }finally
    {
      queueLock.unlock();
    }
  }
}
