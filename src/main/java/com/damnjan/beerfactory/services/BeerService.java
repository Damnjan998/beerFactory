package com.damnjan.beerfactory.services;

import com.damnjan.beerfactory.converters.BeerConverter;
import com.damnjan.beerfactory.entities.BeerEntity;
import com.damnjan.beerfactory.exceptions.BeerNotFoundException;
import com.damnjan.beerfactory.model.BeerRandomModel;
import com.damnjan.beerfactory.model.BeerResponse;
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

    public List<BeerResponse> getAllBeers() {

        return beerRepository.findAll().stream().map(beerConverter::convert).collect(Collectors.toList());
    }

    public BeerResponse getOneBeer(Long id) throws BeerNotFoundException {

        BeerEntity beerEntity = beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException("There is no beer with ID: " + id));

        return beerConverter.convert(beerEntity);
    }

    public void saveBeer() {

        beerRepository.save(beerConverter.convert(new BeerRandomModel()));
    }

    public void deleteBeerById(Long id) throws BeerNotFoundException {

        BeerEntity beerEntity = beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException("There is no beer with ID: " + id));

        beerRepository.delete(beerEntity);
    }
}
