package pl.sdacademy.controller;

import java.awt.event.ActionEvent;

        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextArea;
        import javafx.scene.control.TextField;

public class BillItemController extends Controller {

    @FXML
    private TextField productTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField codeTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private Button addProductButton;

    @FXML
    private TextField taxTextField;

    @FXML
    private TextArea descriptionTextField;

    @FXML
    void addProductController(ActionEvent event) {
    }

}

