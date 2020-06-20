package com.pengo.concurrency.exercise07;

public class TestException
{
  public static void main(String[] args)
  {
    Task task = new Task();
    Thread thread = new Thread(task);
    thread.setUncaughtExceptionHandler(new ExceptionHandler());

    thread.start();
  }
}
