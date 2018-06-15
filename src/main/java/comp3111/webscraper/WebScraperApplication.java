/**
 * 
 */
package comp3111.webscraper;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author kevinw
 * 
 * The entry point of the entire program. It is quite unlikely you need to change this file. But you can change it if you want :)
 * 
 * GUI
 * ---
 * 
 * If you are aiming at some very basic features, you might not even need to edit the GUI. But you are always encouraged to understand the
 * entire package and you are always allowed to change the base code to suit what you need. 
 * 
 * Your GUI is described in the file ui.fxml which is located in src/main/java/ui.fxml . To edit your GUI go straight to edit the ui.fxml.
 * I generate this ui.fxml by javafx builder (http://gluonhq.com/products/scene-builder/). You can learn how to use it with tips from 
 * this youtube video for a real fast bootstrap (https://www.youtube.com/watch?v=Z1W4E2d4Yxo). Or, alternatively try to understand the ui.fxml
 * and edit it with some try and error and google! 
 *
 * Entry Point
 * -----------
 * 
 * The program will starts with the function public static void main and it will eventually trigger the function public void start. What this
 * function will do is to load this ui.fxml into a GUI application. The ui.fxml has specified that "all event will be handled by the class - 
 * Controller". So you might want to move forward to look into your 
 *
 *
 */
public class WebScraperApplication extends Application {

    private static final String uiPath = "src/main/java/ui.fxml";
	
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
    	FXMLLoader loader = new FXMLLoader();
   		VBox root = (VBox) loader.load(new FileInputStream(uiPath));
   		Scene scene =  new Scene(root);
   		stage.setScene(scene);
   		stage.setTitle("WebScrapper");
   		stage.show();
    		

	}

	/**
	 * @param args
	 */
	public static void main(String arg[]) {
		Application.launch(arg);
	}


}