package com.ferreterias.day4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_supplier;
    private String name1;
    private int CI_RUC;
    private String city;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_phone", referencedColumnName = "id_phone")
    private Phone phone;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_email", referencedColumnName = "id_email")
    private Email email;

    @JsonBackReference
    @ManyToMany(mappedBy = "productsSupplier")


    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public int getCI_RUC() {
        return CI_RUC;
    }

    public void setCI_RUC(int CI_RUC) {
        this.CI_RUC = CI_RUC;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
