package picdb;

import BIF.SWE2.interfaces.models.IPTCModel;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicIPTCModel implements IPTCModel
{

    private String keywords;
    private String byLine;
    private String copyrightNotice;
    private String headline;
    private String caption;

    @Override
    public String getKeywords()
    {
        return keywords;
    }

    @Override
    public void setKeywords(String keywords)
    {
        this.keywords = keywords;
    }

    @Override
    public String getByLine()
    {
        return byLine;
    }

    @Override
    public void setByLine(String byLine)
    {
        this.byLine = byLine;
    }

    @Override
    public String getCopyrightNotice()
    {
        return copyrightNotice;
    }

    @Override
    public void setCopyrightNotice(String copyrightNotice)
    {
        this.copyrightNotice = copyrightNotice;
    }

    @Override
    public String getHeadline()
    {
        return headline;
    }

    @Override
    public void setHeadline(String headline)
    {
        this.headline = headline;
    }

    @Override
    public String getCaption()
    {
        return caption;
    }

    @Override
    public void setCaption(String caption)
    {
        this.caption = caption;
    }
}
