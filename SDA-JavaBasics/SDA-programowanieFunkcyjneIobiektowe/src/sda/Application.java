package sda;

import sda.workers.AbstractEmployee;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<AbstractEmployee> employeeList = new ArrayList<>();
        employeeList.add(new AbstractEmployee("Marta", "MB", 500, "GaSa"));
        employeeList.add(new AbstractEmployee("Szymon", "Nowak", 2000, "JAVA"));
        employeeList.add(new AbstractEmployee("Mariusz", "Bednarek", 3000, "PM"));
        employeeList.add(new AbstractEmployee("Karolina", "Fly", 5000, "JAVA"));
        employeeList.add(new AbstractEmployee("Jakub", "Kowalski", 6000, "driver"));

//        1. za pomoca filter wypisac tylko ludzi z dzialu java

        employeeList.stream()
                .filter(e -> e.getDepartment().equals("JAVA"))
                .forEach(e -> System.out.println(e));

        System.out.println();

//        2. za pomoca filter wypisac tylko kobiety

        employeeList.stream()
                .filter(e -> e.getFirstName().endsWith("a"))
                .forEach(e -> System.out.println(e));

        System.out.println();

//        3. za pomoca filter wypisac osoby zarabiajace powyzej 3000

        employeeList.stream()
                .filter(e -> e.getSalary() >= 3000)
                .forEach(e -> System.out.println(e));

        System.out.println();

//        4. za pomoca flter wypisac osoby z dzialu jaca zarabiajace powyzej 3000 (dwa osobne filtry)

        employeeList.stream()
                .filter(e -> e.getDepartment().equals("JAVA"))
                .filter(e -> e.getSalary() >= 3000)
                .forEach(e -> System.out.println(e));

        System.out.println();

//        5. za pomoca filter oraz collect zebrac wszystkie osoby pracujace w dziale java i zwrocic je jako osobna liste
//        za collecct(Collectors.toList()).var i dodaje naglowek List<>

        List<AbstractEmployee> javaEmployee = employeeList.stream()
                .filter(e -> e.getDepartment().equals("JAVA"))
                .collect(Collectors.toList());
        System.out.println(javaEmployee);

        System.out.println();

//         6. szukamy pracownikow po nazwisku

        employeeList.stream()
                .filter(e -> e.getLastName().equals("Nowak"))
                .forEach(e -> System.out.println(e));

        System.out.println();

//         7. szukamy pracownikow po nazwwisku startsWith

        employeeList.stream()
                .filter(e -> e.getLastName().startsWith("Now"))
                .forEach(e -> System.out.println(e));

        System.out.println();

//        8. dzielimy liste na mape ludzi dzie klucz to ich imie, a wartosc to AbstractEmployeee
//        pierwsza lambda 1) wybiera klucz 2) wartosc w kazdym elemencie
//        map.forEach - dzialania na mapie

        Map<String, AbstractEmployee> map = employeeList.stream()
                .collect(Collectors.toMap((e -> e.getFirstName()), e -> e));
        map.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println();

//        9. zwracamy liste Employee szukanej po imie + " " + nazwisko
        employeeList.stream()
                .filter(e -> (e.getFirstName() + " " + e.getLastName()).equals("Szymon Nowak"))
                .forEach(e -> System.out.println(e));

        System.out.println();

//        10. posortuj po salary > - rosnaca < malejac0

        employeeList.sort((e1, e2) ->
                e1.getSalary() > e2.getSalary() ? 1 :
                        e1.getSalary() == e2.getSalary() ? 0 : -1);
        employeeList.forEach(e -> System.out.println(e.getFirstName() + ": " + e.getSalary()));

        System.out.println();

//        11. wyswietl employee ktory zarabia najwiecej

        AbstractEmployee richestEmployee = employeeList.stream()
                .max((e1, e2) -> e1.getSalary() > e2.getSalary() ? 1 : -1)
                .get();
        System.out.println(richestEmployee);

        System.out.println();

        employeeList.sort((e1, e2) -> e1.getSalary() < e2.getSalary() ? 1 : -1);
        AbstractEmployee maxSalary = employeeList.get(0);
        System.out.println(maxSalary);

        System.out.println();

//        12. wyswietl emlpoyee ktory zarabia najmniej

        AbstractEmployee minSalary = employeeList.stream()
                .min((e1, e2) -> e1.getSalary() > e2.getSalary() ? 1 : -1)
                .get();
        System.out.println(minSalary);

        System.out.println();

        Map<String, List<AbstractEmployee>> map1 = listToMap(employeeList);
        List<AbstractEmployee> tmpList = new ArrayList<>();
        map1.entrySet().stream()
                .forEach(e -> {

//                    getValue - "splaszczona" lista

                    List<AbstractEmployee> value = e.getValue();
                    value.stream()
                            .filter(e1 -> e1.getSalary() >= 3000)
                            .forEach(e1 -> tmpList.add(e1));
                });
        System.out.println(tmpList);
    }

    public static Map<String, List<AbstractEmployee>> listToMap(List<AbstractEmployee> employees) {
        Map<String, List<AbstractEmployee>> map = new HashMap<>();

        /*
        inny zapis ponizszego:
        for (int i = 0; i < emlpoyees.getSize(); i++ ) {
            AbstractEmployee employee = employees.get(i);
        }
         */

        for (AbstractEmployee employee : employees) {
            if (map.containsKey(employee.getDepartment())) {
                List<AbstractEmployee> listOfEmployees = map.get(employee.getDepartment());
                listOfEmployees.add(employee);
            } else {
                ArrayList<AbstractEmployee> listOfEmployees = new ArrayList<>();
                listOfEmployees.add(employee);
                map.put(employee.getDepartment(), listOfEmployees);
            }
        }
        return map;
    }
}
