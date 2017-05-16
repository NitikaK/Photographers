package presentationModels;

import BIF.SWE2.interfaces.models.PictureModel;
import BIF.SWE2.interfaces.presentationmodels.PictureListPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PicturePresentationModel;
import models.PicPictureModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicPictureListPresentationModel implements PictureListPresentationModel
{
    private List<PicturePresentationModel> pictureList;

    public PicPictureListPresentationModel(Collection<PictureModel> list)
    {
        this.pictureList = new ArrayList<>();

        for(PictureModel model: list)
        {
            this.pictureList.add(new PicPicturePresentationModel(model));
        }
    }

    public PicPictureListPresentationModel(){}


    @Override
    public PicturePresentationModel getCurrentPicture()
    {
        return pictureList.get(getCurrentIndex());
    }

    @Override
    public Collection<PicturePresentationModel> getList()
    {
        return this.pictureList;
    }

    @Override
    public Collection<PicturePresentationModel> getPrevPictures()
    {
        List<PicturePresentationModel> tempList= new ArrayList<>();

        for (int i = 0; i < getCurrentIndex(); i++)
        {
            tempList.add(pictureList.get(i));
        }

        return tempList;
    }

    @Override
    public Collection<PicturePresentationModel> getNextPictures()
    {
        List<PicturePresentationModel> tempList= new ArrayList<>();

        for (int i = getCurrentIndex(); i < pictureList.size(); i++)
        {
            tempList.add(pictureList.get(i));
        }

        return tempList;
    }

    @Override
    public int getCount()
    {
        return pictureList.size();
    }

    @Override
    public int getCurrentIndex()
    {
        //todo
        return 0;
    }

    @Override
    public String getCurrentPictureAsString()
    {
        return getCurrentPicture().toString();
    }
}
