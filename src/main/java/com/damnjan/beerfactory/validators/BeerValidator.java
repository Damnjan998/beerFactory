package com.damnjan.beerfactory.validators;

import com.damnjan.beerfactory.exceptions.BadRequestException;
import com.damnjan.beerfactory.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeerValidator {

    private final Long maxNumberOfRows;
    private final BeerRepository beerRepository;

    public BeerValidator(BeerRepository beerRepository, @Value("${max.rows}") Long maxNumberOfRows) {
        this.beerRepository = beerRepository;
        this.maxNumberOfRows = maxNumberOfRows;
    }

    public void validateInsertBeer(String name) throws BadRequestException {
        long count = beerRepository.count();

        if (count >= maxNumberOfRows) {
            throw new BadRequestException("Maximum number of rows is reached!");
        }

        if (beerRepository.existsByName(name)) {
            throw new BadRequestException("There is already a beer with name: " + name);
        }
    }
}
