package pl.sdacademy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pl.sdacademy.model.Address;
import pl.sdacademy.model.Company;
import pl.sdacademy.model.StreetPrefix;
import pl.sdacademy.pdf.PdfFactory;
import pl.sdacademy.service.DataService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompanyCreateController extends Controller {

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
    Company addCompanyOnAction() {
        return bindToModelCompany();
    }

    private Company bindToModelCompany() {
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

        DataService dataService = new DataService();

//        jak metoda zwraca void nie mozemy uzywac sout

        dataService.printOutCompanyInfo(company);
        return company;
    }

    @FXML
    void initialize() {
        ToggleGroup group = new ToggleGroup();
        streetRadio.setToggleGroup(group);
        squereRadio.setToggleGroup(group);
        avenueRadio.setToggleGroup(group);

//        validacja - odniesienie do kodu pocztowego
//        listener - czeka na zdarzenie, do sterowania aktywnoscia pola

//        validate();

    }

    private void validate() {

//            regex - wyrazenia regularne, daja mozliwosc ograniczenia wpisania wartosci
//            dzieki nim walidacja na dane pole
//        Pattern - wzor

        Pattern zipPattern = Pattern.compile("(^\\d{2}-\\d{3}$)");
        Matcher zipMatcher = zipPattern.matcher(postalCodeField.getText());
        if (zipMatcher.find()) {
            String zip = zipMatcher.group(1);
            showConfirmationAllert("Postal code is correct");
        } else {
            showErrorAlert("Wrong postal code!");

        }
    }

//    dotyczy przycisku tworzacego pdf

    @FXML
    void createPDFOnAction(ActionEvent event) {

        PdfFactory pdfFactory = new PdfFactory();
        pdfFactory.createPdfFromSceneBuilder(addCompanyOnAction());
    }

    @FXML
    void validateOnAction(ActionEvent event) {
        validate();
    }
}
