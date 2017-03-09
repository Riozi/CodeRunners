package Vue;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private Button connecter;
    
    
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        boutonConnection(event);
        
    }

    private void boutonConnection(ActionEvent event) throws IOException {
        if(login.getText().equals("MOI")&&password.getText().equals("test")){
            Parent home_Page_parent = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
            Scene home_page_scene = new Scene(home_Page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
        
    }    
    
}