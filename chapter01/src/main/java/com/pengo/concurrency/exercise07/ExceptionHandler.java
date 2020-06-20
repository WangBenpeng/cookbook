package com.pengo.concurrency.exercise07;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler
{
  @Override
  public void uncaughtException(Thread t, Throwable e)
  {
    System.out.printf("An Exception has been caught\n");
    System.out.printf("Thread:%s\n",t.getId());
    System.out.printf("Exception:%s:%s\n", e.getClass().getName(), e.getMessage());
    System.out.printf("Stack Trace: \n");
    e.printStackTrace(System.out);
    System.out.printf("Thread status:%s\n", t.getState());
  }
}
