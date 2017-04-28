package uebungen;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.DataAccessLayer;
import BIF.SWE2.interfaces.UEB3;
import BIF.SWE2.interfaces.presentationmodels.SearchPresentationModel;
import picdb.*;

public class UEB3Impl implements UEB3 {


    @Override
    public void helloWorld() {
        // I'm fine
    }

    @Override
    public BusinessLayer getBusinessLayer()
    {
        return new PicBusinessLayer();
    }

    @Override
    public DataAccessLayer getDataAccessLayer()
    {
        DALFactory dalFactory = new DALFactory();
        DataAccessLayer mockDAL = dalFactory.getDAL(DALType.MOCK, MockPicture.LIST);
        return mockDAL;
    }

    @Override
    public SearchPresentationModel getSearchPresentationModel() {

        return new PicSearchPresentationModel();

    }

    @Override
    public void testSetup(String picturePath) {
        // TODO Auto-generated method stub

    }
}