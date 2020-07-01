package com.pengo.concurrency.exercise02;

public class TestCountDown
{
  public static void main(String[] args)
  {
    VideoConference conference = new VideoConference(10);
    Thread threadConference = new Thread(conference);
    threadConference.start();
    for(int i = 0; i < 10; i++)
    {
      Participant participant = new Participant(conference, "Participant " + i);
      Thread thread = new Thread(participant);
      thread.start();
    }
  }
}
