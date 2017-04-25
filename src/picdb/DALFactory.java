package picdb;

import BIF.SWE2.interfaces.DataAccessLayer;

public class DALFactory
{
    private DataAccessLayer dal;

    public DataAccessLayer getDAL(String dalType)
    {
        switch (dalType)
        {
            case "mockDAL":
                dal = new MockDataAccessLayer();
                break;

            case "picDAL":
                dal = new PicDataAccesslayer();
                break;

            default:
                throw new UnsupportedOperationException("This type of access layer is not available");

        }

        return this.dal;


    }
}
