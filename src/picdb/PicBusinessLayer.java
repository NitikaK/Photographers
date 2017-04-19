package picdb;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.DataAccessLayer;
import BIF.SWE2.interfaces.models.*;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicBusinessLayer implements BusinessLayer
{
    private Collection pictures;
    private Collection photographers;
    private Collection cameras;
    private DataAccessLayer dal;


    public PicBusinessLayer()
    {
        this.pictures = new LinkedList<PictureModel>();
        this.photographers = new LinkedList<PhotographerModel>();
        this.cameras = new LinkedList<CameraModel>();
    }

    @Override
    public Collection<PictureModel> getPictures() throws Exception
    {
        return this.pictures;
    }

    @Override
    public Collection<PictureModel> getPictures(String s, PhotographerModel photographerModel, IPTCModel iptcModel, EXIFModel exifModel) throws Exception
    {
        return this.pictures;
    }

    @Override
    public PictureModel getPicture(int i) throws Exception
    {
        /*for (int j = 0; j < pictures.size(); j++)
        {
            if(this.pictures)
        }*/
        return null;
    }

    @Override
    public void save(PictureModel pictureModel) throws Exception
    {

    }

    @Override
    public void deletePicture(int i) throws Exception
    {

    }

    @Override
    public void sync() throws Exception
    {
        File picFolder = new File("./Pictures");
        for (File f: picFolder.listFiles())
        {
            pictures.add(f);
        }

    }

    @Override
    public Collection<PhotographerModel> getPhotographers() throws Exception
    {
        return this.photographers;
    }

    @Override
    public PhotographerModel getPhotographer(int i) throws Exception
    {
        return null;
    }

    @Override
    public void save(PhotographerModel photographerModel) throws Exception
    {

    }

    @Override
    public void deletePhotographer(int i) throws Exception
    {

    }

    @Override
    public IPTCModel extractIPTC(String s) throws Exception
    {
        return null;
    }

    @Override
    public EXIFModel extractEXIF(String s) throws Exception
    {
        return null;
    }

    @Override
    public void writeIPTC(String s, IPTCModel iptcModel) throws Exception
    {

    }

    @Override
    public Collection<CameraModel> getCameras()
    {
        return null;
    }

    @Override
    public CameraModel getCamera(int i)
    {
        return null;
    }
}
