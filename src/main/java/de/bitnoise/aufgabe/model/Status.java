package de.bitnoise.aufgabe.model;

public interface Status
{

  class Factory
  {

    public static Status create(String status)
    {
      if (status == null)
      {
        return new StatusOpen();
      }
      status = status.trim();
      if (status.equalsIgnoreCase("x"))
      {
        return new StatusClosed();
      }
      return new StatusOpen();
    }
  }

  void getLine(StringBuilder sb);

}
