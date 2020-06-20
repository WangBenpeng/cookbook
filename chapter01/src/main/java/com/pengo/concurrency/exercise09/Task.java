package com.pengo.concurrency.exercise09;

import java.util.Random;

public class Task implements Runnable
{
  @Override
  public void run()
  {
    int result;
    Random random = new Random(Thread.currentThread().getId());
    while(true)
    {
      result = 1000 / (int)(random.nextDouble() * 100000000);
      if(Thread.currentThread().isInterrupted())
      {
        System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
        return;
      }
    }
  }
}
