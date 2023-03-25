package com.api.vet.repository;

import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PetRepository  extends JpaRepository<Pet, Long> {
    List<Pet> findByClientId(Long clientId);
}
