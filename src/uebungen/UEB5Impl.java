package uebungen;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.UEB5;
import BIF.SWE2.interfaces.models.CameraModel;
import BIF.SWE2.interfaces.models.PhotographerModel;
import BIF.SWE2.interfaces.presentationmodels.CameraPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PhotographerPresentationModel;
import models.PicCameraModel;
import models.PicPhotographerModel;
import picdb.*;
import presentationModels.PicCameraPresentationModel;
import presentationModels.PicPhotographerPresentationModel;

public class UEB5Impl implements UEB5 {


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
	public PhotographerModel getEmptyPhotographerModel()
	{
		return new PicPhotographerModel();
	}

	@Override
	public PhotographerPresentationModel getPhotographerPresentationModel(PhotographerModel photographerModel)
	{
		return new PicPhotographerPresentationModel(photographerModel);
	}

	@Override
	public CameraModel getEmptyCameraModel()
	{
		return new PicCameraModel();
	}

	@Override
	public CameraPresentationModel getCameraPresentationModel(CameraModel cameraModel)
	{
		return new PicCameraPresentationModel(cameraModel);
	}

	@Override
	public void testSetup(String picturePath) {
		// TODO Auto-generated method stub
		
	}
}
