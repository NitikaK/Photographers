package uebungen;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.UEB4;
import BIF.SWE2.interfaces.models.CameraModel;
import BIF.SWE2.interfaces.models.EXIFModel;
import BIF.SWE2.interfaces.models.IPTCModel;
import BIF.SWE2.interfaces.presentationmodels.CameraPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.EXIFPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.IPTCPresentationModel;
import picdb.PicEXIFModel;
import picdb.PicEXIFPresentationModel;
import picdb.PicIPTCModel;

public class UEB4Impl implements UEB4 {


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
	public EXIFModel getEmptyEXIFModel()
	{
		return new PicEXIFModel();
	}

	@Override
	public EXIFPresentationModel getEXIFPresentationModel(EXIFModel exifModel)
	{
		return new PicEXIFPresentationModel();
	}

	@Override
	public IPTCModel getEmptyIPTCModel()
	{
		return new PicIPTCModel();
	}

	@Override
	public IPTCPresentationModel getIPTCPresentationModel(IPTCModel iptcModel) {
		return null;
	}

	@Override
	public CameraModel getCameraModel(String s, String s1) {
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
