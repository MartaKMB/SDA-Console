package pl.sdacademy.model;

public class Company {

    private int id;
    private Address address;
    private String nip;
    private String regon;
    private String name;

    public Company() {
    }

    public Company(int id, Address address, String nip, String regon, String name) {
        this.id = id;
        this.address = address;
        this.nip = nip;
        this.regon = regon;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", address=" + address +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
