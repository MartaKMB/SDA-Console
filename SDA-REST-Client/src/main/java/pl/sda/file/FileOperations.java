package pl.sda.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

    public static void main(String[] args) throws IOException {

        String message = "Hello World";
        File file = new File("C:\\Users\\RENT\\Desktop\\test.txt");

//        zapisywanie do pliku

//        exampleWriteToFile(message, file);

//        odczytywanie z pliku
//        czyta tylko pierwsza linijke

//        exampleReadFromFile(file);

//        dzielenie wyrazow po spacji, czyta tylko z jednej lini

//        readNamesInOneLine(file);

//        wiecej lini w pliku
//        przydatna metoda sc.hasNextLine()

//        readLinesFromFile(file);

//        czytamy z pliku i zapisujemy do listy, jako obiekty klasy User

        List<User> users = readUsersFromFile(file);
        users.forEach(e -> System.out.println(e));

//        dodajemy do pliku

        User user = new User();
        user.setFirstName("Adelajda");
        user.setLastName("Piekna");
        user.setAge(72);

        addUserToFile(user, file);

        users = readUsersFromFile(file);
        users.forEach(e -> System.out.println(e));

    }

    public static void addUserToFile(User user, File file) throws IOException {
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(user.toString());
        }
    }

//    zamiana na public, zeby uzyc w innym projekcie

    public static List<User> readUsersFromFile(File file) throws FileNotFoundException {

        List<User> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {

//                czytamy linie z pliku i dzielimy na tablice

                String nextLine = scanner.nextLine();
                String[] split = nextLine.split(" ");

//                tworzymy nowy obiekt

                User user = new User();
                user.setFirstName(split[0]);
                user.setLastName(split[1]);
                user.setAge(new Integer(split[2]));

//                dodajemy do listy

                users.add(user);
            }
        }
        return users;
    }

    private static void readLinesFromFile(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

    private static void readNamesInOneLine(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            String nextLine = scanner.nextLine();
            String[] split = nextLine.split(" ");
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]);
            }
        }
    }


    private static void exampleReadFromFile(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            String s = scanner.nextLine();
            System.out.println(s);
        }
    }

    private static void exampleWriteToFile(String message, File file) throws IOException {

//        blok try with resources - automatyczne zamkniecie pliku po zakonczeniu

        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(message);
        }
    }
}