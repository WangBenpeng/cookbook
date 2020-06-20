package com.pengo.concurrency.exercise08;

import java.util.concurrent.TimeUnit;

public class TestMain
{
  public static void main(String[] args)
  {
    SafeTask safeTask = new SafeTask();
    for(int i = 0; i < 10; i++)
    {
      Thread thread = new Thread(safeTask);
      thread.start();
      try
      {
        TimeUnit.SECONDS.sleep(2);
      }
      catch(InterruptedException e)
      {
        e.printStackTrace();
      }
    }

//    UnsafeTask unsafeTask = new UnsafeTask();
//    for(int i = 0; i < 10; i++)
//    {
//      Thread thread = new Thread(unsafeTask);
//      thread.start();
//      try
//      {
//        TimeUnit.SECONDS.sleep(2);
//      }
//      catch(InterruptedException e)
//      {
//        e.printStackTrace();
//      }
//    }
  }
}
