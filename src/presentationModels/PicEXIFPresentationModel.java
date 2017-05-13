package presentationModels;

import BIF.SWE2.interfaces.ISORatings;
import BIF.SWE2.interfaces.models.EXIFModel;
import BIF.SWE2.interfaces.presentationmodels.CameraPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.EXIFPresentationModel;


public class PicEXIFPresentationModel implements EXIFPresentationModel
{
    private EXIFModel exif;
    private CameraPresentationModel camera;

    public PicEXIFPresentationModel(EXIFModel exif)
    {
        this.exif = exif;
    }

    public PicEXIFPresentationModel()
    {
    }

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
        return this.exif.getMake();
    }

    @Override
    public double getFNumber()
    {
        return this.exif.getFNumber();
    }

    @Override
    public double getExposureTime()
    {
        return this.exif.getExposureTime();
    }

    @Override
    public double getISOValue()
    {
        return this.exif.getISOValue();
    }

    @Override
    public boolean getFlash()
    {
        return this.exif.getFlash();
    }

    @Override
    public String getExposureProgram()
    {
        if (this.exif.getExposureProgram() != null)
        {
            return this.exif.getExposureProgram().toString();
        }
        else return null;
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
        double acceptable;
        double good;
        double isoValue = this.exif.getISOValue();

        if (this.camera == null)
        {
            return ISORatings.NotDefined;
        }

        good = this.camera.getISOLimitGood();
        acceptable = this.camera.getISOLimitAcceptable();

        if (isoValue <= 0)
        {
            return ISORatings.NotDefined;
        } else if (good >= isoValue)
        {
            return ISORatings.Good;
        } else if (acceptable >= isoValue)
        {
            return ISORatings.Acceptable;
        } else
        {
            return ISORatings.Noisey;
        }

    }

    @Override
    public String getISORatingResource()
    {
        //todo
        return "lol";
    }
}