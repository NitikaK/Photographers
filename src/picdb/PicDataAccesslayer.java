package picdb;

import BIF.SWE2.interfaces.DataAccessLayer;
import BIF.SWE2.interfaces.models.*;
import BIF.SWE2.interfaces.presentationmodels.EXIFPresentationModel;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicDataAccesslayer implements DataAccessLayer
{
    private Collection<PictureModel> pictures;
    private Collection<PhotographerModel> photographers;
    private Collection<CameraModel> cameras;

    public PicDataAccesslayer()
    {
        this.pictures = new LinkedList();
        this.photographers = new LinkedList();
        this.cameras = new LinkedList();

    }



    @Override
    public Collection<PictureModel> getPictures(String s, PhotographerModel photographerModel, IPTCModel iptcModel, EXIFModel exifModel) throws Exception
    {
        return this.pictures;
    }

    @Override
    public PictureModel getPicture(int i) throws Exception
    {
        for (PictureModel pic : pictures)
        {
            if (pic.getID() == i)
            {
                return pic;
            }
        }
        return null;
    }

    @Override
    public void save(PictureModel pictureModel) throws Exception
    {

    }

    @Override
    public void deletePicture(int i) throws Exception
    {
        for (PictureModel p: pictures)
        {
            if (p.getID() == i)
            {
                pictures.remove(p);
            }
        }
    }

    @Override
    public Collection<PhotographerModel> getPhotographers() throws Exception
    {
        return this.photographers;
    }

    @Override
    public PhotographerModel getPhotographer(int i) throws Exception
    {
        for (PhotographerModel p: photographers)
        {
            if (p.getID() == i)
            {
                return p;
            }
        }
        return null;
    }

    @Override
    public void save(PhotographerModel photographerModel) throws Exception
    {

    }

    @Override
    public void deletePhotographer(int i) throws Exception
    {
        for (PhotographerModel p: photographers)
        {
            if (p.getID() == i)
            {
                photographers.remove(p);
            }
        }

    }

    @Override
    public Collection<CameraModel> getCameras()
    {
        return this.cameras;
    }

    @Override
    public CameraModel getCamera(int i)
    {
        for (CameraModel camera: cameras)
        {
            if (camera.getID() == i)
            {
                return camera;
            }
        }
        return null;
    }
}
