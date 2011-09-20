package de.bitnoise.abzuarbeiten.ui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

import de.bitnoise.abzuarbeiten.Application;
import de.bitnoise.abzuarbeiten.events.AufgabenListeChanged;
import de.bitnoise.abzuarbeiten.events.IEvent;
import de.bitnoise.abzuarbeiten.events.IListener;
import de.bitnoise.abzuarbeiten.model.ITaskItem;

public class ListPane extends JPanel implements IListener
{

  private DefaultListModel liste = new DefaultListModel();

  private Application _app;

  public ListPane(Application app)
  {
    setLayout(new BorderLayout());

    JList list = new JList(liste);
    add(list);

    _app = app;
    _app.addAufgabenChangeListener(this);
    updateList();
  }

  public void event(IEvent event)
  {
    if (event instanceof AufgabenListeChanged)
    {
      updateList();
    }
  }

  void updateList()
  {
    liste.removeAllElements();
    for (ITaskItem aufg : _app.getAufgaben())
    {
      liste.addElement(aufg);
    }
  }

}
