package com.example.kigalicleaniliness.repository;

import com.example.kigalicleaniliness.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel,Integer> {

}
