package view;

import BIF.SWE2.interfaces.BusinessLayer;
import BIF.SWE2.interfaces.models.PictureModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import picdb.PicBusinessLayer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    public ListView<PictureModel> picturesList;
    private Stage stage;
    private BusinessLayer businessLayer;

    @FXML
    private Label lbStatus;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        this.businessLayer = new PicBusinessLayer();
        try
        {
            businessLayer.sync();
        } catch (Exception e)
        {
            e.printStackTrace();
        }


        //
        // Create the listview for displaying all pictures
        //

        ObservableList<PictureModel> items = null;
        try
        {
            items = FXCollections.observableArrayList (businessLayer.getPictures());
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        picturesList.setCellFactory(listView -> new ListCell<PictureModel>()
        {

            private ImageView imageView = new ImageView();

            @Override
            public void updateItem(PictureModel picture, boolean empty)
            {
                super.updateItem(picture, empty);

                if (empty)
                {
                    setText(null);
                    setGraphic(null);
                } else
                {
                    File imageFile = new File("Pictures/" + picture.getFileName());

                    String filelocation = imageFile.toURI().toString();
                    //todo bildpfad
                    Image image = new Image(filelocation, 200, 200, true, true);
                    imageView.setImage(image);
                    setText(picture.getFileName());
                    setGraphic(imageView);
                }
            }
        });
        picturesList.setItems(items);
    }

    public void setStage(Stage temp)
    {
        stage = temp;
    }

    @FXML
    private void onBtnAbout(ActionEvent event) throws IOException
    {
        lbStatus.setText("Opening about box");

        FXMLLoader fl = new FXMLLoader();
        fl.setLocation(getClass().getResource("About.fxml"));
        fl.load();
        Parent root = fl.getRoot();

        Stage modal_dialog = new Stage(StageStyle.DECORATED);
        modal_dialog.initModality(Modality.WINDOW_MODAL);
        modal_dialog.initOwner(stage);
        Scene scene = new Scene(root, 200, 300);

        AboutController controller = (AboutController) fl.getController();
        controller.setStage(modal_dialog);
        modal_dialog.setScene(scene);
        modal_dialog.show();
    }


}
