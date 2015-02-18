package uebungen;

import picdb.Main;
import BIF.SWE2.interfaces.Application;
import BIF.SWE2.interfaces.UEB1;

public class UEB1Impl implements UEB1 {

	@Override
	public Application getApplication() {
		return new Main();
	}

	@Override
	public void helloWorld() {
		// I'm fine		
	}
}
