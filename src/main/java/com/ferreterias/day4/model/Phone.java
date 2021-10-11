package com.ferreterias.day4.model;


import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_phone;
    private int phones;

    public int getId_phone() {
        return id_phone;
    }

    public void setId_phone(int id_phone) {
        this.id_phone = id_phone;
    }

    public int getPhones() {return phones;}

    public void setPhones(int phones) {
        this.phones = phones;
    }
}
