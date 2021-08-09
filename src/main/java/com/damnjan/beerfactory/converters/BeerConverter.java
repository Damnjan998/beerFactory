package com.damnjan.beerfactory.converters;

import com.damnjan.beerfactory.entities.BeerEntity;
import com.damnjan.beerfactory.model.BeerModel;
import org.springframework.stereotype.Component;

@Component
public class BeerConverter {

    public BeerEntity convert(BeerModel beerModel) {

        if (beerModel == null) {
            return null;
        }

        final BeerEntity beerEntity = new BeerEntity();
        beerEntity.setId(beerModel.getId());
        beerEntity.setName(beerModel.getName());
        beerEntity.setDescription(beerModel.getDescription());

        return beerEntity;
    }

    public BeerModel convert(BeerEntity beerEntity) {

        if (beerEntity == null) {
            return null;
        }

        final BeerModel beerModel = new BeerModel();
        beerModel.setId(beerEntity.getId());
        beerModel.setName(beerEntity.getName());
        beerModel.setDescription(beerEntity.getDescription());

        return beerModel;
    }
}
