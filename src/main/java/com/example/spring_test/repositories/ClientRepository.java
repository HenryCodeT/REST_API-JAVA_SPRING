package com.example.spring_test.repositories;

import com.example.spring_test.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {
    List<Client> findAll();
}
