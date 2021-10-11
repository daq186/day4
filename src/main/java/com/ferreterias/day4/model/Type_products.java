package com.ferreterias.day4.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Type_products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type_products;
    private String name_type_products;

    public int getId_type_products() {
        return id_type_products;
    }

    public void setId_type_products(int id_type_products) {
        this.id_type_products = id_type_products;
    }

    public String getName_type_products() {
        return name_type_products;
    }

    public void setName_type_products(String name_type_products) {
        this.name_type_products = name_type_products;
    }
}
