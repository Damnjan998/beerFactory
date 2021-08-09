package com.damnjan.beerfactory.converters;

import com.damnjan.beerfactory.entities.MashTempEntity;
import com.damnjan.beerfactory.model.MashTempModel;
import org.springframework.stereotype.Component;

@Component
public class MashTempConverter {

    public MashTempEntity convert(MashTempModel mashTempModel) {
        if (mashTempModel == null) {
            return null;
        }

        final MashTempEntity mashTempEntity = new MashTempEntity();
        mashTempEntity.setId(mashTempModel.getId());
        mashTempEntity.setTempValue(mashTempModel.getTempValue());
        mashTempEntity.setUnit(mashTempModel.getUnit());
        mashTempEntity.setDuration(mashTempModel.getDuration());

        return mashTempEntity;
    }

    public MashTempModel convert(MashTempEntity mashTempEntity) {
        if (mashTempEntity == null) {
            return null;
        }

        final MashTempModel mashTempModel = new MashTempModel();
        mashTempModel.setId(mashTempEntity.getId());
        mashTempModel.setTempValue(mashTempEntity.getTempValue());
        mashTempModel.setUnit(mashTempEntity.getUnit());
        mashTempModel.setDuration(mashTempEntity.getDuration());

        return mashTempModel;
    }
}
