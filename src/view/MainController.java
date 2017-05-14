package view;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.models.PictureModel;
import BIF.SWE2.interfaces.presentationmodels.PictureListPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PicturePresentationModel;
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
    private BusinessLayer businessLayer;
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
        // Create bidirectional binding for exif and iptc properties
        //todo
        //textFieldMake.textProperty().bindBidirectional(selectedPictureModel.getEXIF().makePropertyProperty());


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
    }



    public void setStage(Stage temp)
    {
        stage = temp;
    }


    public void saveExif(ActionEvent actionEvent)
    {

    }
}
