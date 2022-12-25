/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ou.maman14_q2_1;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author anatfradin
 */
public class PrimaryController implements Initializable {

    private ObservableList options = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<?> YearDropBox;

    /**
     * Initializes the controller class.
     */
    private void createOptionsView() {
        Helper.createOptionsView(options,2000,2050); 
        YearDropBox.setItems(options);
    }    

    @FXML
    private void OnOpen(MouseEvent event) {
        
    }

    @FXML
    private void OnClosed(DragEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createOptionsView();
    }

    
    
}
