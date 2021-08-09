package com.damnjan.beerfactory.services;

import com.damnjan.beerfactory.converters.BeerConverter;
import com.damnjan.beerfactory.entities.BeerEntity;
import com.damnjan.beerfactory.exceptions.BeerNotFoundException;
import com.damnjan.beerfactory.model.BeerModel;
import com.damnjan.beerfactory.repositories.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerConverter beerConverter;

    public BeerService(BeerRepository beerRepository, BeerConverter beerConverter) {
        this.beerRepository = beerRepository;
        this.beerConverter = beerConverter;
    }

    public List<BeerModel> getAllBeers() {

        return beerRepository.findAll().stream().map(beerConverter::convert).collect(Collectors.toList());
    }

    public BeerModel getOneBeer(Long id) throws BeerNotFoundException {

        BeerEntity beerEntity = beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException("There is no beer with ID: " + id));

        return beerConverter.convert(beerEntity);
    }

    public void saveBeer(BeerModel beerModel) {

        beerRepository.save(beerConverter.convert(beerModel));
    }

    public void saveBeers(List<BeerModel> beerModels) {

        beerRepository.saveAll(beerModels.stream().map(beerConverter::convert).collect(Collectors.toList()));
    }

    public void deleteBeerById(Long id) throws BeerNotFoundException {

        BeerEntity beerEntity = beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException("There is no beer with ID: " + id));

        beerRepository.delete(beerEntity);
    }
}
