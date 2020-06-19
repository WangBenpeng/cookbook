package com.pengo.concurrency.exercise05;

import java.util.Date;

public class TestJoin
{
  public static void main(String[] args)
  {
    DataSourceLoader loader = new DataSourceLoader();
    NetworkConnectionsLoader connection = new NetworkConnectionsLoader();
    Thread loaderTr = new Thread(loader, "LoaderThread");
    Thread connectTr = new Thread(connection, "ConnThread");
    loaderTr.start();
    connectTr.start();
    try
    {
      loaderTr.join();
      connectTr.join();
    }
    catch(InterruptedException e)
    {
      e.printStackTrace();
    }
    System.out.printf("Main finished:%s\n", new Date());
  }
}
