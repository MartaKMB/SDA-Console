package pl.sdacademy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import pl.sdacademy.model.Address;
import pl.sdacademy.model.Company;
import pl.sdacademy.model.StreetPrefix;

public class CompanyCreateController {

    @FXML
    private TextField streetField;

    @FXML
    private TextField houseNumberField;

    @FXML
    private TextField cityField;

    @FXML
    private RadioButton streetRadio;

    @FXML
    private TextField postalCodeField;

    @FXML
    private Button addCompanyButton;

    @FXML
    private TextField flatNumberField;

    @FXML
    private TextField nameField;

    @FXML
    private RadioButton avenueRadio;

    @FXML
    private TextField nipField;

    @FXML
    private RadioButton squereRadio;
    private StreetPrefix streetPrefix;

    @FXML
    void choosePrefixOnAction(ActionEvent event) {

//        event zdarzenia - akcje podczas jakiejs czynnosci, np. przycisk
//        jedna metoda do 3 button'ow

//        spr. czy mamy radio button - instanceof, jezeli to prawda to dzialanie

        if (event.getSource() instanceof RadioButton) {

//            3 mozliwosci
//            jezeli klikniesz jakikolwiek odznacz wszystkie i zaznacz wybrana
//            rzutowanie typow, wskazujemy co chcemy, aby sie do niego dostac

            RadioButton currentPrefixRadioButton = (RadioButton) event.getSource();
            String buttonName = currentPrefixRadioButton.getText();

            switch (buttonName) {
                case "ulica":
                    streetPrefix = StreetPrefix.STREET;
                    break;
                case "plac":
                    streetPrefix = StreetPrefix.SQUERE;
                    break;
                case "aleja":
                    streetPrefix = StreetPrefix.AVENUE;
                    break;
            }



        }
    }

    @FXML
    void addCompanyOnAction(ActionEvent event) {
        Company company = new Company();

        company.setName(nameField.getText());

        Address address = new Address();
        address.setStreetPrefix(streetPrefix);
        address.setStreetName(streetField.getText());
        address.setHouseNumber(houseNumberField.getText());
        address.setFlatNumber(flatNumberField.getText());
        address.setPostalCode(postalCodeField.getText());
        address.setCity(cityField.getText());

        company.setAddress(address);
        company.setNip(nipField.getText());

        System.out.println(company);

    }

    @FXML
    void initialize() {
        ToggleGroup group = new ToggleGroup();
        streetRadio.setToggleGroup(group);
        squereRadio.setToggleGroup(group);
        avenueRadio.setToggleGroup(group);
    }
}
