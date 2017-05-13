package presentationModels;

import BIF.SWE2.interfaces.ISORatings;
import BIF.SWE2.interfaces.models.CameraModel;
import BIF.SWE2.interfaces.presentationmodels.CameraPresentationModel;

import java.time.LocalDate;


public class PicCameraPresentationModel implements CameraPresentationModel
{
    private CameraModel camera;

    public PicCameraPresentationModel(CameraModel model)
    {
        this.camera = model;
    }

    public PicCameraPresentationModel()
    {
        //forever empty :(
    }


    @Override
    public int getID()
    {
        return this.camera.getID();
    }

    @Override
    public String getProducer()
    {
        return this.camera.getProducer();
    }

    @Override
    public void setProducer(String s)
    {
        this.camera.setProducer(s);
    }

    @Override
    public String getMake()
    {
        return this.camera.getMake();
    }

    @Override
    public void setMake(String s)
    {
        this.camera.setMake(s);
    }

    @Override
    public LocalDate getBoughtOn()
    {
        return this.camera.getBoughtOn();
    }

    @Override
    public void setBoughtOn(LocalDate localDate)
    {
        this.camera.setBoughtOn(localDate);
    }

    @Override
    public String getNotes()
    {
        return this.camera.getNotes();
    }

    @Override
    public void setNotes(String s)
    {
        this.camera.setNotes(s);
    }

    @Override
    public int getNumberOfPictures()
    {
        //todo
        return 0;
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
        if(this.camera.getProducer() == null || "".equals(this.camera.getProducer()))
        {
            return false;
        }
        else return true;
    }

    @Override
    public boolean isValidMake()
    {
        if(this.camera.getMake() == null || "".equals(this.camera.getMake()))
        {
            return false;
        }
        else return true;
    }

    @Override
    public boolean isValidBoughtOn()
    {
        if (this.camera.getBoughtOn() != null && this.camera.getBoughtOn().isAfter(LocalDate.now()))
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
        return this.camera.getISOLimitGood();
    }

    @Override
    public void setISOLimitGood(double v)
    {
        this.camera.setISOLimitGood(v);
    }

    @Override
    public double getISOLimitAcceptable()
    {
        return this.camera.getISOLimitAcceptable();
    }

    @Override
    public void setISOLimitAcceptable(double v)
    {
        this.camera.setISOLimitGood(v);
    }

    @Override
    public ISORatings translateISORating(double v)
    {
        //todo?
        return null;
    }
}
