package de.bitnoise.aufgabe.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import de.bitnoise.aufgabe.Application;
import de.bitnoise.aufgabe.model.Zustand;

public class MainFrame extends JFrame
{

  public void open(Application app)
  {
    getContentPane().setLayout(new BorderLayout());
    JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new TextInput(app), new ListPane(
        app));
    getContentPane().add(pane);
    setMinimumSize(new Dimension(200, 200));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }

}
