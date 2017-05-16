package view;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.models.PictureModel;
import BIF.SWE2.interfaces.presentationmodels.PictureListPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PicturePresentationModel;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import picdb.PicBusinessLayer;
import presentationModels.PicPictureListPresentationModel;
import presentationModels.PicPicturePresentationModel;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{



    private Stage stage;
    private PicBusinessLayer businessLayer;
    private PictureListPresentationModel pictureListPresentationModel;
    private PicturePresentationModel selectedPictureModel;


    @FXML
    private ImageView mainPicture;
    @FXML
    private ListView<PicturePresentationModel> picturesList;
    @FXML
    private Label lbStatus;
    @FXML
    private TextField textFieldMake;
    @FXML
    private TextField textFieldFNumber;
    @FXML
    private TextField textFieldExposureTime;
    @FXML
    private TextField textFieldIsoValue;
    @FXML
    private CheckBox checkboxHasFlash;
    @FXML
    private TextField textFieldKeywords;
    @FXML
    private TextField textFieldByLine;
    @FXML
    private TextField textFieldCopyrightNotice;
    @FXML
    private TextField textFieldHeadline;
    @FXML
    private TextField textFieldCaption;
    @FXML
    private Button buttonSaveExif;
    @FXML
    private Button buttonSaveIptc;
    @FXML
    public Label labelIptcSaved;
    @FXML
    public Label labelExifSaved;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        this.businessLayer = new PicBusinessLayer();
        ObservableList<PicturePresentationModel> items = null;
        selectedPictureModel = null;

        //
        //sync picfolder and then populate the PictureListPresentationModel
        //
        try
        {
            businessLayer.sync();
            this.pictureListPresentationModel = new PicPictureListPresentationModel(businessLayer.getPictures());
            items = FXCollections.observableArrayList (pictureListPresentationModel.getList());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        //
        // Only allow doubles or integers to be inserted into a texfield
        //
        ChangeListener<String> forceNumberListener = (observable, oldValue, newValue) ->
        {
            if (!newValue.matches("([0-9]+(\\.[0-9]*)?|)"))
            {
                ((StringProperty) observable).set(oldValue);
            }
        };

        textFieldFNumber.textProperty().addListener(forceNumberListener);
        textFieldFNumber.textProperty().addListener(forceNumberListener);
        textFieldExposureTime.textProperty().addListener(forceNumberListener);
        textFieldIsoValue.textProperty().addListener(forceNumberListener);



        //
        // Create the listview for displaying all pictures
        //
        picturesList.setCellFactory(listView -> new ListCell<PicturePresentationModel>()
        {

            private ImageView imageView = new ImageView();

            @Override
            public void updateItem(PicturePresentationModel picture, boolean empty)
            {
                super.updateItem(picture, empty);

                if (empty)
                {
                    setText(null);
                    setGraphic(null);
                } else
                {
                    File imageFile = new File(picture.getFilePath());
                    String fileLocation = imageFile.toURI().toString();
                    Image image = new Image(fileLocation, 150, 150, true, true);
                    imageView.setImage(image);
                    setText(picture.getFileName());
                    setGraphic(imageView);
                }
            }
        });
        picturesList.setItems(items);


        //
        // Change listener for selecting new pictures in the listview
        //
        picturesList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            selectedPictureModel = newValue;
            updateSelectedPicture();
        });
    }

    private void updateSelectedPicture()
    {
        File imageFile = new File(selectedPictureModel.getFilePath());
        String fileLocation = imageFile.toURI().toString();
        Image image = new Image(fileLocation);
        mainPicture.setImage(image);
        updateExifInformation();
        updateIptcInformation();
    }

    private void updateExifInformation()
    {
        labelExifSaved.setVisible(false);
        textFieldMake.setText(this.selectedPictureModel.getEXIF().getMake());
        textFieldFNumber.setText(String.valueOf(this.selectedPictureModel.getEXIF().getFNumber()));
        textFieldExposureTime.setText(String.valueOf(this.selectedPictureModel.getEXIF().getExposureTime()));
        textFieldIsoValue.setText(String.valueOf(this.selectedPictureModel.getEXIF().getISOValue()));
        checkboxHasFlash.setSelected(this.selectedPictureModel.getEXIF().getFlash());
    }

    private void updateIptcInformation()
    {
        labelIptcSaved.setVisible(false);
        textFieldKeywords.setText(this.selectedPictureModel.getIPTC().getKeywords());
        textFieldByLine.setText(this.selectedPictureModel.getIPTC().getByLine());
        textFieldCopyrightNotice.setText(this.selectedPictureModel.getIPTC().getCopyrightNotice());
        textFieldHeadline.setText(this.selectedPictureModel.getIPTC().getHeadline());
        textFieldCaption.setText(this.selectedPictureModel.getIPTC().getCaption());
    }


    public void setStage(Stage temp)
    {
        stage = temp;
    }


    public void saveExif()
    {
        int id = selectedPictureModel.getID();
        String make = textFieldMake.getText();
        double fNumber = Double.parseDouble(textFieldFNumber.getText());
        double exposureTime = Double.parseDouble(textFieldExposureTime.getText());
        double isoValue = Double.parseDouble(textFieldIsoValue.getText());
        boolean hasFlash = checkboxHasFlash.isSelected();

        //todo validate in presentationmodel?

        this.businessLayer.saveExif(id, make, fNumber, exposureTime, isoValue, hasFlash);
        labelExifSaved.setVisible(true);
    }

    public void saveIptc()
    {
        int id = selectedPictureModel.getID();
        String keywords = textFieldKeywords.getText();
        String byLine= textFieldByLine.getText();
        String copyrightNotice = textFieldCopyrightNotice.getText();
        String headline = textFieldHeadline.getText();
        String caption = textFieldCaption.getText();

        //todo validate in presentationmodel?

        this.businessLayer.saveIptc(id, keywords, byLine, copyrightNotice, headline, caption);
        labelIptcSaved.setVisible(true);
    }
}
