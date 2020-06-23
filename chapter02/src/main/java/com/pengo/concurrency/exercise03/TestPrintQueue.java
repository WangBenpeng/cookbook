package com.pengo.concurrency.exercise03;

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
    Thread thread[] = new Thread[20];
    for(int i = 0; i < 20; i++)
    {
      thread[i] = new Thread(new Job(printQueue), "Thread " + i);
    }
    for(int i = 0; i < 20; i++)
    {
      thread[i].start();
    }
    for(int i = 0; i < 20; i++)
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
