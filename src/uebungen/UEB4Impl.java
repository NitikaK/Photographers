package uebungen;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.UEB4;
import BIF.SWE2.interfaces.models.CameraModel;
import BIF.SWE2.interfaces.models.EXIFModel;
import BIF.SWE2.interfaces.models.IPTCModel;
import BIF.SWE2.interfaces.presentationmodels.CameraPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.EXIFPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.IPTCPresentationModel;
import models.PicCameraModel;
import models.PicEXIFModel;
import models.PicIPTCModel;
import picdb.*;
import presentationModels.PicCameraPresentationModel;
import presentationModels.PicEXIFPresentationModel;
import presentationModels.PicIPTCPresentationModel;

public class UEB4Impl implements UEB4 {


	@Override
	public void helloWorld() {
		// I'm fine		
	}

	@Override
	public BusinessLayer getBusinessLayer() {

		return new PicBusinessLayer();
	}

	@Override
	public EXIFModel getEmptyEXIFModel()
	{
		return new PicEXIFModel();
	}

	@Override
	public EXIFPresentationModel getEXIFPresentationModel(EXIFModel exifModel)
	{
		return new PicEXIFPresentationModel(exifModel);
	}

	@Override
	public IPTCModel getEmptyIPTCModel()
	{
		return new PicIPTCModel();
	}

	@Override
	public IPTCPresentationModel getIPTCPresentationModel(IPTCModel iptcModel) {
		return new PicIPTCPresentationModel(iptcModel);
	}

	@Override
	public CameraModel getCameraModel(String s, String s1) {
		return new PicCameraModel(s, s1);
	}

	@Override
	public CameraPresentationModel getCameraPresentationModel(CameraModel cameraModel) {
		return new PicCameraPresentationModel(cameraModel);
	}

	@Override
	public void testSetup(String picturePath) {
		// TODO Auto-generated method stub
		
	}
}
