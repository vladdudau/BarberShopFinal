package com.unibuc.project.barbershop.repository;

import com.unibuc.project.barbershop.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HairstyleProductRepository extends JpaRepository<HairstyleProduct, Long> {
    Optional<HairstyleProduct> findByName(String name);
}
