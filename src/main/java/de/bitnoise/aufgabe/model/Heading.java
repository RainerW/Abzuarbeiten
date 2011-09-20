package de.bitnoise.aufgabe.model;

public class Heading implements ITaskItem
{
  String heading;

  public Heading(String line)
  {
    heading = line;
  }

  public void getLine(StringBuilder sb)
  {
    sb.append(heading);
  }

  @Override
  public String toString()
  {
    return heading;
  }
}
