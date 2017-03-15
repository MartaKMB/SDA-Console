package pl.sdacademy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.sdacademy.model.User;
import pl.sdacademy.service.UserService;

public class LoginController {

    @FXML
    private Button submit;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginTextField;

    @FXML
    void submitOnAction(ActionEvent event) {
        System.out.println(loginTextField.getText());
        System.out.println(passwordField.getText());

//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Hello!");
//        alert.show();

        /**
         * 1. powolac UserService
         * 2. utowrzyc User'a z polami pobranymi z fieldow
         * 3. korzystamy z metody authenticate
         * 4. if / out na ekran
         */

//        od Arka

        boolean flag = true;
        while (flag) {
            User user = new User(loginTextField.getText(), passwordField.getText());
            UserService userService = new UserService();

            if (userService.authenticate(user)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "You are log in");
                alert.show();
                flag = false;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Wrong data");
                alert.show();
                flag = false;
            }
        }

    }

}


