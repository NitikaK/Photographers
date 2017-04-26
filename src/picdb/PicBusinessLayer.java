package picdb;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.DataAccessLayer;
import BIF.SWE2.interfaces.models.*;

import java.io.File;
import java.util.*;


public class PicBusinessLayer implements BusinessLayer
{
    private DataAccessLayer dal;

    public PicBusinessLayer()
    {
        DALFactory factory = new DALFactory();
        this.dal = factory.getDAL(DALType.MOCK);
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
        int i = 0; //counter
        boolean toDelete;

        File picFolder = new File("./Pictures");


        HashMap<Integer, File> files = new HashMap<>();

        if (picFolder.listFiles() == null)
        {
            throw new Exception("Folder is empty");
        }else
        {
            //fill hashmap
            for(File f: picFolder.listFiles())
            {
                files.put(i,f);
                i++;
            }
        }



        //save files that exist in the directory but not in the database
        for (File f: files.values())
        {
            if (!f.isDirectory())
            {
                //get filtered list with filename
                Collection picsFromDb = getPictures(f.getName(), null, null, null);

                //if the picture does not exist yet, add it to the database
                if (picsFromDb.isEmpty())
                {
                    PictureModel temp = new PicPictureModel();
                    temp.setFileName(f.getName());
                    temp.setEXIF(extractEXIF(f.getName()));
                    temp.setIPTC(extractIPTC(f.getName()));
                    dal.save(temp);
                }
            }
        }

        List<PictureModel> picsFromDb = new ArrayList<>(getPictures(null, null, null, null));
        //delete files from the database that do not exist in the directory
        for (PictureModel pic: picsFromDb)
        {
            toDelete = true;

            for (File f : files.values())
            {
                if (!f.isDirectory())
                {
                    if (f.getName().equals(pic.getFileName()))
                    {
                        toDelete = false;
                    }
                }
            }

            if (toDelete)
            {
                deletePicture(pic.getID());
            }
        }
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
        LinkedList<PictureModel> tempPics = (LinkedList<PictureModel>) dal.getPictures(s, null, null, null);

        if (tempPics.size() == 0)
        {
            throw new Exception("No file named " + s + " found");
        }
        else
        {
            return tempPics.get(0).getIPTC();
        }
    }

    @Override
    public EXIFModel extractEXIF(String s) throws Exception
    {
        LinkedList<PictureModel> tempPics = (LinkedList<PictureModel>) dal.getPictures(s, null, null, null);

        if (tempPics.size() == 0)
        {
            throw new Exception("No file named " + s + " found");
        }
        else
        {
            return tempPics.get(0).getEXIF();
        }
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
