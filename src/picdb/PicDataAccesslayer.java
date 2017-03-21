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
        createMockData();
    }

    private void createMockData()
    {
        PictureModel mockPic = new PicPictureModel();
        mockPic.setID(1234);
        EXIFModel exifMock = new PicEXIFModel();
        mockPic.setEXIF(exifMock);
        this.pictures.add(mockPic);

        PhotographerModel mockPhoto = new PicPhotographerModel();
        mockPhoto.setID(1234);
        this.photographers.add(mockPhoto);

        CameraModel mockCam = new PicCameraModel();
        mockCam.setID(1234);
        this.cameras.add(mockCam);
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

    }

    @Override
    public Collection<PhotographerModel> getPhotographers() throws Exception
    {
        return this.photographers;
    }

    @Override
    public PhotographerModel getPhotographer(int i) throws Exception
    {
        for (PhotographerModel photographer: photographers)
        {
            if (photographer.getID() == i)
            {
                return photographer;
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
