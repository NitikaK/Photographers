package picdb;

import BIF.SWE2.interfaces.presentationmodels.PhotographerPresentationModel;

import java.time.LocalDate;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicPhotographerPresentationModel implements PhotographerPresentationModel
{
    @Override
    public int getID()
    {
        return 0;
    }

    @Override
    public String getFirstName()
    {
        return null;
    }

    @Override
    public void setFirstName(String s)
    {

    }

    @Override
    public String getLastName()
    {
        return null;
    }

    @Override
    public void setLastName(String s)
    {

    }

    @Override
    public LocalDate getBirthDay()
    {
        return null;
    }

    @Override
    public void setBirthDay(LocalDate localDate)
    {

    }

    @Override
    public String getNotes()
    {
        return null;
    }

    @Override
    public void setNotes(String s)
    {

    }

    @Override
    public int getNumberOfPictures()
    {
        return 0;
    }

    @Override
    public boolean isValid()
    {
        return false;
    }

    @Override
    public String getValidationSummary()
    {
        return null;
    }

    @Override
    public boolean isValidLastName()
    {
        return false;
    }

    @Override
    public boolean isValidBirthDay()
    {
        return false;
    }
}
