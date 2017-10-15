package zajecia.dziesiate;

import java.util.HashMap;

public class Store {
    private Warehouse warehouse;

    public Store(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Order createOrder(Client client) {
        return new Order(client, new HashMap<>());
    }

    public void addToBasket (Order order, Product product, int amount) {
        if (warehouse.hasAmount(product, amount)) {
            order.addToOrder(product, amount);
        } else {
            System.out.println("Sorry");
        }
    }

    public void finish(Order order) {
        HashMap<Product, Integer> basket = order.getBasket();
        basket.forEach((productInBasket, amountOfProductInBasket) -> {
//            blad, bo jak klient w 1szym kroku doda 200, w drugim 1000 przekroczy zasob, a cene policzy za calosc
            warehouse.get(productInBasket, amountOfProductInBasket);
        });
        System.out.println(order.finish());
    }
}
