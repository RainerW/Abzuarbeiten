package de.bitnoise.abzuarbeiten.events;

import java.util.List;

import de.bitnoise.abzuarbeiten.model.Aufgabe;
import de.bitnoise.abzuarbeiten.model.ITaskItem;

public class AufgabenListeChanged implements IEvent
{
  List<ITaskItem> _changed;

  public AufgabenListeChanged(List<ITaskItem> aufgaben)
  {
    _changed = aufgaben;
  }

}
