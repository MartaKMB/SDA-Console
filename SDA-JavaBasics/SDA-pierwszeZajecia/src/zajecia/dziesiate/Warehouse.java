package zajecia.dziesiate;

import java.util.HashMap;

public class Warehouse {
    private HashMap<Product, Integer> warehouse;

    public Warehouse(HashMap<Product, Integer> warehouse) {
        this.warehouse = warehouse;
    }

    public boolean hasAmount(Product product, Integer amount) {
        boolean returnValue = false;
//        sprawdzamy, czy mamy produkt:
        if (warehouse.containsKey(product)) {
            Integer amountInWarehouse = warehouse.get(product);
//         jezeli ilosc w magazynie jest wieksza od ilosci zamowionej przez klienta:
            returnValue = amountInWarehouse >= amount;
        }
        return returnValue;
    }

    public void add(Product product, int amount) {
        if (warehouse.containsKey(product)) {
            Integer amountInWarehouse = warehouse.get(product);
            warehouse.put(product, amountInWarehouse + amount);
        } else {
            warehouse.put(product, amount);
        }
    }

    public HashMap<Product, Integer> get(Product product, int amount) {
        if (!hasAmount(product, amount)) {
            System.out.println("Out of stock");
//            zwraca pusta mape i nie ma wyjatku, jak przy return null
            return new HashMap<>();
        }
        Integer amountInWarehouse = warehouse.get(product);
        warehouse.put(product, amountInWarehouse - amount);

        HashMap<Product, Integer> products = new HashMap<>();
        products.put(product, amount);
        return products;
    }
}
