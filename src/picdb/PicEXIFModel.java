package picdb;

import BIF.SWE2.interfaces.ExposurePrograms;
import BIF.SWE2.interfaces.models.EXIFModel;

/**
 * Created by gomgom on 12/03/2017.
 */
public class PicEXIFModel implements EXIFModel
{
    private String make;
    private double fNumber;
    private double exposureTime;
    private double isoValue;
    private boolean flash;
    private ExposurePrograms exposureProgram;

    @Override
    public String getMake()
    {
        return make;
    }

    @Override
    public void setMake(String make)
    {
        this.make = make;
    }

    @Override
    public double getFNumber()
    {
        return fNumber;
    }

    @Override
    public void setFNumber(double fNumber)
    {
        this.fNumber = fNumber;
    }

    @Override
    public double getExposureTime()
    {
        return exposureTime;
    }

    @Override
    public void setExposureTime(double exposureTime)
    {
        this.exposureTime = exposureTime;
    }

    @Override
    public double getISOValue()
    {
        return isoValue;
    }

    @Override
    public void setISOValue(double isoValue)
    {
        this.isoValue = isoValue;
    }

    @Override
    public boolean getFlash()
    {
        return flash;
    }

    @Override
    public void setFlash(boolean flash)
    {
        this.flash = flash;
    }

    @Override
    public ExposurePrograms getExposureProgram()
    {
        return exposureProgram;
    }

    @Override
    public void setExposureProgram(ExposurePrograms exposureProgram)
    {
        this.exposureProgram = exposureProgram;
    }
}
