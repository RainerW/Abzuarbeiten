package de.bitnoise.abzuarbeiten.model;

public class Style {
	private boolean _bold;

	public boolean isBold() {
		return _bold;
	}

	public boolean isStrike() {
		return _strike;
	}

	private boolean _strike;

	void setBold(boolean b) {
		_bold = b;
	}

	void setStrike(boolean b) {
		_strike = b;
	}
}
