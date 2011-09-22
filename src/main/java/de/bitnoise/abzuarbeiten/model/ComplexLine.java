package de.bitnoise.abzuarbeiten.model;

import java.util.ArrayList;
import java.util.List;

import de.bitnoise.abzuarbeiten.model.ComplexLine.Part;

public class ComplexLine implements Line {

	private List<Part> _parts = new ArrayList<ComplexLine.Part>();

	@Override
	public String getPlainContent() {
		return "- not supported ";
	}

	public List<Part> getParts() {
		return _parts;
	}

	public static class Part {

		private Style _style = new Style();
		private String _text;

		public Style getStyle() {
			return _style;
		}

		public String getText() {
			return _text;
		}

		public void setText(String text) {
			_text = text;
		}

		public void setBold(boolean bold) {
			_style.setBold(true);
		}

		public void setStrike(boolean b) {
			_style.setStrike(b);
		}
	}

	public Part append(String text) {
		Part part = new Part();
		_parts.add(part);
		part.setText(text);
		return part;
	}

}
