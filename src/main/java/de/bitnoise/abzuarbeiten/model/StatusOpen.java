package de.bitnoise.abzuarbeiten.model;

public class StatusOpen implements Status {
	@Override
	public String toString() {
		return "open";
	}

	@Override
	public void appendTo(ComplexLine line) {
		line.append("[ ]");
	}

}
