package com.pengo.concurrency.exercise05;

public class FileMock
{
  private String[] content;
  private int index;

  /**
   * 随机字符填充文件内容
   * @param size
   * @param length
   */
  public FileMock(int size, int length)
  {
    content = new String[size];
    for(int i = 0; i < size; i++)
    {
      StringBuilder buffer = new StringBuilder(length);
      for(int j = 0; j < length; j++)
      {
        int randomCharacter = (int)(Math.random() * 255);
        buffer.append((char)randomCharacter);
      }
      content[i] = buffer.toString();
    }
    index = 0;
  }

  /**
   * true：表示文件还有继续处理的内容
   * false：表示读到了模拟文件的末尾
   * @return
   */
  public boolean hasMoreLines()
  {
    return index < content.length;
  }

  /**
   * 返回文件对应行数的内容
   * @return
   */
  public String getLine()
  {
    if(hasMoreLines())
    {
      System.out.println("Mock: " + (content.length - index));
      return content[index++];
    }
    return null;
  }

}
