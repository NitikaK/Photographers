package presentationModels;

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



    private Collection<String> copyrightNotices;
    private IPTCModel iptc;

    public PicIPTCPresentationModel(IPTCModel iptc)
    {
        this.iptc = iptc;
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
        return this.iptc.getKeywords();
    }

    @Override
    public void setKeywords(String keywords)
    {
        this.iptc.setKeywords(keywords);
    }

    @Override
    public String getByLine()
    {
        return this.iptc.getByLine();
    }

    @Override
    public void setByLine(String byLine)
    {
        this.iptc.setByLine(byLine);
    }

    @Override
    public String getCopyrightNotice()
    {
        return this.iptc.getCopyrightNotice();
    }

    @Override
    public void setCopyrightNotice(String copyrightNotice)
    {
        this.iptc.setCopyrightNotice(copyrightNotice);
    }

    @Override
    public Collection<String> getCopyrightNotices()
    {
        return this.copyrightNotices;
    }

    @Override
    public String getHeadline()
    {
        return this.iptc.getHeadline();
    }

    @Override
    public void setHeadline(String headline)
    {
        this.iptc.setHeadline(headline);
    }

    @Override
    public String getCaption()
    {
        return this.iptc.getCaption();
    }

    @Override
    public void setCaption(String caption)
    {
        this.iptc.setCaption(caption);
    }
}
