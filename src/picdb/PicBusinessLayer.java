package picdb;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.DataAccessLayer;
import BIF.SWE2.interfaces.models.*;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


public class PicBusinessLayer implements BusinessLayer
{
    private DataAccessLayer dal;

    public PicBusinessLayer()
    {
        DALFactory factory = new DALFactory();
        this.dal = factory.getDAL("mockDAL");
    }



    @Override
    public Collection<PictureModel> getPictures() throws Exception
    {
        return dal.getPictures(null, null, null, null);
    }

    @Override
    public Collection<PictureModel> getPictures(String s, PhotographerModel photographerModel, IPTCModel iptcModel, EXIFModel exifModel) throws Exception
    {
        return dal.getPictures(s, photographerModel, iptcModel, exifModel);
    }

    @Override
    public PictureModel getPicture(int i) throws Exception
    {
        return dal.getPicture(i);
    }

    @Override
    public void save(PictureModel pictureModel) throws Exception
    {
        dal.save(pictureModel);
    }

    @Override
    public void deletePicture(int i) throws Exception
    {
        dal.deletePicture(i);
    }

    @Override
    public void sync() throws Exception
    {

        File picFolder = new File("./Pictures");

        //todo map
        /*HashMap<Integer, File> files = new HashMap<>();

        for(File f: picFolder.listFiles())
        {
            files.put()
        } */



        File[] fileList = picFolder.listFiles();

        for (File f: fileList)
        {
            if (!f.isDirectory())
            {
                PictureModel temp = new PicPictureModel();
                temp.setFileName(f.getName());
                temp.setEXIF(extractEXIF(f.getName()));
                temp.setIPTC(extractIPTC(f.getName()));
                dal.save(temp);
            }

        }
        //todo: other way around


    }

    @Override
    public Collection<PhotographerModel> getPhotographers() throws Exception
    {
        return dal.getPhotographers();
    }

    @Override
    public PhotographerModel getPhotographer(int i) throws Exception
    {
        return dal.getPhotographer(i);
    }

    @Override
    public void save(PhotographerModel photographerModel) throws Exception
    {
        dal.save(photographerModel);
    }

    @Override
    public void deletePhotographer(int i) throws Exception
    {
        dal.deletePhotographer(i);
    }

    @Override
    public IPTCModel extractIPTC(String s) throws Exception
    {
        return null;
    }

    @Override
    public EXIFModel extractEXIF(String s) throws Exception
    {
        LinkedList<PictureModel> tempPics = (LinkedList<PictureModel>) dal.getPictures(s, null, null, null);

        EXIFModel tempExif = tempPics.get(0).getEXIF();
        return tempExif;

    }

    @Override
    public void writeIPTC(String s, IPTCModel iptcModel) throws Exception
    {

    }

    @Override
    public Collection<CameraModel> getCameras()
    {
        return dal.getCameras();
    }

    @Override
    public CameraModel getCamera(int i)
    {
        return dal.getCamera(i);
    }
}
