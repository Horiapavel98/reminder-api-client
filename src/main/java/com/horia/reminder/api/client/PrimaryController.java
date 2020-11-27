package com.horia.reminder.api.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class PrimaryController {

    /* Reminder data */
    public TextField toField;
    public TextField titleField;
    public TextArea descriptionField;

    /* Time */
    public DatePicker dateField;
    public TextField timeField;

    /* Buttons */
    public Button sendButton;
    public ToggleButton localhostButton;

    /* Invalid flags */
    public Text invalidTo;
    public Text invalidTitle;
    public Text invalidDescription;
    public Text invalidTimestamp;

        @FXML
        public void initialize() {
            invalidTo.setText("");
            invalidTitle.setText("");
            invalidDescription.setText("");
            invalidTimestamp.setText("");

            sendButton.setDisable(true);
        }

    @FXML
    public void localhostButtonSet(ActionEvent actionEvent) {
        if (!localhostButton.isSelected()) {
            sendButton.setDisable(true);
        } else {
            sendButton.setDisable(false);
        }
    }

    @FXML
    public void sendButtonClick(ActionEvent actionEvent) {

        if (FieldValidator.validatePhoneField(toField.getText())) {
            invalidTo.setText("Correct!");
            invalidTo.setFill(Color.GREEN);
        } else {
            invalidTo.setText("Invalid");
            invalidTo.setFill(Color.RED);
        }

        if (FieldValidator.validateTitleField(titleField.getText())) {
            invalidTitle.setText("Correct!");
            invalidTitle.setFill(Color.GREEN);
        } else {
            invalidTitle.setText("Invalid");
            invalidTitle.setFill(Color.RED);
        }

        if (FieldValidator.validateDescriptionField(descriptionField.getText())) {
            invalidDescription.setText("Correct!");
            invalidDescription.setFill(Color.GREEN);
        } else {
            invalidDescription.setText("Invalid");
            invalidDescription.setFill(Color.RED);
        }

        if (FieldValidator.validateDueDateAndTime(dateField.getValue(), timeField.getText())) {
            invalidTimestamp.setText("Correct!");
            invalidTimestamp.setFill(Color.GREEN);
        }else {
            invalidTimestamp.setText("Invalid");
            invalidTimestamp.setFill(Color.RED);
        }
    }
}
