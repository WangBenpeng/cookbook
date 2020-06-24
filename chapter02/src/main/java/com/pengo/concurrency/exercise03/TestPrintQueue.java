package com.pengo.concurrency.exercise03;

import java.util.concurrent.TimeUnit;

public class TestPrintQueue
{
  public static void main(String[] args)
  {
    System.out.printf("Running example with fair-mode=false\n");
    testPrintQueue(false);
    System.out.println("-------------------------------------");
    System.out.printf("Running example with fair-mode=true\n");
    testPrintQueue(true);

  }

  private static void testPrintQueue(Boolean fairMode)
  {
    PrintQueue printQueue = new PrintQueue(fairMode);
    Thread thread[] = new Thread[10];
    for(int i = 0; i < 10; i++)
    {
      thread[i] = new Thread(new Job(printQueue), "Thread " + i);
    }
    for(int i = 0; i < 10; i++)
    {
      thread[i].start();
      try
      {
        TimeUnit.MILLISECONDS.sleep(100);
      }
      catch(InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    for(int i = 0; i < 10; i++)
    {
      try
      {
        thread[i].join();
      }
      catch(InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
