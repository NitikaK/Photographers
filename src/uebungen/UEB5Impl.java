package uebungen;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.UEB5;
import BIF.SWE2.interfaces.models.CameraModel;
import BIF.SWE2.interfaces.models.PhotographerModel;
import BIF.SWE2.interfaces.presentationmodels.CameraPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PhotographerPresentationModel;

public class UEB5Impl implements UEB5 {


	@Override
	public void helloWorld() {
		// I'm fine		
	}

	@Override
	public BusinessLayer getBusinessLayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhotographerModel getEmptyPhotographerModel() {
		return null;
	}

	@Override
	public PhotographerPresentationModel getPhotographerPresentationModel(PhotographerModel photographerModel) {
		return null;
	}

	@Override
	public CameraModel getEmptyCameraModel() {
		return null;
	}

	@Override
	public CameraPresentationModel getCameraPresentationModel(CameraModel cameraModel) {
		return null;
	}

	@Override
	public void testSetup(String picturePath) {
		// TODO Auto-generated method stub
		
	}
}
