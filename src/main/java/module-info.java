module com.horia.reminder.api.client {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.horia.reminder.api.client to javafx.fxml;
    exports com.horia.reminder.api.client;
}