package uebungen;

import BIF.SWE2.interfaces.models.*;
import BIF.SWE2.interfaces.presentationmodels.*;
import picdb.Main;
import BIF.SWE2.interfaces.Application;
import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.DataAccessLayer;
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

	@Override
	public DataAccessLayer getAnyDataAccessLayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessLayer getBusinessLayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EXIFModel getEmptyEXIFModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EXIFPresentationModel getEmptyEXIFPresentationModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPTCModel getEmptyIPTCModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPTCPresentationModel getEmptyIPTCPresentationModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MainWindowPresentationModel getEmptyMainWindowPresentationModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhotographerListPresentationModel getEmptyPhotographerListPresentationModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhotographerModel getEmptyPhotographerModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CameraModel getEmptyCameraModel() {
		return null;
	}

	@Override
	public PhotographerPresentationModel getEmptyPhotographerPresentationModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CameraListPresentationModel getEmptyCameraListPresentationModel() {
		return null;
	}

	@Override
	public CameraPresentationModel getEmptyCameraPresentationModel() {
		return null;
	}

	@Override
	public PictureListPresentationModel getEmptyPictureListPresentationModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PictureModel getEmptyPictureModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PicturePresentationModel getEmptyPicturePresentationModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchPresentationModel getEmptySearchPresentationModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void testSetup(String picturePath) {
		// TODO Auto-generated method stub
		
	}
}
