package com.pengo.concurrency.exercise05;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceLoader implements Runnable
{
  @Override
  public void run()
  {
    System.out.printf("Beginning DataSourceLoader:%s\n", new Date());
    try
    {
      TimeUnit.SECONDS.sleep(4);
    }
    catch(InterruptedException e)
    {
      e.printStackTrace();
    }
    System.out.printf("Finishing DataSourceLoader:%s\n", new Date());
  }
}
