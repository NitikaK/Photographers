package presentationModels;

import BIF.SWE2.interfaces.presentationmodels.MainWindowPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PictureListPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PicturePresentationModel;
import BIF.SWE2.interfaces.presentationmodels.SearchPresentationModel;

import java.util.Collection;

public class PicMainWindowPresentationModel implements MainWindowPresentationModel
{

    public PicMainWindowPresentationModel()
    {
        searchPresentationModel = new PicSearchPresentationModel();
        //pList = new LinkedList<PicPictureListPresentationModel>();
        pictureListPresentationModel = new PicPictureListPresentationModel();
    }

    @Override
    public PicturePresentationModel getCurrentPicture()
    {
        if (this.currentPicture == null)
        {
            return null;
        }
        else return this.currentPicture;
    }

    @Override
    public PictureListPresentationModel getList()
    {
        return this.pictureListPresentationModel;
    }

    @Override
    public SearchPresentationModel getSearch()
    {
        return this.searchPresentationModel;
    }

    private PicPicturePresentationModel currentPicture = null;
    private PicSearchPresentationModel searchPresentationModel = null;
    private Collection<PicPictureListPresentationModel> pList = null;
    //only for the unit test
    private PicPictureListPresentationModel pictureListPresentationModel = null;
}
