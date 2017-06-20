package presentationModels;

import BIF.SWE2.interfaces.models.PhotographerModel;
import BIF.SWE2.interfaces.presentationmodels.PhotographerPresentationModel;
import models.PicPhotographerModel;

import java.time.LocalDate;

public class PicPhotographerPresentationModel implements PhotographerPresentationModel
{
    private PhotographerModel model;

    public PicPhotographerPresentationModel(){}

    public PicPhotographerPresentationModel(PhotographerModel pmodel)
    {
        this.model = pmodel;
    }

    @Override
    public int getID()
    {
        return model.getID();
    }

    @Override
    public String getFirstName()
    {
        return model.getFirstName();
    }

    @Override
    public void setFirstName(String firstName)
    {
        model.setFirstName(firstName);
    }

    @Override
    public String getLastName()
    {
        return model.getLastName();
    }

    @Override
    public void setLastName(String lastName)
    {
        model.setLastName(lastName);
    }

    @Override
    public LocalDate getBirthDay()
    {
        return model.getBirthDay();
    }

    @Override
    public void setBirthDay(LocalDate birthDay)
    {
        model.setBirthDay(birthDay);
    }

    @Override
    public String getNotes()
    {
        return model.getNotes();
    }

    @Override
    public void setNotes(String notes)
    {
        model.setNotes(notes);
    }

    @Override
    public int getNumberOfPictures()
    {
        return 0;
    }

    @Override
    public boolean isValid()
    {
        if (isValidBirthDay() && isValidLastName())
        {
            return true;
        }
        else return false;
    }

    @Override
    public String getValidationSummary()
    {
        String summary = "";

        if (!isValid())
        {
            if (!isValidBirthDay())
            {
                summary += "Birthday is not valid. ";
            }

            if (!isValidLastName())
            {
                summary += "Lastname is not valid.";
            }
        }

        return summary;
    }

    @Override
    public boolean isValidLastName()
    {
        if(getLastName() != null && !getLastName().isEmpty())
        {
            return true;
        }
        else return false;

    }

    @Override
    public boolean isValidBirthDay()
    {
        if (getBirthDay() == null || getBirthDay().isBefore(LocalDate.now()))
        {
            return true;
        }
        else return false;

    }

    public String getName(){
        return model.getFirstName() + " " +model.getLastName();
    }
}
