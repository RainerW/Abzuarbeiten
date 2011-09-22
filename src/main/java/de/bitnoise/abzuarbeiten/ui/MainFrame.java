package de.bitnoise.abzuarbeiten.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import de.bitnoise.abzuarbeiten.Application;
import de.bitnoise.abzuarbeiten.model.Zustand;

public class MainFrame extends JFrame {

	public void open() {
		getContentPane().setLayout(new BorderLayout());
		JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				new TextInput(), new ListPane());
		getContentPane().add(pane);
		setMinimumSize(new Dimension(200, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setTitle("Abzuarbeiten");
		setVisible(true);
	}

}
