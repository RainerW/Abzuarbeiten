package de.bitnoise.abzuarbeiten.model;

public class TextLine implements Line {

	private String _content;

	public TextLine(String content) {
		_content = content;
	}

	@Override
	public String getPlainContent() {
		return _content;
	}

}
