package de.bitnoise.abzuarbeiten;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import de.bitnoise.abzuarbeiten.events.AufgabenListeChanged;
import de.bitnoise.abzuarbeiten.events.IListener;
import de.bitnoise.abzuarbeiten.model.ITaskItem;
import de.bitnoise.abzuarbeiten.model.Zustand;

public class Application {
	private static Application _app;

	Zustand _zustand;

	List<IListener> _listeners = new ArrayList<IListener>();

	public static Application get() {
		if (_app == null) {
			_app = new Application();
		}
		return _app;
	}

	private Application() {
		XStream xs = new XStream();
		File f = new File("zustand.xml");
		if (f.exists()) {
			_zustand = (Zustand) xs.fromXML(f);
		} else {
			_zustand = new Zustand();
		}
	}

	public List<ITaskItem> getAufgaben() {
		return _zustand.getAufgaben();
	}

	public void setAufgaben(List<ITaskItem> aufgaben) {
		_zustand = new Zustand();
		_zustand.getAufgaben().addAll(aufgaben);

		XStream xs = new XStream();
		try {
			FileOutputStream fo = new FileOutputStream("zustand.xml");
			xs.toXML(_zustand, fo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		fireEvent(new AufgabenListeChanged(aufgaben));
	}

	private void fireEvent(AufgabenListeChanged aufgabenListeChanged) {
		for (IListener listener : _listeners) {
			listener.event(aufgabenListeChanged);
		}
	}

	public void addAufgabenChangeListener(IListener listener) {
		_listeners.add(listener);
	}
}
