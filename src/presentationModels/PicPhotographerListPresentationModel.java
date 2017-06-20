package presentationModels;

import BIF.SWE2.interfaces.models.PhotographerModel;
import BIF.SWE2.interfaces.models.PictureModel;
import BIF.SWE2.interfaces.presentationmodels.PhotographerListPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PhotographerPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PicturePresentationModel;
import models.PicPhotographerModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PicPhotographerListPresentationModel implements PhotographerListPresentationModel
{

    private List<PhotographerPresentationModel> photographerList;

    public PicPhotographerListPresentationModel(){}

    public PicPhotographerListPresentationModel(Collection<PhotographerModel> list)
    {
        photographerList = new ArrayList<>();

        for(PhotographerModel model: list)
        {
            photographerList.add(new PicPhotographerPresentationModel(model));
        }
    }

    @Override
    public Collection<PhotographerPresentationModel> getList()
    {
        return this.photographerList;
    }

    @Override
    public PhotographerPresentationModel getCurrentPhotographer()
    {
        return null;
    }

    public String getName (PhotographerModel model){
        return model.getFirstName() + " " + model.getLastName();
    }

}
