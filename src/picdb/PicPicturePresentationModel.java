package picdb;

import BIF.SWE2.interfaces.models.CameraModel;
import BIF.SWE2.interfaces.models.PictureModel;
import BIF.SWE2.interfaces.presentationmodels.*;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicPicturePresentationModel implements PicturePresentationModel
{
    private int id;
    private String fileName;
    private String filePath;
    private IPTCPresentationModel iptc;
    private EXIFPresentationModel exif;
    private PhotographerPresentationModel photographer;
    private CameraPresentationModel camera;
    private PictureModel pictureModel;

    public PicPicturePresentationModel()
    {

    }

    public PicPicturePresentationModel(PictureModel pictureModel)
    {
        this.pictureModel = pictureModel;
        this.fileName = pictureModel.getFileName();
        this.iptc = new PicIPTCPresentationModel();
        this.exif = new PicEXIFPresentationModel();
    }

    @Override
    public int getID()
    {
        return 0;
    }

    @Override
    public String getFileName()
    {
        return this.fileName;
    }

    @Override
    public String getFilePath()
    {
        return this.filePath;
    }

    @Override
    public String getDisplayName()
    {
        return fileName + " (by hans)";
    }

    @Override
    public IPTCPresentationModel getIPTC()
    {
        return this.iptc;
    }

    @Override
    public EXIFPresentationModel getEXIF()
    {
        return this.exif;
    }

    @Override
    public PhotographerPresentationModel getPhotographer()
    {
        return this.photographer;
    }

    @Override
    public CameraPresentationModel getCamera()
    {
        this.camera = new PicCameraPresentationModel(this.pictureModel.getCamera());
        return this.camera;
    }
}
