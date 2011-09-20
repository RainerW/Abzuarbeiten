package de.bitnoise.aufgabe.model;

public class StatusOpen implements Status
{
  @Override
  public String toString()
  {
    return "open";
  }

  public void getLine(StringBuilder sb)
  {
    sb.append("[ ]");
  }
}
