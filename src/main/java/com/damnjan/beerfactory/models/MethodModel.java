package com.damnjan.beerfactory.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MethodModel {

    private List<MashTempModel> mashTempModels;
}
