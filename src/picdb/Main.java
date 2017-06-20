package picdb;
	
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application implements BIF.SWE2.interfaces.Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Main.fxml"));
			Parent root = loader.load();
			primaryStage.setTitle("PicDB");
			Scene scene = new Scene(root, 650, 450);
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setMinWidth(650);
			primaryStage.setMinHeight(450);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void helloWorld() {
		// Do nothing, this will test the junit test setup		
	}
}
