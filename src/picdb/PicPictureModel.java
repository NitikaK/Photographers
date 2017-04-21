package picdb;

import BIF.SWE2.interfaces.models.*;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicPictureModel implements PictureModel
{
    private Integer id;
    private String fileName;
    private IPTCModel iptc;
    private EXIFModel exif;
    private CameraModel camera;
    private PhotographerModel photographer;

    public PicPictureModel(String file)
    {
        this.fileName = file;
    }

    public PicPictureModel()
    {

    }

    public PhotographerModel getPhotographer()
    {
        return photographer;
    }

    public void setPhotographer(PhotographerModel photographer)
    {
        this.photographer = photographer;
    }

    @Override
    public int getID()
    {
        return this.id;
    }

    @Override
    public void setID(int i)
    {
        this.id = i;
    }

    @Override
    public String getFileName()
    {
        return this.fileName;
    }

    @Override
    public void setFileName(String s)
    {
        this.fileName = s;
    }

    @Override
    public IPTCModel getIPTC()
    {
        return this.iptc;
    }

    @Override
    public void setIPTC(IPTCModel iptcModel)
    {
        this.iptc = iptcModel;
    }

    @Override
    public EXIFModel getEXIF()
    {
        return this.exif;
    }

    @Override
    public void setEXIF(EXIFModel exifModel)
    {
        this.exif = exifModel;
    }

    @Override
    public CameraModel getCamera()
    {
        return this.camera;
    }

    @Override
    public void setCamera(CameraModel cameraModel)
    {
        this.camera = cameraModel;
    }
}
