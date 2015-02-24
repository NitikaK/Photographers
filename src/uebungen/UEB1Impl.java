package uebungen;

import picdb.Main;
import BIF.SWE2.interfaces.Application;
import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.DataAccessLayer;
import BIF.SWE2.interfaces.UEB1;
import BIF.SWE2.interfaces.models.EXIFModel;
import BIF.SWE2.interfaces.models.IPTCModel;
import BIF.SWE2.interfaces.models.PhotographerModel;
import BIF.SWE2.interfaces.models.PictureModel;
import BIF.SWE2.interfaces.presentationmodels.EXIFPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.IPTCPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.MainWindowPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PhotographerListPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PhotographerPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PictureListPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PicturePresentationModel;
import BIF.SWE2.interfaces.presentationmodels.SearchPresentationModel;

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
	public PhotographerPresentationModel getEmptyPhotographerPresentationModel() {
		// TODO Auto-generated method stub
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
