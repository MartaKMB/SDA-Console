package pl.sdaPostman;

import org.codehaus.jackson.map.ObjectMapper;
import pl.sda.messages.CreateUserRequest;
import pl.sda.messages.CreateUserResponse;
import pl.sda.messages.GetUserResponse;
import pl.sda.utils.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String URL = "http://localhost:8081/sda-json/json";

    public static void main(String[] args) throws IOException {

//        nieskonczona petla pobierajaca dane

        List<String> userIds = new ArrayList<>();

        while (true) {

            Scanner sc = new Scanner(System.in);

            System.out.println("1. Add user");
            System.out.println("2. Print users id");
            System.out.println("3. Print users data");

            String choiceRaw = sc.nextLine();
            Integer choice = Integer.parseInt(choiceRaw);

            switch (choice) {
                case 1:
                    CreateUserRequest createUserRequest = new CreateUserRequest();

                    System.out.println("Please enter your login: ");
                    createUserRequest.setLogin(sc.nextLine());

                    System.out.println("Please enter your name: ");
                    createUserRequest.setName(sc.nextLine());

                    System.out.println("Please enter your mail: ");
                    createUserRequest.setMail(sc.nextLine());

                    ObjectMapper mapper = new ObjectMapper();

                    String request = mapper.writeValueAsString(createUserRequest);

                    String createUserResponse = Sender.createUser(URL, request);

                    CreateUserResponse response = mapper.readValue(createUserResponse, CreateUserResponse.class);

                    userIds.add(response.getId());

//                    System.out.println("Your id: " + response.getId());

                    break;

                case 2:
                    System.out.println(userIds.toString());
                    break;

                case 3:
                    List<String> getUserResponses = new ArrayList<>();
                    for (String id : userIds) {
                        getUserResponses.add(Sender.getUser(URL, id));
                    }
                    System.out.println(getUserResponses.toString());
                    break;

                default:
                    break;
            }
        }

//        poprzednie przygotowanie obiektu
//        String createUserRequest = "{\"name\":\"name\",\"login\":\"mkmb\",\"mail\":\"mkmb@sda.pl\"}";

//        komunikacja synchroniczna wysylamy req i otrzymujemy resp

    }
}
