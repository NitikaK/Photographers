package uebungen;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.UEB6;
import BIF.SWE2.interfaces.models.PhotographerModel;
import BIF.SWE2.interfaces.models.PictureModel;
import picdb.MockPicture;
import picdb.PicBusinessLayer;
import picdb.PicPhotographerModel;
import picdb.PicPictureModel;

public class  UEB6Impl implements UEB6 {


	@Override
	public void helloWorld() {
		// I'm fine		
	}

	@Override
	public BusinessLayer getBusinessLayer() {

		return new PicBusinessLayer(MockPicture.SINGLE);
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
