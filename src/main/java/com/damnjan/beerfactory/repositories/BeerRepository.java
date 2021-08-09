package com.damnjan.beerfactory.repositories;

import com.damnjan.beerfactory.entities.BeerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<BeerEntity, Long> {
}
