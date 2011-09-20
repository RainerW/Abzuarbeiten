package de.bitnoise.abzuarbeiten.model;

public class StatusClosed implements Status
{
  @Override
  public String toString()
  {
    return "closed";
  }

  public void getLine(StringBuilder sb)
  {
    sb.append("[x]");
  }
}
