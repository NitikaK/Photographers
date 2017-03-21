package uebungen;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.DataAccessLayer;
import BIF.SWE2.interfaces.UEB3;
import BIF.SWE2.interfaces.presentationmodels.SearchPresentationModel;
import picdb.PicBusinessLayer;
import picdb.PicDataAccesslayer;

public class UEB3Impl implements UEB3 {


	@Override
	public void helloWorld() {
		// I'm fine		
	}

	@Override
	public BusinessLayer getBusinessLayer()
	{
		return new PicBusinessLayer();
	}

	@Override
	public DataAccessLayer getDataAccessLayer()
	{
		return new PicDataAccesslayer();
	}

	@Override
	public SearchPresentationModel getSearchPresentationModel() {
		return null;
	}

	@Override
	public void testSetup(String picturePath) {
		// TODO Auto-generated method stub
		
	}
}
