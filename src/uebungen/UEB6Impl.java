package uebungen;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.UEB6;
import BIF.SWE2.interfaces.models.PhotographerModel;
import BIF.SWE2.interfaces.models.PictureModel;
import picdb.PicBusinessLayer;
import models.PicPhotographerModel;
import models.PicPictureModel;

public class  UEB6Impl implements UEB6 {


	@Override
	public void helloWorld() {
		// I'm fine		
	}

	@Override
	public BusinessLayer getBusinessLayer() {

		return new PicBusinessLayer();
	}

	@Override
	public PictureModel getEmptyPictureModel()
	{
		return new PicPictureModel();
	}

	@Override
	public PhotographerModel getEmptyPhotographerModel()
	{
		return new PicPhotographerModel();
	}

	@Override
	public void testSetup(String picturePath) {
		// TODO Auto-generated method stub
		
	}
}
