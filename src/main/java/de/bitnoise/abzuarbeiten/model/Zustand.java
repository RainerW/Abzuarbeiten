package de.bitnoise.abzuarbeiten.model;

import java.util.ArrayList;
import java.util.List;

public class Zustand
{
  List<ITaskItem> aufgaben;

  public List<ITaskItem> getAufgaben()
  {
    if(aufgaben == null) {
      aufgaben = new ArrayList<ITaskItem>();
    }
    return aufgaben;
  }
}
