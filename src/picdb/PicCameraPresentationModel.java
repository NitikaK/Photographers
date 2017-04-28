package picdb;

import BIF.SWE2.interfaces.ISORatings;
import BIF.SWE2.interfaces.models.CameraModel;
import BIF.SWE2.interfaces.presentationmodels.CameraPresentationModel;

import java.time.LocalDate;


public class PicCameraPresentationModel implements CameraPresentationModel
{
    private int id;
    private String producer;
    private String make;
    private LocalDate boughtOn;
    private String notes;
    private int numberOfPictures;
    private double isoLimitGood;
    private double isoLimitAcceptable;
    /*
    private boolean isValid;
    private boolean isValidProducer;
    */

    public PicCameraPresentationModel(CameraModel model)
    {
        this.producer = model.getProducer();
        this.make = model.getMake();
        this.isoLimitGood = model.getISOLimitGood();
        this.isoLimitAcceptable = model.getISOLimitAcceptable();
    }

    public PicCameraPresentationModel()
    {
        //forever empty :(
    }


    @Override
    public int getID()
    {
        return this.id;
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
    public int getNumberOfPictures()
    {
        return this.numberOfPictures;
    }

    @Override
    public boolean isValid()
    {
        if (!isValidBoughtOn() || !isValidMake() || !isValidProducer())
        {
            return false;
        }
        else return true;
    }


    @Override
    public boolean isValidProducer()
    {
        if(this.producer == null || this.producer.equals(""))
        {
            return false;
        }
        else return true;
    }

    @Override
    public boolean isValidMake()
    {
        if(this.make == null || this.make.equals(""))
        {
            return false;
        }
        else return true;
    }

    @Override
    public boolean isValidBoughtOn()
    {
        if (this.boughtOn != null && this.boughtOn.isAfter(LocalDate.now()))
        {
            return false;
        }
        else return true;
    }

    @Override
    public String getValidationSummary()
    {
        String summary = "";

        if (!this.isValidProducer())
        {
            summary += "Producer is not valid; ";
        }

        if (!this.isValidBoughtOn())
        {
            summary += "Bought on is not valid; ";
        }

        if (!this.isValidMake())
        {
            summary += "Make is not valid; ";
        }

        return summary;
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

    @Override
    public ISORatings translateISORating(double v)
    {
        return null;
    }
}
