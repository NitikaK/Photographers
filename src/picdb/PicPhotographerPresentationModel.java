package picdb;

import BIF.SWE2.interfaces.models.PhotographerModel;
import BIF.SWE2.interfaces.presentationmodels.PhotographerPresentationModel;

import java.time.LocalDate;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicPhotographerPresentationModel implements PhotographerPresentationModel
{
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private String notes;

    public PicPhotographerPresentationModel(){}

    public PicPhotographerPresentationModel(PhotographerModel pModel)
    {
        this.id = pModel.getID();
        this.firstName = pModel.getFirstName();
        this.lastName = pModel.getLastName();
        this.birthDay = pModel.getBirthDay();
        this.notes = pModel.getNotes();
    }

    @Override
    public int getID()
    {
        return id;
    }

    @Override
    public String getFirstName()
    {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Override
    public String getLastName()
    {
        return lastName;
    }

    @Override
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Override
    public LocalDate getBirthDay()
    {
        return birthDay;
    }

    @Override
    public void setBirthDay(LocalDate birthDay)
    {
        this.birthDay = birthDay;
    }

    @Override
    public String getNotes()
    {
        return notes;
    }

    @Override
    public void setNotes(String notes)
    {
        this.notes = notes;
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
        if(this.lastName != null && !this.lastName.isEmpty())
        {
            return true;
        }
        else return false;

    }

    @Override
    public boolean isValidBirthDay()
    {
        if (this.birthDay == null || this.birthDay.isBefore(LocalDate.now()))
        {
            return true;
        }
        else return false;

    }
}
