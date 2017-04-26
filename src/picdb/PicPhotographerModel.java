package picdb;

import BIF.SWE2.interfaces.models.PhotographerModel;
import BIF.SWE2.interfaces.models.PictureModel;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicPhotographerModel implements PhotographerModel
{
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private String notes;

    @Override
    public int getID()
    {
        return this.id;
    }

    @Override
    public void setID(int id)
    {
        this.id = id;
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
}
