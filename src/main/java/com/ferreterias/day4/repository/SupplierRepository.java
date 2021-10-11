package com.ferreterias.day4.repository;


import com.ferreterias.day4.model.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {

    @Query("from Supplier where name1 like %:name1%")
    Iterable<Supplier> getSupplierBySupplierLike(@Param("name1") String name1);

}

