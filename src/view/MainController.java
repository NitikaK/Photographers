package view;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.models.PictureModel;
import BIF.SWE2.interfaces.presentationmodels.PhotographerListPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PhotographerPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PictureListPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PicturePresentationModel;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import picdb.PicBusinessLayer;
import presentationModels.PicPhotographerListPresentationModel;
import presentationModels.PicPictureListPresentationModel;
import presentationModels.PicPicturePresentationModel;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    private Stage stage;
    private PicBusinessLayer businessLayer;
    private PictureListPresentationModel pictureListPresentationModel;
    private PicturePresentationModel selectedPictureModel;
    private PhotographerListPresentationModel photographerListPresentationModel;
    private ObservableList<PicturePresentationModel> items = null;
    private ObservableList<PhotographerPresentationModel> photoItems = null;

    @FXML
    private MenuBar myMenuBar;
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
    @FXML
    TextField textFieldSearch;

    @FXML
    private void clickPhotographers(ActionEvent event) throws IOException, InvocationTargetException {
        System.out.println("You clicked me!");
        //Parent home_page_parent = FXMLLoader.load(getClass().getResource("Photographers.fxml"));
        //Scene home_page_scene = new Scene(home_page_parent);
        Scene home_page_scene = new Scene(FXMLLoader.load(getClass().getResource("Photographers.fxml")));
        //Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage app_stage = (Stage) (myMenuBar).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        this.businessLayer = new PicBusinessLayer();
        selectedPictureModel = null;

        //
        //sync picfolder and then populate the PictureListPresentationModel
        //
        try
        {
            businessLayer.sync();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        //
        // Only allow doubles or integers to be inserted into a texfield (forceListener)
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
        // add listener for new search input
        // TODO improve the search function
        textFieldSearch.textProperty().addListener((observable, oldValue, newValue) ->
        {
            updateListview(newValue);
        });


        //
        // cell factory for displaying thumbnails in imagelist
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


        //
        // Initially, all pictures are displayed
        //
        updateListview("");


        //
        //Set the first picture as initial picture
        //
        selectedPictureModel = items.get(0);
        updateSelectedPicture();


        //
        // Change listener for selecting new pictures in the listview
        //
        picturesList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            selectedPictureModel = newValue;
            updateSelectedPicture();
        });
    }


    //
    // update the list with the entered searchtext
    //
    private void updateListview(String searchText)
    {
        //
        // Set the searchquery, populate the listview with the results
        //
        try
        {
            this.pictureListPresentationModel = new PicPictureListPresentationModel(businessLayer.getPictures(searchText, null, null, null));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        items = FXCollections.observableArrayList (pictureListPresentationModel.getList());
        picturesList.setItems(items);

    }

    //
    // update all gui elements, when a new picture gets selected from the gui
    //
    private void updateSelectedPicture()
    {
        File imageFile = new File(selectedPictureModel.getFilePath());
        String fileLocation = imageFile.toURI().toString();
        Image image = new Image(fileLocation);
        mainPicture.setImage(image);
        updateExifInformation();
        updateIptcInformation();
    }


    //
    // update exif-data in the gui
    //
    private void updateExifInformation()
    {
        labelExifSaved.setVisible(false);
        textFieldMake.setText(this.selectedPictureModel.getEXIF().getMake());
        textFieldFNumber.setText(String.valueOf(this.selectedPictureModel.getEXIF().getFNumber()));
        textFieldExposureTime.setText(String.valueOf(this.selectedPictureModel.getEXIF().getExposureTime()));
        textFieldIsoValue.setText(String.valueOf(this.selectedPictureModel.getEXIF().getISOValue()));
        checkboxHasFlash.setSelected(this.selectedPictureModel.getEXIF().getFlash());
    }


    //
    // update iptc-data in the gui
    //
    private void updateIptcInformation()
    {
        labelIptcSaved.setVisible(false);
        textFieldKeywords.setText(this.selectedPictureModel.getIPTC().getKeywords());
        textFieldByLine.setText(this.selectedPictureModel.getIPTC().getByLine());
        textFieldCopyrightNotice.setText(this.selectedPictureModel.getIPTC().getCopyrightNotice());
        textFieldHeadline.setText(this.selectedPictureModel.getIPTC().getHeadline());
        textFieldCaption.setText(this.selectedPictureModel.getIPTC().getCaption());
    }


    //
    // get all exif-inputs and save the data via businesslayer
    //
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


    //
    // get all iptc-inputs and save the data via businesslayer
    //
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


    /*@FXML
    public void clickPhotographers(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Photographers.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }*/

}
