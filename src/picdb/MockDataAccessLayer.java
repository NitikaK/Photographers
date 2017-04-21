package picdb;

import BIF.SWE2.interfaces.DataAccessLayer;
import BIF.SWE2.interfaces.models.*;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by gomgom on 21/04/2017.
 */
public class MockDataAccessLayer implements DataAccessLayer
{

    private Collection<PictureModel> pictures;
    private Collection<PhotographerModel> photographers;
    private Collection<CameraModel> cameras;

    public MockDataAccessLayer()
    {
        this.pictures = new LinkedList();
        this.photographers = new LinkedList();
        this.cameras = new LinkedList();
        createMockData();
    }

    private void createMockData()
    {
        PictureModel mockPic = new PicPictureModel();
        mockPic.setID(1234);
        EXIFModel exifMock = new PicEXIFModel();
        mockPic.setEXIF(exifMock);
        this.pictures.add(mockPic);

        PhotographerModel mockPhotographer = new PicPhotographerModel();
        mockPhotographer.setID(1234);
        this.photographers.add(mockPhotographer);

        CameraModel mockCam = new PicCameraModel();
        mockCam.setID(1234);
        this.cameras.add(mockCam);
    }

    @Override
    public Collection<PictureModel> getPictures(String s, PhotographerModel photographerModel, IPTCModel iptcModel, EXIFModel exifModel) throws Exception
    {
        if(s == null && photographerModel == null && iptcModel == null && exifModel == null)
        {
            //return all pictures
            return this.pictures;
        }
        else
        {
            //return filtered list of pictures
            //TODO: Photographer in Picture??

            Collection<PictureModel> tempList = new LinkedList<>();

            for (PictureModel p: pictures)
            {
                if (p.getFileName().equals(s) && p.getIPTC() == iptcModel && p.getEXIF() == exifModel)
                {
                    tempList.add(p);
                }
            }

            return tempList;
        }

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
        pictures.add(pictureModel);
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
        photographers.add(photographerModel);
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
