package uebungen;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.UEB2;
import BIF.SWE2.interfaces.models.CameraModel;
import BIF.SWE2.interfaces.models.PictureModel;
import BIF.SWE2.interfaces.presentationmodels.CameraPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.MainWindowPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PicturePresentationModel;
import picdb.*;

public class UEB2Impl implements UEB2 {


	@Override
	public void helloWorld() {
		// I'm fine		
	}

	@Override
	public MainWindowPresentationModel GetMainWindowPresentationModel()
	{
		return new PicMainWindowPresentationModel();
	}

	@Override
	public CameraModel getCameraModel(String s, String s1)
	{
		return new PicCameraModel(s,s1);
	}

	@Override
	public CameraPresentationModel getCameraPresentationModel(CameraModel cameraModel)
	{
		return new PicCameraPresentationModel(cameraModel);
	}

	@Override
	public BusinessLayer getBusinessLayer()
	{
		return new PicBusinessLayer();
	}

	@Override
	public PictureModel getPictureModel(String arg0)
	{
		return new PicPictureModel(arg0);
	}

	@Override
	public PicturePresentationModel getPicturePresentationModel(PictureModel mdl)
	{
		return new PicPicturePresentationModel(mdl);
	}

	@Override
	public void testSetup(String picturePath) {

		
	}
}
