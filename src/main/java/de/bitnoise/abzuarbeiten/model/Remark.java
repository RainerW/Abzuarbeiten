package de.bitnoise.abzuarbeiten.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Remark")
public class Remark implements ITaskItem {
	String heading;

	public Remark(String line) {
		heading = line;
	}

	public void getLine(StringBuilder sb) {
		sb.append(heading);
	}

	@Override
	public String toString() {
		return heading;
	}

	@Override
	public Line getLine() {
		return new TextLine(heading);
	}
}
