package picdb;

import BIF.SWE2.interfaces.DataAccessLayer;
import BIF.SWE2.interfaces.models.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class MockDataAccessLayer implements DataAccessLayer
{

    private HashMap<Integer, PictureModel> pictures;
    private HashMap<Integer, PhotographerModel> photographers;
    private HashMap<Integer, CameraModel> cameras;

    public MockDataAccessLayer()
    {
        this.pictures = new HashMap<>();
        this.photographers = new HashMap<>();
        this.cameras = new HashMap<>();
        createMockData();
    }

    private void createMockData()
    {
        int pictureId = 1234;
        int photographerId = 1234;
        int cameraId = 1234;

        for (int i = 0; i < 10; i++)
        {
            PictureModel mockPic = new PicPictureModel();
            mockPic.setFileName("Img" + i + "jpg");
            mockPic.setID(photographerId);
            EXIFModel exifMock = new PicEXIFModel();
            exifMock.setMake("NiceCam");
            exifMock.setExposureTime(23.12);
            exifMock.setFNumber(23.12);
            exifMock.setISOValue(23.12);
            mockPic.setEXIF(exifMock);
            this.pictures.put(i, mockPic);
            pictureId++;
        }

        for (int i = 0; i < 10; i++)
        {
            PhotographerModel mockPhotographer = new PicPhotographerModel();
            mockPhotographer.setID(photographerId);
            this.photographers.put(i, mockPhotographer);
            photographerId++;
        }

        for (int i = 0; i < 10; i++)
        {
            CameraModel mockCam = new PicCameraModel();
            mockCam.setID(cameraId);
            this.cameras.put(i, mockCam);
            cameraId++;
        }
    }

    @Override
    public Collection<PictureModel> getPictures(String s, PhotographerModel photographerModel, IPTCModel iptcModel, EXIFModel exifModel) throws Exception
    {
        if((s == null || "" .equals(s)) && photographerModel == null && iptcModel == null && exifModel == null)
        {
            //return all pictures
            return this.pictures.values();
        }
        else
        {
            //return filtered list of pictures
            //TODO: Photographer in Picture??

            Collection<PictureModel> tempList = new LinkedList<>();

            for (PictureModel p: pictures.values())
            {
                if (p.getFileName().equals(s) || p.getIPTC() == iptcModel || p.getEXIF() == exifModel)
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
        for (PictureModel pic : pictures.values())
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
        pictures.put(pictures.size(), pictureModel);
    }

    @Override
    public void deletePicture(int i) throws Exception
    {
        for (int k = 0; k < pictures.size(); k++)
        {
            PictureModel tempPicture = pictures.get(k);

            if (tempPicture.getID() == i)
            {
                pictures.remove(k);
            }

        }
    }

    @Override
    public Collection<PhotographerModel> getPhotographers() throws Exception
    {
        return this.photographers.values();
    }

    @Override
    public PhotographerModel getPhotographer(int i) throws Exception
    {
        for (PhotographerModel p: photographers.values())
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
        photographers.put(photographers.size(), photographerModel);
    }

    @Override
    public void deletePhotographer(int i) throws Exception
    {
        for (int k = 0; k < photographers.size(); k++)
        {
            PhotographerModel tempPhotographer = photographers.get(k);

            //todo: if photographer is linked with a picture - throw an exception (pictures->iptc)

            if (tempPhotographer.getID() == i)
            {
                photographers.remove(k);
            }

        }

    }

    @Override
    public Collection<CameraModel> getCameras()
    {
        return this.cameras.values();
    }

    @Override
    public CameraModel getCamera(int i)
    {
        for (CameraModel camera: cameras.values())
        {
            if (camera.getID() == i)
            {
                return camera;
            }
        }
        return null;
    }
}
