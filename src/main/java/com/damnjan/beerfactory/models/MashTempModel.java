package com.damnjan.beerfactory.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MashTempModel {

    private TempModel tempModel;

    private Integer duration;
}
