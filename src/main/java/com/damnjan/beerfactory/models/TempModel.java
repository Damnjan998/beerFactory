package com.damnjan.beerfactory.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempModel {

    private Integer value;

    private String unit;
}
