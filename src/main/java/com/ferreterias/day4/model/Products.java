package com.ferreterias.day4.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_products;
    private String name_products;
    private double price;
    private String descr;
    private Date elaboration_date;
    private Date expiration_date;
    private String units;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_type_products", referencedColumnName = "id_type_products")
    private Type_products id_type_products;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "products_supplier",
            joinColumns = @JoinColumn(name ="id_products" ),
            inverseJoinColumns = @JoinColumn(name = "id_supplier"))
    private Set<Supplier> productsSupplier;

    public int getId_products() {
        return id_products;
    }

    public void setId_products(int id_products) {
        this.id_products = id_products;
    }

    public String getName_products() {
        return name_products;
    }

    public void setName_products(String name_products) {
        this.name_products = name_products;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getElaboration_date() {
        return elaboration_date;
    }

    public void setElaboration_date(Date elaboration_date) {
        this.elaboration_date = elaboration_date;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Type_products getId_type_products() {
        return id_type_products;
    }

    public void setId_type_products(Type_products id_type_products) {
        this.id_type_products = id_type_products;
    }

    public Set<Supplier> getProductsSupplier() {
        return productsSupplier;
    }

    public void setProductsSupplier(Set<Supplier> productsSupplier) {
        this.productsSupplier = productsSupplier;
    }
}
