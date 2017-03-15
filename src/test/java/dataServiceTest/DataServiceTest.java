package dataServiceTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.model.Address;
import pl.sdacademy.model.Company;
import pl.sdacademy.model.StreetPrefix;
import pl.sdacademy.model.User;
import pl.sdacademy.service.DataService;

import java.util.List;


public class DataServiceTest {

//    z zalozenia nie robi sie testow na plikach, to klasa dla praktyki i cwiczen z testami
//    test powinien byc niezalezny od wszystkiego

    private DataService dataService;
    private String xmlUser = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>";
    private User userFromLoad;
    private User userXML;
    private Company company;

    public DataServiceTest() {
    }

//    metoda tworzaca potrzebne elementy
//    before - wykonaj przed kazdym testem

    @Before
    public void setUp() throws Exception {
        dataService = new DataService();
        userXML = new User("kowalski", "abc123");

        company = new Company();
        company.setName("Biedronka");
        company.setAddress(new Address("Baraniaka", "13", "1", "66-666", "Poznan", "Poland", StreetPrefix.STREET));
        company.setNip("123456789");
//        company.setRegon("987654321");
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

    @Test
    public void printCompanyInfo() {

//        zwraca liste stringow, wiec tworzymy obiekt liste stringow

        List<String> companyInfo = dataService.printCompanyInfo(company);

//        sprawdzamy, czy na liscie jest biedronka
//        Assert.assertTrue(companyInfo.get(0).equals("Biedronka"));

//        zmienna boolean

        boolean resultAssert = true;

//        za-ampersenduj do tego co masz cos jeszcze
//        zeby result byl prawda result musi byc prawda i kolejne tez musza byc prawda
//        mozna zrobic sout pod kazdym, zeby sprawdzic co jest zle

        resultAssert &= companyInfo.get(0).equals("Biedronka");
        System.out.println("resultAssert " + resultAssert);
        resultAssert &= companyInfo.get(1).equals("ul. Baraniaka 13/1\n66-666 Poznan");
        System.out.println("resultAssert " + resultAssert);
        resultAssert &= companyInfo.get(2).equals("123456789");
        System.out.println("resultAssert " + resultAssert);

        for (String line : companyInfo) {
            System.out.println(line);
        }

        Assert.assertTrue(resultAssert);
    }
}
