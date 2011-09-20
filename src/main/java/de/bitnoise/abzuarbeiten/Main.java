package de.bitnoise.abzuarbeiten;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;

import de.bitnoise.abzuarbeiten.model.Aufgabe;
import de.bitnoise.abzuarbeiten.model.Zustand;
import de.bitnoise.abzuarbeiten.state.Configuration;
import de.bitnoise.abzuarbeiten.state.WindowLayout;
import de.bitnoise.abzuarbeiten.ui.MainFrame;

public class Main
{

  /**
   * @param args
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException
  {
    // {
    // Configuration cfg = new Configuration();
    // cfg.getLayout("main1").x = 1;
    // cfg.getLayout("main2").x = 2;
    // XStream xs = new XStream();
    // xs.autodetectAnnotations(true);
    // System.out.println(xs.toXML(cfg));
    // }

    new MainFrame().open(new Application());
  }
}
