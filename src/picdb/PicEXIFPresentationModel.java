package picdb;

import BIF.SWE2.interfaces.ISORatings;
import BIF.SWE2.interfaces.models.EXIFModel;
import BIF.SWE2.interfaces.presentationmodels.CameraPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.EXIFPresentationModel;



public class PicEXIFPresentationModel implements EXIFPresentationModel
{
    private String make;
    private double fNumber;
    private double exposureTime;
    private double isoValue;
    private boolean flash;
    private String exposureProgram;
    private String exposureProgramResource;
    private CameraPresentationModel camera;
    private String isoRatingResource;

    public PicEXIFPresentationModel(EXIFModel exif)
    {
        this.make = exif.getMake();
        this.fNumber = exif.getFNumber();
        this.exposureTime = exif.getExposureTime();
        this.isoValue = exif.getISOValue();
        this.flash = exif.getFlash();

        if (exif.getExposureProgram() != null)
        {
            this.exposureProgram = exif.getExposureProgram().toString();
        }


    }

    public PicEXIFPresentationModel(){}

    @Override
    public CameraPresentationModel getCamera()
    {
        return this.camera;
    }

    @Override
    public void setCamera(CameraPresentationModel cameraPresentationModel)
    {
        this.camera = cameraPresentationModel;
    }

    @Override
    public String getMake()
    {
        return make;
    }

    @Override
    public double getFNumber()
    {
        return fNumber;
    }

    @Override
    public double getExposureTime()
    {
        return exposureTime;
    }

    @Override
    public double getISOValue()
    {
        return isoValue;
    }

    @Override
    public boolean getFlash()
    {
        return flash;
    }

    @Override
    public String getExposureProgram()
    {
        return exposureProgram;
    }

    @Override
    public String getExposureProgramResource()
    {
        // todo
        // return exposureProgramResource;
        return "something";
    }

    @Override
    public ISORatings getISORating()
    {
        ISORatings isoRating;
        double acceptable;
        double good;

        if (this.camera == null)
        {
            isoRating = ISORatings.NotDefined;
        }
        else
        {
            good = this.camera.getISOLimitGood();
            acceptable = this.camera.getISOLimitAcceptable();

            if (this.isoValue == 0)
            {
                isoRating = ISORatings.NotDefined;
            } else if (good >= this.isoValue)
            {
                isoRating = ISORatings.Good;
            } else if (acceptable >= this.isoValue)
            {
                isoRating = ISORatings.Acceptable;
            } else
            {
                isoRating = ISORatings.Noisey;
            }
        }

        return isoRating;

    }

    @Override
    public String getISORatingResource()
    {
        return isoRatingResource;
    }
}