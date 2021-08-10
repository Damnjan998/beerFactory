package com.damnjan.beerfactory.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeerResponse {

    private Long id;

    private String name;

    private String description;

    private double meanTemp;

}
