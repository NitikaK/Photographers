package presentationModels;

import BIF.SWE2.interfaces.presentationmodels.PictureListPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PicturePresentationModel;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicPictureListPresentationModel implements PictureListPresentationModel
{
    private Collection<PicturePresentationModel> pictureList;

    public PicPictureListPresentationModel(Collection<PicturePresentationModel> list)
    {
        this.pictureList = list;
    }

    public PicPictureListPresentationModel(){}


    @Override
    public PicturePresentationModel getCurrentPicture()
    {
        return null;
    }

    @Override
    public Collection<PicturePresentationModel> getList()
    {
        return this.pictureList;
    }

    @Override
    public Collection<PicturePresentationModel> getPrevPictures()
    {
        HashMap<Integer, PicturePresentationModel> tempMap = new HashMap<>();



        return null;
    }

    @Override
    public Collection<PicturePresentationModel> getNextPictures()
    {
        return null;
    }

    @Override
    public int getCount()
    {
        return 0;
    }

    @Override
    public int getCurrentIndex()
    {
        return 0;
    }

    @Override
    public String getCurrentPictureAsString()
    {
        return null;
    }
}
