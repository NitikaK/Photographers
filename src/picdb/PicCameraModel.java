package picdb;

import BIF.SWE2.interfaces.models.CameraModel;

import java.time.LocalDate;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicCameraModel implements CameraModel
{
    private Integer id;
    private String producer;
    private String make;
    private LocalDate boughtOn;
    private String notes;
    private double isoLimitGood;
    private double isoLimitAcceptable;

    public PicCameraModel(String producer, String make)
    {
        this.producer = producer;
        this.make = make;
    }

    public PicCameraModel()
    {

    }

    @Override
    public int getID()
    {
        return this.id;
    }

    @Override
    public void setID(int i)
    {
        this.id = i;
    }

    @Override
    public String getProducer()
    {
        return this.producer;
    }

    @Override
    public void setProducer(String s)
    {
        this.producer = s;
    }

    @Override
    public String getMake()
    {
        return this.make;
    }

    @Override
    public void setMake(String s)
    {
        this.make = s;
    }

    @Override
    public LocalDate getBoughtOn()
    {
        return this.boughtOn;
    }

    @Override
    public void setBoughtOn(LocalDate localDate)
    {
        this.boughtOn = localDate;
    }

    @Override
    public String getNotes()
    {
        return this.notes;
    }

    @Override
    public void setNotes(String s)
    {
        this.notes = s;
    }

    @Override
    public double getISOLimitGood()
    {
        return this.isoLimitGood;
    }

    @Override
    public void setISOLimitGood(double v)
    {
        this.isoLimitGood = v;
    }

    @Override
    public double getISOLimitAcceptable()
    {
        return this.isoLimitAcceptable;
    }

    @Override
    public void setISOLimitAcceptable(double v)
    {
        this.isoLimitAcceptable = v;
    }
}
