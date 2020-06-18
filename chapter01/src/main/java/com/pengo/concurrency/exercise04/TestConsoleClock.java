package com.pengo.concurrency.exercise04;

import java.util.concurrent.TimeUnit;

public class TestConsoleClock
{
  public static void main(String[] args)
  {
    ConsoleClock consoleClock = new ConsoleClock();
    Thread thread = new Thread(consoleClock);
    thread.start();
    try
    {
      TimeUnit.SECONDS.sleep(5);
    }
    catch(InterruptedException e)
    {
      e.printStackTrace();
    }
    thread.interrupt();

  }
}
