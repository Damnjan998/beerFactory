package com.damnjan.beerfactory.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseModel<T> {

    private List<T> response;
    private Integer total;
    private Integer currentPage;
}
