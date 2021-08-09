package com.damnjan.beerfactory.services;

import com.damnjan.beerfactory.entities.BeerEntity;
import com.damnjan.beerfactory.repositories.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public List<BeerEntity> getAllBeers() {
        return beerRepository.findAll();
    }

    public BeerEntity getOneBeer(Long id) {
        return beerRepository.getById(id);
    }

    public void saveBeer(BeerEntity beerEntity) {
        beerRepository.save(beerEntity);
    }

    public void saveBeers(List<BeerEntity> beerEntities) {
        beerRepository.saveAll(beerEntities);
    }

    public void deleteBeerById(Long id) {
        beerRepository.deleteById(id);
    }
}
