package picdb;

import BIF.SWE2.interfaces.DataAccessLayer;

public class DALFactory
{
    private DataAccessLayer dal;

    public DataAccessLayer getDAL(DALType dalType, MockPicture picType)
    {
        switch (dalType)
        {
            case MOCK:
                dal = new MockDataAccessLayer(picType);
                break;

            case DATABASE:
                dal = new PicDataAccesslayer();
                break;

            default:
                throw new UnsupportedOperationException("This type of access layer is not available");

        }

        return this.dal;


    }
}
