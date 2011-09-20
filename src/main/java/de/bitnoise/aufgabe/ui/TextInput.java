package de.bitnoise.aufgabe.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.thoughtworks.xstream.XStream;

import de.bitnoise.aufgabe.Application;
import de.bitnoise.aufgabe.model.Aufgabe;
import de.bitnoise.aufgabe.model.Heading;
import de.bitnoise.aufgabe.model.ITaskItem;
import de.bitnoise.aufgabe.model.Status;
import de.bitnoise.aufgabe.model.Zustand;

public class TextInput extends JPanel
{

  private Application _app;

  private Object z;

  private JTextArea text;

  public TextInput(Application app)
  {
    _app = app;

    text = new JTextArea(build(app));

    Font font = new Font("Verdana", Font.PLAIN, 12);
    text.setFont(font);

    text.addKeyListener(new KeyListener()
    {
      public void keyTyped(KeyEvent e)
      {
      }

      public void keyReleased(KeyEvent e)
      {
        update();
      }

      public void keyPressed(KeyEvent e)
      {
      }
    });

    setLayout(new BorderLayout());
    add(text);
  }

  private String build(Application z)
  {
    if (z == null)
    {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    for (ITaskItem aufgabe : z.getAufgaben())
    {
      aufgabe.getLine(sb);
      sb.append("\n");
    }
    return sb.toString();
  }

  protected void update()
  {
    String txt = text.getText();
    List<ITaskItem> aufgaben = createModel(txt);
    if (aufgaben != null)
    {
      DefaultListModel model = new DefaultListModel();
      for (ITaskItem aufgabe : aufgaben)
      {
        model.addElement(aufgabe);
      }
      // liste.setModel(model);
      write(aufgaben);
    }
  }

  private void write(List<ITaskItem> aufgaben)
  {
    _app.setAufgaben(aufgaben);
  }

  private List<ITaskItem> createModel(String txt)
  {
    if (txt == null)
    {
      return null;
    }
    String[] lines = txt.split("[\r\n]");
    List<ITaskItem> result = new ArrayList<ITaskItem>();
    for (String line : lines)
    {
      ITaskItem aufgabe = parse(line);
      if (aufgabe != null)
      {
        result.add(aufgabe);
      }
    }
    return result;
  }

  Pattern pat_Aufgabe = Pattern.compile("\\[([^\\]]*?)\\]\\s(.*)");

  private ITaskItem parse(String line)
  {
    Matcher matcher = pat_Aufgabe.matcher(line);
    if (matcher.matches())
    {
      return parseAufgabe(matcher);
    }
    return new Heading(line);
  }

  private ITaskItem parseAufgabe(Matcher matcher)
  {
    String status = matcher.group(1);
    String text = matcher.group(2);
    Aufgabe aufgabe = new Aufgabe();
    aufgabe.status = Status.Factory.create(status);
    aufgabe.name = text;
    return aufgabe;
  }
}
