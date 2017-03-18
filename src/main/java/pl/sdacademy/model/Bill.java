package pl.sdacademy.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Bill {
    private UUID id;
    private List<String> listOfItems;
    private Date date;
    private Double price;
    private Double tax;
    private Payment payment;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<String> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<String> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
