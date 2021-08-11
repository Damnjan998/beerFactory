package com.damnjan.beerfactory.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MethodModel {

    @JsonProperty("mash_temp")
    private List<MashTempModel> mashTempModels;
}
