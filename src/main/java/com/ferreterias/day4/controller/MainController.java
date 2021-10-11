package com.ferreterias.day4.controller;

import com.ferreterias.day4.model.*;
import com.ferreterias.day4.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping(path = "ferreterias/proyecto")
public class MainController {
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private Type_productsRepository typeProductsRepository;
    @Autowired
    private ProductsRepository productsRepository;
    //==========================================GET===============================================
    // -----------------------email-----------------------------
    @GetMapping(path = "/email/all")
    public @ResponseBody
    Iterable<Email> getAllEmail() {
        return emailRepository.findAll();
    }
    //search table phone by id
    @GetMapping(path = "/email/{id}")
    public @ResponseBody
    Optional<Email> getEmailById(@PathVariable("id") int id) {
        return emailRepository.findById(id);
    }
    //-----------------------phone-----------------------------
    @GetMapping(path = "/phone/all")
    public @ResponseBody
    Iterable<Phone> getAllPhone() {
        return phoneRepository.findAll();
    }

    //search table phone by id
    @GetMapping(path = "/phone/{id}")
    public @ResponseBody
    Optional<Phone> getPhoneById(@PathVariable("id") int id) {
        return phoneRepository.findById(id);
    }
    //-----------------------supplier-------------------------
    @GetMapping(path = "/supplier/all")
    public @ResponseBody
    Iterable<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    //search table supplier by id
    @GetMapping(path = "/supplier/{id_supplier}")
    public @ResponseBody
    Optional<Supplier> getSupplierById(@PathVariable("id_supplier") int id_supplier) {
        return supplierRepository.findById(id_supplier);
    }
    //-----------------------type_products-------------------------
    @GetMapping(path = "/type_products/all")
    public @ResponseBody
    Iterable<Type_products> getAllTipe_products() {
        return typeProductsRepository.findAll();
    }
    //   search table supplier by id
    @GetMapping(path = "/type_products/{id_type_products}")
    public @ResponseBody
    Optional<Type_products> getType_productsById(@PathVariable("id_type_products") int id_type_products) {
        return typeProductsRepository.findById(id_type_products);
    }
    //-----------------------Products-------------------------
    @GetMapping(path = "/products/all")
    public @ResponseBody
    Iterable<Products> getAllProducts() {
        return productsRepository.findAll();
    }
//-----------------------Store-Product-------------------------
    @GetMapping(path = "/products/{id_products}")
    public @ResponseBody
    Optional<Products> getProductsById(@PathVariable("id_products") int id_products) {
        return productsRepository.findById(id_products);
    }
    //==========================================CUSTOM QUERIES===============================================
    @GetMapping(path = "/products/name_products/like/{name_products}")
    public @ResponseBody
    Iterable<Products> getProductsByNameLike(@PathVariable("name_products") String name_products) {
        return productsRepository.getProductsByProductsLike(name_products);
    }
    @GetMapping(path = "supplier/name1/like/{name1}")
    public @ResponseBody
    Iterable<Supplier> geSupplierByNameLike(@PathVariable("name1") String name1) {
        return  supplierRepository.getSupplierBySupplierLike(name1);
    }
    @GetMapping(path = "/products/store/{id_store}")
    public @ResponseBody
    Iterable<Products> getProductsBStore(@PathVariable("id_store") int id_store) {
        return productsRepository.getProductsByStore(id_store);
    }
    //==========================================POST===============================================
    @PostMapping(path = "/email/create", consumes = "application/json", produces = "application/json")
    public Email createEmail(@RequestBody Email newEmail) {
        return emailRepository.save(newEmail);
    }
    @PostMapping(path = "/phone/create", consumes = "application/json", produces = "application/json")
    public Phone createPhone(@RequestBody Phone newPhone) {
        return phoneRepository.save(newPhone);
    }
    @PostMapping(path = "/type_products/create", consumes = "application/json", produces = "application/json")
    public Type_products createType_products(@RequestBody Type_products newType_products) {
        return typeProductsRepository.save(newType_products);
    }
    @PostMapping(path = "/supplier/create", consumes = "application/json", produces = "application/json")
    public Supplier createSupplier(@RequestBody Supplier newSupplier) {
        return supplierRepository.save(newSupplier);
    }
    @PostMapping(path = "/products/create", consumes = "application/json", produces = "application/json")
    public Products createProducts(@RequestBody Products newProducts) {
        return productsRepository.save(newProducts);
    }
    //==========================================UPDATE===============================================
    @PutMapping(path = "/email/update")
    public Email updateEmail(@RequestBody Email newEmail) {
        return emailRepository.save(newEmail);
    }
    @PutMapping(path = "/phone/update")
    public Phone updatePhone(@RequestBody Phone newPhone) {
        return phoneRepository.save(newPhone);
    }
    @PutMapping(path = "/supplier/update")
    public Supplier updateSupplier(@RequestBody Supplier newSupplier) {
        return supplierRepository.save(newSupplier);
    }
    @PutMapping(path = "/supplier/{id}/update/email/{id_email}")
    public Supplier updateEmailSupplier(@PathVariable("id_email") int id_email, @PathVariable("id") int id) {
        Supplier supplier = supplierRepository.findById(id).get();
        Email email = emailRepository.findById(id_email).get();
        supplier.setEmail(email);
        supplierRepository.save(supplier);
        return supplier;
    }
    //==========================================DELETE===============================================
    @DeleteMapping(path = "/email/delete/{id_email}")
    public @ResponseBody
    Iterable<Email> deleteEmailById(@PathVariable("id_email") int id_email) {
        emailRepository.deleteById(id_email);
        return emailRepository.findAll();
    }
    @DeleteMapping(path = "/phone/delete/{id_phone}")
    public @ResponseBody
    Iterable<Phone> deletePhoneById(@PathVariable("id_phone") int id_phone) {
        phoneRepository.deleteById(id_phone);
        return phoneRepository.findAll();
    }
    @DeleteMapping(path = "/type_products/delete/{id_type_products}")
    public @ResponseBody
    Iterable<Type_products> deleteType_productsById(@PathVariable("id_type_products") int id_type_products) {
        typeProductsRepository.deleteById(id_type_products);
        return typeProductsRepository.findAll();
    }
}