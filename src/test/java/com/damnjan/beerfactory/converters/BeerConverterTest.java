package com.damnjan.beerfactory.converters;

import com.damnjan.beerfactory.entities.BeerEntity;
import com.damnjan.beerfactory.models.BeerRandomModel;
import com.damnjan.beerfactory.models.MashTempModel;
import com.damnjan.beerfactory.models.MethodModel;
import com.damnjan.beerfactory.models.TempModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeerConverterTest {

    private BeerConverter converter;

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);

        converter = new BeerConverter();
    }

    @Test
    void convertBeerRandomModelToBeerEntity() {

        int size = 2;

        BeerRandomModel beerRandomModel = getBeerRandomModel(size);
        BeerEntity beerEntity = converter.convert(beerRandomModel);

        assertEquals(NAME, beerEntity.getName());
        assertEquals(DESCRIPTION, beerEntity.getDescription());
        assertEquals(size, beerEntity.getMashTempEntities().size());
    }

    private BeerRandomModel getBeerRandomModel(int size) {

        return new BeerRandomModel(NAME, DESCRIPTION, new MethodModel(getMashTempModels(size)));
    }

    private List<MashTempModel> getMashTempModels(int size) {

        List<MashTempModel> mashTempModels = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Integer value = ThreadLocalRandom.current().nextInt();
            Integer duration = ThreadLocalRandom.current().nextInt();
            MashTempModel mashTempModel = new MashTempModel(new TempModel(value, "celsius"), duration);

            mashTempModels.add(mashTempModel);
        }

        return mashTempModels;
    }

}