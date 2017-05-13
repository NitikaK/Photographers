package uebungen;

import BIF.SWE2.interfaces.models.*;
import BIF.SWE2.interfaces.presentationmodels.*;
import models.*;
import picdb.*;
import BIF.SWE2.interfaces.Application;
import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.DataAccessLayer;
import BIF.SWE2.interfaces.UEB1;
import presentationModels.*;

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
	public DataAccessLayer getAnyDataAccessLayer()
	{
		return new PicDataAccesslayer();
	}

	@Override
	public BusinessLayer getBusinessLayer()
	{
		return new PicBusinessLayer();
	}

	@Override
	public EXIFModel getEmptyEXIFModel()
	{
		return new PicEXIFModel();
	}

	@Override
	public EXIFPresentationModel getEmptyEXIFPresentationModel()
	{
		return new PicEXIFPresentationModel();
	}

	@Override
	public IPTCModel getEmptyIPTCModel()
	{
		return new PicIPTCModel();
	}

	@Override
	public IPTCPresentationModel getEmptyIPTCPresentationModel()
	{
		return new PicIPTCPresentationModel();
	}

	@Override
	public MainWindowPresentationModel getEmptyMainWindowPresentationModel()
	{
		return new PicMainWindowPresentationModel();
	}

	@Override
	public PhotographerListPresentationModel getEmptyPhotographerListPresentationModel()
	{
		return new PicPhotographerListPresentationModel();
	}

	@Override
	public PhotographerModel getEmptyPhotographerModel()
	{
		return new PicPhotographerModel();
	}

	@Override
	public CameraModel getEmptyCameraModel()
	{
		return new PicCameraModel();
	}

	@Override
	public PhotographerPresentationModel getEmptyPhotographerPresentationModel()
	{
		return new PicPhotographerPresentationModel();
	}

	@Override
	public CameraListPresentationModel getEmptyCameraListPresentationModel()
	{
		return new PicCameraListPresentationModel();
	}

	@Override
	public CameraPresentationModel getEmptyCameraPresentationModel()
	{
		return new PicCameraPresentationModel();
	}

	@Override
	public PictureListPresentationModel getEmptyPictureListPresentationModel()
	{
		return new PicPictureListPresentationModel();
	}

	@Override
	public PictureModel getEmptyPictureModel()
	{
		return new PicPictureModel();
	}

	@Override
	public PicturePresentationModel getEmptyPicturePresentationModel()
	{
		return new PicPicturePresentationModel();
	}

	@Override
	public SearchPresentationModel getEmptySearchPresentationModel()
	{
		return new PicSearchPresentationModel();
	}

	@Override
	public void testSetup(String picturePath) {
		// TODO Auto-generated method stub
		
	}
}
