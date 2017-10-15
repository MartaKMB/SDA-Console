package zajecia.dziesiate;

import zajecia.dziewiate.Address;
import zajecia.dziewiate.User;

import java.util.HashMap;

/**
 * Created by RENT on 2017-02-13.
 */
public class Zajecia10 {
    public static void main(String[] args) {

        Product carrot = new Product("Carrot", "vegetable", 1.99);
        Product orange = new Product("Orange", "sweet citrus", 3.89);
        Product mango = new Product ("Mango", "best fruit!", 14.99);

        HashMap<Product, Integer> products = new HashMap<>();
        products.put(mango, 500);
        products.put(orange, 1500);
        products.put(carrot, 100);

        Warehouse warehouse = new Warehouse(products);

//        pobranie elementow z magazynu:
        HashMap<Product, Integer> productIntegerHashMap = warehouse.get(mango, 600);

        System.out.println();

        /*
        Client client1 = new Client("Tomasz", "Nowak");
        Client client2 = new Client("Jeremi", "Wisnia");

        Address address3Client = new Address("Kwiatowa", 5, "66-777", "Poznan", "Poland");

        Client client3 = new Client("Aleksandra", "Tulipan", "555555", address3Client);
        */

        /*
        Order order = new Order(client3, products);
        System.out.println("Total price for client: " + client3 +" is: " + order.getPrice());
        */

    }

//    wstep do map
    public static void MapDemo() {
        HashMap<String, User> map = new HashMap<>();
        map.put("123", new User("Jan", "Nowak", "abbccdd"));
        map.put("345", new User("Anna", "Tomaszewska", "nnnbbb"));

//        lambda
        map.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v);
            System.out.println();
        });
        /*
        User user = map.get("123");
        System.out.println(user);
        */
    }
}
