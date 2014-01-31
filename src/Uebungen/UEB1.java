package Uebungen;

import BIF.SWE2.Interfaces.IApplication;
import BIF.SWE2.Interfaces.IUEB1;
import MyCRM.Main;

public class UEB1 implements IUEB1 {

	@Override
	public IApplication GetApplication() {
		return new Main();
	}

	@Override
	public void HelloWorld() {
		// I'm fine		
	}
}
