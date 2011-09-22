package de.bitnoise.abzuarbeiten.ui;

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
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;

import com.thoughtworks.xstream.XStream;

import de.bitnoise.abzuarbeiten.Application;
import de.bitnoise.abzuarbeiten.model.Aufgabe;
import de.bitnoise.abzuarbeiten.model.Remark;
import de.bitnoise.abzuarbeiten.model.ITaskItem;
import de.bitnoise.abzuarbeiten.model.Status;
import de.bitnoise.abzuarbeiten.model.Zustand;

public class TextInput extends JPanel {

	private Application _app;

	private JTextPane textPane;

	private TextDocument _document;

	public TextInput( ) {
		_app = Application.get();

//		text = new JTextArea(build(app));
		_document = new TextDocument();
		textPane = new JTextPane(_document);

		textPane.addKeyListener(new KeyListener() {
//		text.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				update();
			}

			public void keyPressed(KeyEvent e) {
			}
		});

		setLayout(new BorderLayout());
		add(textPane);
	}

//	private String build(Application z) {
//		if (z == null) {
//			return "";
//		}
//		StringBuilder sb = new StringBuilder();
//		for (ITaskItem aufgabe : z.getAufgaben()) {
//			aufgabe.getLine(sb);
//			sb.append("\n");
//		}
//		return sb.toString();
//	}

	protected void update() {
//		String txt = text.getText();
//		List<ITaskItem> aufgaben = createModel(txt);
//		if (aufgaben != null) {
//			DefaultListModel model = new DefaultListModel();
//			for (ITaskItem aufgabe : aufgaben) {
//				model.addElement(aufgabe);
//			}
//			// liste.setModel(model);
//			write(aufgaben);
//		}
	}

	private void write(List<ITaskItem> aufgaben) {
		_app.setAufgaben(aufgaben);
	}

	
}
