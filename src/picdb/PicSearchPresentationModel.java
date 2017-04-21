package picdb;

import BIF.SWE2.interfaces.presentationmodels.SearchPresentationModel;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicSearchPresentationModel implements SearchPresentationModel
{

    private String searchText;
    private int resultCount;

    public PicSearchPresentationModel()
    {
        this.searchText = "";
    }

    @Override
    public String getSearchText()
    {
        return this.searchText;
    }

    @Override
    public void setSearchText(String s)
    {
        this.searchText = s;
    }

    @Override
    public boolean getIsActive()
    {
        return (this.searchText.equals("")) ? false : true;
    }

    @Override
    public int getResultCount()
    {
        return this.resultCount;
    }
}
