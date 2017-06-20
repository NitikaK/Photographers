package view;

import BIF.SWE2.interfaces.models.PhotographerModel;
import BIF.SWE2.interfaces.presentationmodels.PhotographerListPresentationModel;
import BIF.SWE2.interfaces.presentationmodels.PhotographerPresentationModel;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.PicPhotographerModel;
import picdb.Main;
import picdb.PicBusinessLayer;
import presentationModels.PicPhotographerListPresentationModel;
import presentationModels.PicPhotographerPresentationModel;
import presentationModels.PicPictureListPresentationModel;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PhotographersController implements Initializable
{
    private PicBusinessLayer businessLayer;
    private PhotographerListPresentationModel photographerListPresentationModel;
    private PhotographerPresentationModel photographerPresentationModel;
    private PhotographerModel photographerModel = new PicPhotographerModel();
    private ObservableList<PhotographerPresentationModel> photographerItems = null;
    ArrayList<String> tempList= new ArrayList<>();
    // private ObservableList<String> names = null;

    @FXML
    private MenuBar MenuBar;
    @FXML
    private ListView <String> photographersList;
    //@FXML
    //private ListView<PhotographerPresentationModel> myListView;
    @FXML
    private TextField photographersName;
    @FXML
    private Label labelPhotographersSaved;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldLastName;
    @FXML
    private TextField textFieldBday;
    @FXML
    private TextField textFieldNotes;
    @FXML
    private TextField textFieldNoPictures;
    @FXML
    private Button buttonSavePhotographers;

    // return to main view with images being displayed
    @FXML
    private void clickPictures() throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) (MenuBar).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    // display photographers
    @FXML
    public void showAllPhotographers()
    {
        try
        {
            this.photographerListPresentationModel = new PicPhotographerListPresentationModel(businessLayer.getPhotographers());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //photographerItems = FXCollections.observableArrayList(photographerListPresentationModel.getList().getClass().toString());
        photographerItems = FXCollections.observableArrayList(photographerListPresentationModel.getList());
        // tempList.add("Photographers: ");

        for (int i = 0; i < photographerItems.size(); i++){
            String name = photographerItems.get(i).getFirstName();
            tempList.add(name);
        }

        ObservableList<String> names = FXCollections.observableArrayList(tempList);
        photographersList.setItems(names);
        //photographerPresentationModelListView.setItems(photographerItems);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // show all photographers here
        this.businessLayer = new PicBusinessLayer();
        photographerPresentationModel = null;

        try {
            businessLayer.sync();
        } catch (Exception e) {
            e.printStackTrace();
        }

        showAllPhotographers();

        photographersList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Your action here
            this.textFieldName.setText(String.valueOf(photographerItems.get(photographersList.getSelectionModel().getSelectedIndex()).getFirstName()));
            this.textFieldNoPictures.setText(String.valueOf(photographerItems.get(photographersList.getSelectionModel().getSelectedIndex()).getNumberOfPictures()));
            this.textFieldNotes.setText(String.valueOf(photographerItems.get(photographersList.getSelectionModel().getSelectedIndex()).getNotes()));

            LocalDate birthday = photographerItems.get(photographersList.getSelectionModel().getSelectedIndex()).getBirthDay();
            this.textFieldBday.setText(birthday.toString());

            System.out.println("Selected item: " + newValue);
            //System.out.print(formattedString);
        });

        photographerPresentationModel = photographerItems.get(0);

    }

    @FXML
    public void savePhotographers() throws Exception {
        // int id = photographerItems.get(photographersList.getSelectionModel().getSelectedIndex()).getID();
        String firstName = textFieldName.getText();
        String notes = textFieldNotes.getText();
        LocalDate birthday = LocalDate.parse(textFieldBday.getText());

        photographerModel.setFirstName(firstName);
        photographerModel.setNotes(notes);
        photographerModel.setBirthDay(birthday);
        this.businessLayer.save(photographerModel);
        labelPhotographersSaved.setVisible(true);
    }















        /*@FXML
        private void updateListview()
        {
            //
            // Set the searchquery, populate the listview with the results
            //
            try
            {
                this.photographerListPresentationModel= new PicPhotographerListPresentationModel(businessLayer.getPhotographers());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            photographerItems = FXCollections.observableArrayList (photographerListPresentationModel.getList());
            myListView.setItems(photographerItems);

        }*/


















       /* photographerPresentationModelListView.setCellFactory(listView -> new ListCell<PhotographerPresentationModel>()
        {
            private Label label = new Label();

            @Override
            public void updateItem(PhotographerPresentationModel photographer, boolean empty) {
                super.updateItem(photographer, empty);

                label.setText(photographer.getFirstName());
            }
        });



        photographerPresentationModelListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            photographerPresentationModel = newValue;
            photographerInfo();
        }); */

        //showAllPhotographers();


    // TODO: label in cellfactory


    /*public void clickPictures(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }*/


    /*@FXML
    public void showMainView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("Main.fxml"));
        Parent mainLayout = fxmlLoader.load();
        Scene scene = new Scene(mainLayout);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/

}


// <Button fx:id="buttonSaveNames" alignment="TOP_LEFT" mnemonicParsing="false" onAction="#saveChanges" text="Save changes">

// <Button fx:id="buttonSaveExif" alignment="TOP_LEFT" mnemonicParsing="false" onAction="#saveExif" text="Save changes">

