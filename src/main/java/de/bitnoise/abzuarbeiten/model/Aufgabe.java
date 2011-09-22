package de.bitnoise.abzuarbeiten.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import de.bitnoise.abzuarbeiten.model.ComplexLine.Part;

@XStreamAlias("Aufgabe")
public class Aufgabe implements ITaskItem {
	public Status status;

	public String name;

	@Override
	public String toString() {
		return (status != null ? status.toString() : "") + " " + name;
	}

	public Status getStatus() {
		if (status == null) {
			return new StatusOpen();
		}
		return status;
	}

	@Override
	public Line getLine() {
		ComplexLine line = new ComplexLine();
		{ // Checkbox
			getStatus().appendTo(line);
		}
		{ // spacer
			line.append(" ");
		}
		{ // actual Text
			Part part = line.append(name);
			if (getStatus() instanceof StatusClosed) {
				part.setStrike(true);
			}
		}
		return line;
	}
}
