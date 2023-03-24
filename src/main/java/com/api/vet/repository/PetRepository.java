package com.api.vet.repository;

import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository  extends JpaRepository<Pet, Long> {
}
