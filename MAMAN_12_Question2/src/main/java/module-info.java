module ou.maman_12_question2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ou.maman_12_question2 to javafx.fxml;
    exports ou.maman_12_question2;
}
