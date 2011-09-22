package de.bitnoise.abzuarbeiten.model;

public class StatusClosed implements Status {
	@Override
	public String toString() {
		return "closed";
	}
 

	@Override
	public void appendTo(ComplexLine line) {
		line.append("[X]");
	}
}
