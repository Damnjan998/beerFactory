package com.damnjan.beerfactory.model;
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
