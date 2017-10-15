package zajecia.dziesiate;

import java.util.*;

public class Order {
    private HashMap<Product, Integer> basket;
    private Client client;
    private Date date;
    private double price;

    public Order(Client client, HashMap<Product, Integer> basket) {
        this.client = client;
        this.basket = basket;
        this.date = new Date();
        this.price = countPrice();
    }
    
    public Order addToOrder(Product product, int amount) {
        if (basket.containsKey(product)) {
            Integer amountInBasket = basket.get(product);
            basket.put(amountInBasket + amount);
        } else {
            basket.put(product, amount);
        }
//        to zamowienie na rzecz ktorego wywolalismy ta metode
        return this;
    }

//    metoda konczaca
    public double finish() {
        return countPrice();
    }

//    bez static, bo uzywane tylko na rzecz obiektu
    private double countPrice() {
//        Map.Entry to pojedyncza para, entrySet rozdziela i tworzy klucz+wartosc, przechodzimy po kazdym elemencie
        Set<Map.Entry<Product, Integer>> entries = basket.entrySet();
//        iterator przechodzi po kazdym elemencie
        Iterator<Map.Entry<Product, Integer>> iterator = entries.iterator();
        double totalPrice = 0;
//        tak dlugo jak mamy elementy - pobieramy je
        while (iterator.hasNext()) {
            Map.Entry<Product, Integer> next = iterator.next();
//        pobieramy cene i ilosc
            Product product = next.getKey();
            Integer amount = next.getValue();
            double price = product.getPrice();
            totalPrice += amount * price;
        }
        return totalPrice;
    }

    public HashMap<Product, Integer> getBasket() {
        return basket;
    }

    public Client getClient() {
        return client;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }
}
