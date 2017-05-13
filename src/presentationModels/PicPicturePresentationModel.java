package presentationModels;

import BIF.SWE2.interfaces.models.PictureModel;
import BIF.SWE2.interfaces.presentationmodels.*;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicPicturePresentationModel implements PicturePresentationModel
{

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
        this.iptc = new PicIPTCPresentationModel(this.pictureModel.getIPTC());
        this.exif = new PicEXIFPresentationModel(this.pictureModel.getEXIF());
        this.camera = new PicCameraPresentationModel(this.pictureModel.getCamera());
    }

    @Override
    public int getID()
    {
        return this.pictureModel.getID();
    }

    @Override
    public String getFileName()
    {
        return this.pictureModel.getFileName();
    }

    @Override
    public String getFilePath()
    {
        return "Pictures/" + getFileName();
    }

    @Override
    public String getDisplayName()
    {
        return this.getFileName()+ " (by hans)";
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
        return this.camera;
    }
}
