/**
 * 
 */
package comp3111.webscraper;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Button;
import java.util.List;
import java.util.Vector;
import java.util.Iterator;


/**
 * 
 * @author kevinw
 *
 *
 * Controller class that manage GUI interaction. Please see document about JavaFX for details.
 * 
 */
public class Controller {

    @FXML 
    private Label labelCount; 

    @FXML 
    private Label labelPrice; 

    @FXML 
    private Hyperlink labelMin; 

    @FXML 
    private Hyperlink labelLatest; 

    @FXML
    private TextField textFieldKeyword;
    
    @FXML
    private TextArea textAreaConsole;
    
    @FXML
    private Button buttonRefine;
    private List<Item> currentResult;
    private List<Item> lastResult;
    private String currentKeyword;
    private String lastKeyword;
    private WebScraper scraper;
    
    /**
     * Default controller
     */
    public Controller() {
    	scraper = new WebScraper();
    }

    /**
     * Default initializer. It is empty.
     */
    @FXML
    private void initialize() {
    	buttonRefine.setDisable(true);
    	lastKeyword = "";
    	currentResult = new Vector<Item>();
    	currentKeyword = "";
    }
    
    /**
     * Called when the search button is pressed.
     */
    @FXML
    private void actionSearch() {
    	lastResult = currentResult;
    	lastKeyword = currentKeyword;
    	System.out.println("actionSearch: " + textFieldKeyword.getText());
    	List<Item> result = scraper.scrape(textFieldKeyword.getText());
    	currentResult = result;
    	currentKeyword = textFieldKeyword.getText();
    	String output = "";
    	for (Item item : result) {
    		output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrl() + "\n";
    	}
    	textAreaConsole.setText(output);
    	if(result.size() != 0) {
    		buttonRefine.setDisable(false);
    	}
    	else {
    		buttonRefine.setDisable(true);
    	}
    }
    
    /**
     * Called when the new button is pressed. Very dummy action - print something in the command prompt.
     */
    @FXML
    private void actionNew() {
    	System.out.println("actionNew");
    }
    
    @FXML
    private void actionRefine() {
    	Iterator<Item> i = currentResult.iterator();
    	while (i.hasNext()) {
    		Item item = i.next();
    		if(!(item.getTitle().toLowerCase().contains(textFieldKeyword.getText().toLowerCase()))) {
    			i.remove();
    		}
    	}
    	String output = "";
    	for (Item item : currentResult) {
    		output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrl() + "\n";
    	}
    	textAreaConsole.setText(output);
    	System.out.println("actionRefine: " + textFieldKeyword.getText());
    	buttonRefine.setDisable(true);
    }

}

