package com.damnjan.beerfactory.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeerRandomModel {

    private String name;
    private String description;
    private MethodModel method;
}
