package dataServiceTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.model.User;
import pl.sdacademy.service.DataService;


public class DataServiceTest {

//    z zalozenia nie robi sie testow na plikach, to klasa dla praktyki i cwiczen z testami
//    test powinien byc niezalezny od wszystkiego

    private DataService dataService;
    private String xmlUser = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>";
    private User userFromLoad;
    private User userXML;

    public DataServiceTest() {
    }

//    metoda tworzaca potrzebne elementy
//    before - wykonaj przed kazdym testem

    @Before
    public void setUp() throws Exception {
        dataService = new DataService();
        userXML = new User("kowalski", "abc123");
    }

    public void loadData() {
        userFromLoad = dataService.loadData();
    }

    public void saveData() {
        dataService.saveData(xmlUser);
    }

//    mozna by tu uzyc XMLfactory, ale nie robimy tego poniewaz nie testujemy XMLfactory

    @Test
    public void saveAndLoadData() {
        saveData();
        loadData();

//        assertTrue - prawda jezeli w nawiasie jest prawda

        Assert.assertTrue(userFromLoad.equals(userXML));
    }
}
