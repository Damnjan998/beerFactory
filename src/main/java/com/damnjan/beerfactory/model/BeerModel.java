package com.damnjan.beerfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeerModel {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;


    //TODO mean value temp

}
