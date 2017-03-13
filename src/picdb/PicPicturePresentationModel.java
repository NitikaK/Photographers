package picdb;

import BIF.SWE2.interfaces.presentationmodels.*;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicPicturePresentationModel implements PicturePresentationModel
{
    @Override
    public int getID()
    {
        return 0;
    }

    @Override
    public String getFileName()
    {
        return null;
    }

    @Override
    public String getFilePath()
    {
        return null;
    }

    @Override
    public String getDisplayName()
    {
        return null;
    }

    @Override
    public IPTCPresentationModel getIPTC()
    {
        return null;
    }

    @Override
    public EXIFPresentationModel getEXIF()
    {
        return null;
    }

    @Override
    public PhotographerPresentationModel getPhotographer()
    {
        return null;
    }

    @Override
    public CameraPresentationModel getCamera()
    {
        return null;
    }
}
