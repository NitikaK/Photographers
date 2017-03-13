package picdb;

import BIF.SWE2.interfaces.models.CameraModel;
import BIF.SWE2.interfaces.models.EXIFModel;
import BIF.SWE2.interfaces.models.IPTCModel;
import BIF.SWE2.interfaces.models.PictureModel;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicPictureModel implements PictureModel
{
    @Override
    public int getID()
    {
        return 0;
    }

    @Override
    public void setID(int i)
    {

    }

    @Override
    public String getFileName()
    {
        return null;
    }

    @Override
    public void setFileName(String s)
    {

    }

    @Override
    public IPTCModel getIPTC()
    {
        return null;
    }

    @Override
    public void setIPTC(IPTCModel iptcModel)
    {

    }

    @Override
    public EXIFModel getEXIF()
    {
        return null;
    }

    @Override
    public void setEXIF(EXIFModel exifModel)
    {

    }

    @Override
    public CameraModel getCamera()
    {
        return null;
    }

    @Override
    public void setCamera(CameraModel cameraModel)
    {

    }
}
