package picdb;

import BIF.SWE2.interfaces.DataAccessLayer;
import BIF.SWE2.interfaces.models.*;

import java.util.Collection;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicDataAccesslayer implements DataAccessLayer
{
    @Override
    public Collection<PictureModel> getPictures(String s, PhotographerModel photographerModel, IPTCModel iptcModel, EXIFModel exifModel) throws Exception
    {
        return null;
    }

    @Override
    public PictureModel getPicture(int i) throws Exception
    {
        return null;
    }

    @Override
    public void save(PictureModel pictureModel) throws Exception
    {

    }

    @Override
    public void deletePicture(int i) throws Exception
    {

    }

    @Override
    public Collection<PhotographerModel> getPhotographers() throws Exception
    {
        return null;
    }

    @Override
    public PhotographerModel getPhotographer(int i) throws Exception
    {
        return null;
    }

    @Override
    public void save(PhotographerModel photographerModel) throws Exception
    {

    }

    @Override
    public void deletePhotographer(int i) throws Exception
    {

    }

    @Override
    public Collection<CameraModel> getCameras()
    {
        return null;
    }

    @Override
    public CameraModel getCamera(int i)
    {
        return null;
    }
}
