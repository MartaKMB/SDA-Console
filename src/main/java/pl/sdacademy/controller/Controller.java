package pl.sdacademy.controller;

import javafx.scene.control.Alert;

public class Controller {

    protected void showErrorAlert(String message) {
        showAlert(Alert.AlertType.ERROR, message);
    }

    protected void showConfirmationAllert (String message) {
        showAlert(Alert.AlertType.CONFIRMATION, message);
    }

    private void showAlert (Alert.AlertType alertType, String message) {

//        tworzymy alerta i od razy stawiamy

        new Alert(alertType, message).show();
    }
}
