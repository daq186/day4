package com.ferreterias.day4.repository;


import com.ferreterias.day4.model.Email;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmailRepository extends CrudRepository<Email, Integer> {



}

