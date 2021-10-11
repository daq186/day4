package com.ferreterias.day4.repository;


import com.ferreterias.day4.model.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductsRepository extends CrudRepository<Products, Integer> {

    @Query("from Products where name_products like %:name_products%")
    Iterable<Products> getProductsByProductsLike(@Param("name_products") String name_products);

  //  @Query("from Products where id_products like %:id_products%")
  //  Iterable<Products> getProductsByIdProductsLike(@Param("id_products") int id_products);


    @Query(value = "select p.* from products as p where p.id_products in " +
            "(select s.id_products from store_product as s where s.id_store = :id_store)", nativeQuery = true)
    Iterable<Products> getProductsByStore(@Param("id_store") int id_store);
}



