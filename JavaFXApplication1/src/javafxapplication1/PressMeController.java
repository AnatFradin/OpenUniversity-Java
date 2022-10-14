/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author anatfradin
 */
public class PressMeController implements Initializable {

    @FXML
    private Label counterLabel;
    private int counter = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void pressAction(ActionEvent event) {
        counter++;
        counterLabel.setText(String.valueOf(counter));
    }

    @FXML
    private void pressActionDown(ActionEvent event) {
        counter--;
        counterLabel.setText(String.valueOf(counter));
    }

}
