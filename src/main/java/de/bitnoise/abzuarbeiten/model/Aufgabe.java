package de.bitnoise.abzuarbeiten.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Aufgabe")
public class Aufgabe implements ITaskItem
{
  public Status status;

  public String name;

  @Override
  public String toString()
  {
    return (status != null ? status.toString() : "") + " " + name;
  }

  /* (non-Javadoc)
   * @see de.bitnoise.abzuarbeiten.model.ITaskItem#getLine(java.lang.StringBuilder)
   */
  public void getLine(StringBuilder sb)
  {
    if (status == null)
    {
      sb.append("[ ]");
    }
    else
    {
      status.getLine(sb);
    }
    sb.append(" ");

    sb.append(name);

  }
}
