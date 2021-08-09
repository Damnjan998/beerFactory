package com.damnjan.beerfactory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MashTempModel {

    private Long id;

    @Min(1)
    @Max(999)
    private Long tempValue;

    @NotBlank
    private String unit;

    @Min(1)
    @Max(999)
    private Long duration;
}
