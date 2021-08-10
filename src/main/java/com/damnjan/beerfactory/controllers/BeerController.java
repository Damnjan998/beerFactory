package com.damnjan.beerfactory.controllers;

import com.damnjan.beerfactory.exceptions.BeerNotFoundException;
import com.damnjan.beerfactory.model.BeerResponse;
import com.damnjan.beerfactory.services.BeerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/beers")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<BeerResponse>> getAllBeers() {
        return ResponseEntity.ok(beerService.getAllBeers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeerResponse> getBeerById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(beerService.getOneBeer(id));
        } catch (BeerNotFoundException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity saveOneBeer() {
        beerService.saveBeer();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBeerById(@PathVariable Long id) {
        try {
            beerService.deleteBeerById(id);
            return ResponseEntity.ok().build();
        } catch (BeerNotFoundException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
