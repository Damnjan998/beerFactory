package com.damnjan.beerfactory.converters;

import com.damnjan.beerfactory.entities.BeerEntity;
import com.damnjan.beerfactory.entities.MashTempEntity;
import com.damnjan.beerfactory.models.BeerRandomModel;
import com.damnjan.beerfactory.models.BeerResponse;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BeerConverter {

    public BeerEntity convert(BeerRandomModel beerRandomModel) {

        if (beerRandomModel == null) {
            return null;
        }

        final BeerEntity beerEntity = new BeerEntity();
        beerEntity.setName(beerRandomModel.getName());
        beerEntity.setDescription(beerRandomModel.getDescription());
        beerEntity.setMashTempEntities(convertToMashTempEntities(beerRandomModel, beerEntity));

        return beerEntity;
    }

    public BeerResponse convert(BeerEntity beerEntity) {

        if (beerEntity == null) {
            return null;
        }

        final BeerResponse beerResponse = new BeerResponse();
        beerResponse.setId(beerEntity.getId());
        beerResponse.setName(beerEntity.getName());
        beerResponse.setDescription(beerEntity.getDescription());

        double sumTemp = beerEntity.getMashTempEntities()
                .stream()
                .mapToInt(MashTempEntity::getValue)
                .sum();

        double meanTemp = sumTemp / beerEntity.getMashTempEntities().size();

        beerResponse.setMeanTemp(meanTemp);

        return beerResponse;
    }

    private Set<MashTempEntity> convertToMashTempEntities(BeerRandomModel beerRandomModel, BeerEntity beerEntity) {

        if (beerRandomModel.getMethod() == null) {
            return new HashSet<>();
        }

        final Set<MashTempEntity> mashTempEntities = new HashSet<>();

        beerRandomModel.getMethod().getMashTempModels()
                .forEach(mashTempModel -> mashTempEntities.add(new MashTempEntity(mashTempModel, beerEntity)));

        return mashTempEntities;
    }
}
