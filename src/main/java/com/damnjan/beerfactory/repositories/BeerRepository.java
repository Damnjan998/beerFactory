package com.damnjan.beerfactory.repositories;

import com.damnjan.beerfactory.entities.BeerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<BeerEntity, Long> {

    boolean existsByName(String name);

    Page<BeerEntity> findAll(Pageable pageable);
}
