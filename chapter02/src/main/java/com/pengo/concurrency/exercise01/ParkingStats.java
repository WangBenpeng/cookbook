package com.pengo.concurrency.exercise01;

import lombok.Data;

@Data
public class ParkingStats
{
  private long numberCars;
  private long numberMotorcycles;
  private ParkingCash cash;
  private final Object controlCars,controlMotorcycles;

  public ParkingStats(ParkingCash cash)
  {
    this.numberCars = 0;
    this.numberMotorcycles = 0;
    controlCars = new Object();
    controlMotorcycles = new Object();
    this.cash = cash;
  }

  public void carComeIn()
  {
    synchronized(controlCars)
    {
      numberCars++;
    }
  }

  public void carGoOut()
  {
    synchronized(controlCars)
    {
      numberCars--;
    }
    cash.vehiclePay();
  }

  public void motoComeIn()
  {
    synchronized(controlMotorcycles)
    {
      numberMotorcycles++;
    }
  }

  public void motoGoOut()
  {
    synchronized(controlMotorcycles)
    {
      numberMotorcycles--;
    }
    cash.vehiclePay();
  }
}
