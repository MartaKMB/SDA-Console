package pl.sdacademy.application.main;

import javafx.application.Application;
import javafx.stage.Stage;
import lambdaPractice.MyClassTest;
import lambdaPractice.MyLambda;
import lambdaPractice.MyLamdaConstructor;
import pl.sdacademy.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        zaladowanie widoku uzycie fxml - robilismy to po  ustaleniu sceny
//        odwolujemy sie do resources poprzez this
//        powolanie loader'a
//        wazny "/" przed plikiem fxml

//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/LoginView.fxml"));

//        aplikacja formularz, zajecia 15.03

//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/CompanyCreateView.fxml"));

//        root to stackPane

//        podstawowy pane w javie fx
//        stage to scena, pane to wyswietlenie

//        StackPane stackPane = loader.load();

//        pan'a przylaczamy do sceny;
//        w nawiasie ponizej przy new Scene () : ctrl+p - zeby zobaczyc jakie argumenty
//        ctrl+spacja - podpowiedz

//        Scene scene = new Scene(stackPane);

//        rozszerzenie klasy application i nadpisuje metode start
//        podpinamy scene pod stage

//        primaryStage.setScene(scene);

//        ustawiamy tytul okna

//        primaryStage.setTitle("Login");

//        primaryStage.show();

//        praca w grupach

        /*
        DataService dataService = new DataService();
        XMLFactory<Bill> xmlFactory = new XMLFactory<>(Bill.class);

        String xbill = xmlFactory.objectToXML(bill);
        System.out.println(xbill);
        dataService.saveData(xbill);

        Bill bill2 = dataService.loadBillData();
        System.out.println("ccc");
        */

//        DataService dataService = new DataService("C:\\Users\\Miki\\Desktop\\data\\data2.dat");

//        DataService dataService = new DataService();

//        login();
//        initFile();
//        User userFromFile = dataService.loadData();

        /*
        PdfFactory pdfFactory = new PdfFactory();
//        pdfFactory.createPdf();

        Bill bill = new Bill();
        List<BillItem> billItems = createList();

        bill.addItem(billItems.get(1),3);
        bill.addItem(billItems.get(2),3);
//        bill.removeItem(billItems.get(2),1000);

        for(String e:dataService.printBillInfo(bill))
        {
            System.out.println(e);
        }

        pdfFactory.createPdfBill(bill);
        System.out.println("The end");
        */

        /*
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/BillFormView.fxml"));

        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My First JavaFX App - LOGOWANIE");

        primaryStage.show();
        */

    }

    /*
    public List<BillItem> createList(){
        List<BillItem> billitemList = new ArrayList<>();
        BillItem paczek = new BillItem();
        paczek.setItemName("Paczek");
        paczek.setAmount(1);
        paczek.setPrice(2.70);
        paczek.setDescription("Pączek z marmoladą");
        paczek.setTax(0.08);
        paczek.setCode("72235");
        billitemList.add(paczek);
        BillItem herbata = new BillItem();
        herbata.setItemName("Herbata");
        herbata.setAmount(1);
        herbata.setPrice(1.70);
        herbata.setDescription("Malinowa");
        herbata.setTax(0.22);
        herbata.setCode("62435");
        billitemList.add(herbata);
        BillItem ciachoZeSzpinakiem = new BillItem();
        ciachoZeSzpinakiem.setItemName("Ciastko ze szpinakiem");
        ciachoZeSzpinakiem.setAmount(1);
        ciachoZeSzpinakiem.setPrice(3.70);
        ciachoZeSzpinakiem.setDescription("Ciasto francuskie nadziewane szpinakiem");
        ciachoZeSzpinakiem.setTax(0.08);
        ciachoZeSzpinakiem.setCode("623445");
        billitemList.add(ciachoZeSzpinakiem);
        BillItem kawa = new BillItem();
        kawa.setItemName("Kawa");
        kawa.setAmount(1);
        kawa.setPrice(5.0);
        kawa.setDescription("Swiezo mielona kawa JAVA prosto z plantacji");
        kawa.setTax(0.22);
        kawa.setCode("97034567");
        billitemList.add(kawa);
        return billitemList;
    }
    */
}
