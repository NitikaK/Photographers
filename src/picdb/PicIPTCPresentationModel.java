package picdb;

import BIF.SWE2.interfaces.models.IPTCModel;
import BIF.SWE2.interfaces.presentationmodels.IPTCPresentationModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicIPTCPresentationModel implements IPTCPresentationModel
{
    private String keywords;
    private String byLine;
    private String copyrightNotice;
    private Collection<String> copyrightNotices;
    private String headline;
    private String caption;

    public PicIPTCPresentationModel(IPTCModel iptc)
    {
        this.keywords = iptc.getKeywords();
        this.byLine = iptc.getByLine();
        this.copyrightNotice = iptc.getCopyrightNotice();
        this.headline = iptc.getHeadline();
        this.caption = iptc.getCaption();
        this.copyrightNotices = new LinkedList<>();
        copyrightNotices.add("All rights reserved");
        copyrightNotices.add("CC-BY");
        copyrightNotices.add("CC-BY-SA");
        copyrightNotices.add("CC-BY-ND");
        copyrightNotices.add("CC-BY-NC");


    }

    public PicIPTCPresentationModel(){}

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
    public Collection<String> getCopyrightNotices()
    {
        return this.copyrightNotices;
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
