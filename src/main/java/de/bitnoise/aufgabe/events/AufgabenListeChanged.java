package de.bitnoise.aufgabe.events;

import java.util.List;

import de.bitnoise.aufgabe.model.Aufgabe;
import de.bitnoise.aufgabe.model.ITaskItem;

public class AufgabenListeChanged implements IEvent
{
  List<ITaskItem> _changed;

  public AufgabenListeChanged(List<ITaskItem> aufgaben)
  {
    _changed = aufgaben;
  }

}
