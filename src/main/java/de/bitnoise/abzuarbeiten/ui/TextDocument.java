package de.bitnoise.abzuarbeiten.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import de.bitnoise.abzuarbeiten.Application;
import de.bitnoise.abzuarbeiten.events.IEvent;
import de.bitnoise.abzuarbeiten.events.IListener;
import de.bitnoise.abzuarbeiten.model.Aufgabe;
import de.bitnoise.abzuarbeiten.model.ComplexLine;
import de.bitnoise.abzuarbeiten.model.ComplexLine.Part;
import de.bitnoise.abzuarbeiten.model.ITaskItem;
import de.bitnoise.abzuarbeiten.model.Line;
import de.bitnoise.abzuarbeiten.model.Remark;
import de.bitnoise.abzuarbeiten.model.Status;
import de.bitnoise.abzuarbeiten.model.Style;
import de.bitnoise.abzuarbeiten.model.TextLine;

public class TextDocument extends DefaultStyledDocument implements
		StyledDocument {

	public TextDocument() {
		super();

		Application app = Application.get();
		List<ITaskItem> aufgaben = app.getAufgaben();
		load(aufgaben);

		addDocumentListener(new TrackChanges());

	}

	class TrackChanges implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			reparse(this);
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
		}

	}

	public void reparse(final TrackChanges trackChanges) {
		try {
			removeDocumentListener(trackChanges);
			Content x = getContent();
			String s = x.getString(0, x.length());
			final List<ITaskItem> neu = new CodeHack().createModel(s);
			if (neu != null) {
				Application.get().setAufgaben(neu);
				Runnable reload = new Runnable() {
					public void run() {
						load(neu);
					}
				};
				SwingUtilities.invokeLater(reload);
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		} finally {
			addDocumentListener(trackChanges);
		}
	}

	private void load(List<ITaskItem> aufgaben) {
		if (aufgaben == null) {
			return;
		}
		try {
			getContent().remove(0, getLength());
		} catch (BadLocationException e) {
		}
		int pos = 0;
		for (ITaskItem aufgabe : aufgaben) {
			Line line = aufgabe.getLine();
			if (line instanceof TextLine) {
				append(line.getPlainContent());
				append("\n");
			} else if (line instanceof ComplexLine) {
				ComplexLine cl = (ComplexLine) line;
				for (Part part : cl.getParts()) {
					append(part);
				}
				append("\n");
			}
			pos = getLength();
		}

	}

	private void append(Part part) {
		part.getStyle();
		String text = part.getText();
		AttributeSet attribute = to(part.getStyle());
		append(text, attribute);
	}

	private AttributeSet to(Style style) {
		if (style == null) {
			return SimpleAttributeSet.EMPTY;
		}
		SimpleAttributeSet sa = new SimpleAttributeSet();
		StyleConstants.setStrikeThrough(sa, style.isStrike());
		return sa;
	}

	private void append(String text) {
		append(text, SimpleAttributeSet.EMPTY);
	}

	private void append(String text, AttributeSet attrib) {
		insertStringSafe(getLength(), text, attrib);
	}

	private void insertStringSafe(int off, String text, AttributeSet attrib) {
		try {
			insertString(off, text, attrib);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	class CodeHack {
		private List<ITaskItem> createModel(String txt) {
			if (txt == null) {
				return null;
			}
			String[] lines = txt.split("[\r\n]");
			List<ITaskItem> result = new ArrayList<ITaskItem>();
			for (String line : lines) {
				ITaskItem aufgabe = parse(line);
				if (aufgabe != null) {
					result.add(aufgabe);
				}
			}
			return result;
		}

		Pattern pat_Aufgabe = Pattern.compile("\\[([^\\]]*?)\\]\\s(.*)");

		private ITaskItem parse(String line) {
			Matcher matcher = pat_Aufgabe.matcher(line);
			if (matcher.matches()) {
				return parseAufgabe(matcher);
			}
			return new Remark(line);
		}

		private ITaskItem parseAufgabe(Matcher matcher) {
			String status = matcher.group(1);
			String text = matcher.group(2);
			Aufgabe aufgabe = new Aufgabe();
			aufgabe.status = Status.Factory.create(status);
			aufgabe.name = text;
			return aufgabe;
		}
	}

}
