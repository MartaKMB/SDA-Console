package sda.finances;

import sda.finances.model.Expense;
import sda.finances.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Expense> expenses = init();

//        1. wyswietl wszystkie towary ktorych cena jednostkowa jest mniejsza od 3
//        dla kazdego expensa pobnieramy liste produktow i chcemy odfiltorwac elementy i wyswitelamy je
//        od razu forEach, bo mamy juz liste

        expenses.forEach(expense -> {
            expense.getProducts().stream()
                    .filter(product -> product.getUnitPrice() <= 3)
                    .forEach(product -> System.out.println(product));
        });

        System.out.println();

//        2. wyswietlic tylko produkty spozywcze, ktorych cena jednostkowa jest mniejsza od 3

        expenses.stream()
                .filter(expense -> expense.getType().equals("groceries"))
                .forEach(expense -> {
                    expense.getProducts().stream()
                            .filter(product -> product.getUnitPrice() <= 3)

//                            ponizej krotszy zapis

                            .forEach(System.out::println);
                });

        System.out.println();

//        3. wyswietlamy tylko banany + ile lacznie zaplacilicmy za banany

        double banana = expenses.stream()

//                zmapowanie na double i wyciagamy doubla z kazdego rachunku i sumujemy

                .mapToDouble(expense ->

//                        pobieramy wszystkie produkty

                                expense.getProducts()
                                        .stream()

//                                wybieramy banany

                                        .filter(product -> product.getName().equals("banana"))

//                                obliczamy koszt

                                        .mapToDouble(product -> product.getUnitPrice() * product.getAmount())
                                        .sum()
                )

//                po zrobieniu sumy z jednego rachunku, suma wszystkiego
//                po tym sum().var i przypisze nam to do double

                .sum();
        System.out.println(banana);

        System.out.println();

//        4. suma cen wszystkich produktow (nie int - w lambdach finalne, nie zmieniamy)

        double groceries = expenses.stream()
                .filter(expense -> expense.getType().equals("groceries"))

//                w tej klasie szukaj takiej metody i jej uzyj, ponizej krotsza wersja

                .mapToDouble(Expense::getPrice)
                .sum();
        System.out.println(groceries);

        System.out.println();

//        5. produkty kupione przed 19 lutym

        expenses.stream()
                .filter(expense -> expense.getDate().isBefore(LocalDate.of(2017, 2, 19)))
                .forEach(expense -> expense.getProducts()
                        .forEach(product -> System.out.println(product)));

        System.out.println();


//        6. wyswietlic wydatki dla konkretnego dnia
//        (ilosc kupionych produktow, ilosc wydanych pieniedzy)

//        na koniec po sum().sout i mamy ponizsze

        System.out.println(expenses.stream()
                .filter(expense -> expense.getDate().isEqual(LocalDate.of(2017, 2, 21)))
                .mapToDouble(expense -> expense.getPrice())
                .sum());

//        6.1. Wyswietlic wydatki na piwo/potato konkretnego dnia

        System.out.println(expenses.stream()
                .filter(expense -> expense.getDate().isEqual(LocalDate.of(2017, 2, 21)))
                .mapToDouble(expense -> expense.getProducts()
                        .stream()
                        .filter(product -> product.getName().equals("potato"))
                        .mapToDouble(product -> product.getUnitPrice() + product.getAmount())
                        .sum())
                .sum());

        System.out.println();

//        7. zsumowac calkowita kwote wydana na produkty zaczynajace sie na p

        System.out.println(expenses.stream()
                .mapToDouble(expense -> expense.getProducts()
                        .stream()
                        .filter(product -> product.getName().startsWith("p"))
                        .mapToDouble(product -> product.getAmount() * product.getUnitPrice())
                        .sum())
                .sum());

        System.out.println();

//        8. zsumowac koszt produktow spozywczych, ktore kupilismy w parzystych ilosciach

        System.out.println(expenses.stream()
                .filter(expense -> expense.getProducts().equals("gorceries"))

                //                po wyciagnieciu produktow kazdy chcemy traktowac jako double

                .mapToDouble(expense -> expense.getProducts().stream()
                        .filter(product -> product.getAmount() % 2 == 0)
                        .mapToDouble(product -> product.getAmount() * product.getUnitPrice())
                        .sum())
                .sum());

        System.out.println();

//        9. z kazdego expensa wyswietlic produkt za ktorego zaplacilismy najwiecej
//        amount * unitPrice

        expenses.stream()

//                wyciagamy z kazdego expensa/rachunku najdrozszy produkt

                .map(expense -> expense.getProducts()
                        .stream()
                        .max((e1, e2) ->
                                (e1.getUnitPrice() * e1.getAmount()) >
                                        (e2.getAmount() * e2.getUnitPrice()) ? 1 : -1)

                        //                po obliczeniu get, ktory zwraca ta wartosc

                        .get())
                .forEach(product -> System.out.println(product));

        System.out.println();

//        10. wyswietl najdrozszy produkt z wszystkich expensow

        System.out.println(expenses.stream()
                .map(expense -> expense.getProducts()
                        .stream()
                        .max((e1, e2) ->
                                (e1.getUnitPrice() * e1.getAmount()) >
                                        (e2.getAmount() * e2.getUnitPrice()) ? 1 : -1)
                        .get())

                //                mamy liste/strumien najdrozszych produktow z kazdego paragonu, teraz ze wszystkich obliczamy maksa

                .max((e1, e2) ->
                        (e1.getUnitPrice() * e1.getAmount()) >
                                (e2.getAmount() * e2.getUnitPrice()) ? 1 : -1)
                .get());

        System.out.println();

    }

    private static List<Expense> init() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("banana", 5, 2));
        products.add(new Product("potato", 9, 3));
        products.add(new Product("orange", 15, 6));
        products.add(new Product("chips", 11, 1));

        Expense expense = new Expense("groceries", products);

        List<Product> products2 = new ArrayList<>();
        products2.add(new Product("paint", 1, 3));
        products2.add(new Product("hammer", 2, 5));
        products2.add(new Product("spike", 3, 25));

        Expense expense2 = new Expense("building", products2 /*, 2017, 2, 19*/);

        List<Product> products3 = new ArrayList<>();
        products3.add(new Product("vitamin c", 13, 2));
        products3.add(new Product("painkiller", 4, 9));
        products3.add(new Product("sirup", 1, 25));

        Expense expense3 = new Expense("medicine", products3, 2017, 2, 18);

        List<Product> products4 = new ArrayList<>();
        products4.add(new Product("banana", 13, 2));
        products4.add(new Product("hummus", 4, 15));
        products4.add(new Product("bread", 3, 5));

        Expense expense4 = new Expense("groceries", products4, 2017, 2, 17);

        return Arrays.asList(expense, expense2, expense3, expense4);
    }
}
