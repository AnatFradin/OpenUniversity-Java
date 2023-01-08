/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ou.maman14_q2_1;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author anatfradin
 */
public class CalendarController implements Initializable {

    @FXML
    private ChoiceBox<Integer> yearDropBox;
    @FXML
    private ChoiceBox<Integer> monthDropBox;
    @FXML
    private GridPane calendarPane;

    private ObservableList year_options = FXCollections.observableArrayList();
    private ObservableList month_options = FXCollections.observableArrayList();
    private Calendar calendar = Calendar.getInstance();
    private int[][] daysMatrix = new int[6][7];
    
    @FXML
    private Button Go;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createOptionsView();

    }

    private void createOptionsView() {
        Helper.createOptionsView(year_options, 2000, 2050);
        yearDropBox.setItems(year_options);
        yearDropBox.setValue(calendar.get(Calendar.YEAR));

        Helper.createOptionsView(month_options, 1, 13);
        monthDropBox.setItems(month_options);
        monthDropBox.setValue(calendar.get(Calendar.MONTH) + 1);

        generateMonth(yearDropBox.getValue(), monthDropBox.getValue());
    }

    private void generateMonth(Integer selected_year, Integer selected_month) {
        fillDaysMatrix(selected_year, selected_month);
        updateDatesTable();
    }

    private void fillDaysMatrix(Integer selected_year, Integer selected_month) {
        YearMonth yearMonthObject = YearMonth.of(selected_year, selected_month);
        int daysInMonth = yearMonthObject.lengthOfMonth();

        calendar.set(selected_month - 1, selected_year, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int dayIndex = 1;
        int dayNumber = 1;
        for (int[] array : daysMatrix) {
            for (int i = 0; i < array.length; i++) {
                if (dayIndex < dayOfWeek) {
                    array[i] = 0; // fill "0" in cells after last day of month
                    dayIndex++;
                } else if (dayNumber <= daysInMonth) {
                    array[i] = dayNumber++;
                } else {
                    array[i] = 0; // fill "0" in cells before 1st day of month
                }

            }
        }
    }

    private void updateDatesTable() {
        String dayNum;
        for (Node node : calendarPane.getChildren()) {
            if (node instanceof Button) {
                int i = GridPane.getRowIndex(node);
                int j = GridPane.getColumnIndex(node);
                 ((Button) node).setVisible(true);
                if (daysMatrix[i - 1][j - 1] == 0) {
                    dayNum = " ";
                    ((Button) node).setVisible(false);
                } else {
                    dayNum = String.valueOf(daysMatrix[i - 1][j - 1]);
                }
                ((Button) node).textProperty().set(dayNum);
            }
        }

    }

    @FXML
    private void GoPressed(ActionEvent event) {
        generateMonth(yearDropBox.getValue(), monthDropBox.getValue());
    }

    @FXML
    private void onPressed(ActionEvent event) {
        System.out.println("Pressed Button " + event.toString());
        Button x = (Button) event.getSource();

        for (Node node : calendarPane.getChildren()) {
            if (node instanceof Button) {
                Button btn = ((Button) node);
                if (btn.equals(x)) {
                    int i = GridPane.getRowIndex(node);
                    int j = GridPane.getColumnIndex(node);
                    int day = daysMatrix[i - 1][j - 1];
                    showDayDetails(day);
                    break;
                }
            }
            
        }
    }

    private void showDayDetails(int day) {

        LocalDate date = LocalDate.of(yearDropBox.getValue(), monthDropBox.getValue(), day);
        ArrayList<String> meetings = MeetingsDB.getAllMeetingsForDate(date);

        Alert alert = new Alert(AlertType.NONE);

        alert.setTitle("Meetings");
        alert.setHeaderText("Day " + date.toString() + " Details");
        StringBuilder meeting_details = new StringBuilder();
        if (meetings != null) {
            for (String m : meetings) {
                meeting_details.append(m);
                meeting_details.append("\n");
            }
        } else {
            meeting_details.append("You have no meetngs yet...");
            meeting_details.append("\n");
        }
        alert.setContentText(meeting_details.toString());

        ButtonType addNewMeeting = new ButtonType("Add New Meeting");
        ButtonType buttonTypeCancel = new ButtonType("Close", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(addNewMeeting, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == addNewMeeting) {
            System.out.println("Add New Meeting");
            String newMeetingDetails = getMeetingDetailsFromUser();
            MeetingsDB.addNewMeeting(date, newMeetingDetails);
        } else if (result.get() == buttonTypeCancel) {
            System.out.println("Close");
        }
    }

    private String getMeetingDetailsFromUser() {

        TextInputDialog dialog = new TextInputDialog("New Meeting");
        dialog.setTitle("New Meeting");
        dialog.setHeaderText("Create New Meeting");
        dialog.setContentText("Enter Meeting details:");

        Optional<String> result = dialog.showAndWait();
        return result.get();
    }

}
