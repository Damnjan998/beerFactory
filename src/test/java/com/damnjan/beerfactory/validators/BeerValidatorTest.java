package com.damnjan.beerfactory.validators;

import com.damnjan.beerfactory.exceptions.BadRequestException;
import com.damnjan.beerfactory.repositories.BeerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BeerValidatorTest {

    private static final Long MAX_NUMBER_OF_ROWS = 10L;

    private BeerValidator beerValidator;

    @Mock
    private BeerRepository beerRepository;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);

        beerValidator = new BeerValidator(beerRepository, MAX_NUMBER_OF_ROWS);
    }

    @Test
     public void validateInsertBeerCount() {

        when(beerRepository.count()).thenReturn(MAX_NUMBER_OF_ROWS);
        String beerName = "test";

        BadRequestException badRequestException = assertThrows(BadRequestException.class,
                () -> beerValidator.validateInsertBeer(beerName));

        assertEquals("Maximum number of rows is reached!", badRequestException.getMessage());
    }

    @Test
    public void validateInsertBeerNameExists() {

        String beerName = "test";
        when(beerRepository.count()).thenReturn(7L);
        when(beerRepository.existsByName(beerName)).thenReturn(true);

        BadRequestException badRequestException = assertThrows(BadRequestException.class,
                () -> beerValidator.validateInsertBeer(beerName));

        assertEquals("There is already a beer with name: " + beerName, badRequestException.getMessage());
    }

    @Test
    public void validateInsertBeer() {

        String beerName = "test";
        when(beerRepository.count()).thenReturn(7L);
        when(beerRepository.existsByName(beerName)).thenReturn(false);

        assertDoesNotThrow(() -> beerValidator.validateInsertBeer(beerName));
    }
}