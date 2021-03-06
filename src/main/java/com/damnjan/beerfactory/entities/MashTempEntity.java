package com.damnjan.beerfactory.entities;

import com.damnjan.beerfactory.models.MashTempModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mash_temp")
public class MashTempEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer value;
    private String unit;
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "beer_id")
    private BeerEntity beerEntity;

    public MashTempEntity(MashTempModel mashTempModel, BeerEntity beerEntity) {
        this.value = mashTempModel.getTemp().getValue();
        this.unit = mashTempModel.getTemp().getUnit();
        this.duration = mashTempModel.getDuration();
        this.beerEntity = beerEntity;
    }
}
