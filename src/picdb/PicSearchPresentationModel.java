package picdb;

import BIF.SWE2.interfaces.presentationmodels.SearchPresentationModel;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicSearchPresentationModel implements SearchPresentationModel
{
    @Override
    public String getSearchText()
    {
        return null;
    }

    @Override
    public void setSearchText(String s)
    {

    }

    @Override
    public boolean getIsActive()
    {
        return false;
    }

    @Override
    public int getResultCount()
    {
        return 0;
    }
}
