package ou.maman_14_q2_2ou;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author anatfradin
 */
public class TestController implements Initializable {

    @FXML
    private GridPane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onPressed(ActionEvent event) {
        for (Node node : pane.getChildren()) {
            if (node instanceof Button) {
                int i = GridPane.getRowIndex(node);
                int j = GridPane.getColumnIndex(node);
                System.out.println(i + " " + j);
            }
        }
    }
    
}
