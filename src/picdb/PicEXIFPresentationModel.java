package picdb;

import BIF.SWE2.interfaces.ISORatings;
import BIF.SWE2.interfaces.presentationmodels.CameraPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.EXIFPresentationModel;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicEXIFPresentationModel implements EXIFPresentationModel
{
    @Override
    public String getMake()
    {
        return null;
    }

    @Override
    public double getFNumber()
    {
        return 0;
    }

    @Override
    public double getExposureTime()
    {
        return 0;
    }

    @Override
    public double getISOValue()
    {
        return 0;
    }

    @Override
    public boolean getFlash()
    {
        return false;
    }

    @Override
    public String getExposureProgram()
    {
        return null;
    }

    @Override
    public String getExposureProgramResource()
    {
        return null;
    }

    @Override
    public CameraPresentationModel getCamera()
    {
        return null;
    }

    @Override
    public void setCamera(CameraPresentationModel cameraPresentationModel)
    {

    }

    @Override
    public ISORatings getISORating()
    {
        return null;
    }

    @Override
    public String getISORatingResource()
    {
        return null;
    }
}
