package br.com.crudapplication.model;

public class Product {

    private long id;
    private String name;
    private double price;
    private int amount;
    private ProductFactory factory;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ProductFactory getFactory() {
        return factory;
    }

    public void setFactory(ProductFactory factory) {
        this.factory = factory;
    }

    public Product() {
    }
}
