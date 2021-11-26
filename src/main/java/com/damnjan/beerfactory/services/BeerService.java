package com.damnjan.beerfactory.services;

import com.damnjan.beerfactory.converters.BeerConverter;
import com.damnjan.beerfactory.entities.BeerEntity;
import com.damnjan.beerfactory.exceptions.BadRequestException;
import com.damnjan.beerfactory.exceptions.BeerNotFoundException;
import com.damnjan.beerfactory.models.BeerRandomModel;
import com.damnjan.beerfactory.models.BeerResponse;
import com.damnjan.beerfactory.models.PageResponseModel;
import com.damnjan.beerfactory.repositories.BeerRepository;
import com.damnjan.beerfactory.validators.BeerValidator;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerConverter beerConverter;
    private final BeerValidator beerValidator;
    private final RestTemplate restTemplate;

    public BeerService(BeerRepository beerRepository, BeerConverter beerConverter, BeerValidator beerValidator, RestTemplate restTemplate) {
        this.beerRepository = beerRepository;
        this.beerConverter = beerConverter;
        this.beerValidator = beerValidator;
        this.restTemplate = restTemplate;
    }

    public List<BeerResponse> getAllBeers() {

        return beerRepository.findAll().stream().map(beerConverter::convert).collect(Collectors.toList());
    }

    public BeerResponse getOneBeer(Long id) throws BeerNotFoundException {

        BeerEntity beerEntity = beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException("There is no beer with ID: " + id));

        return beerConverter.convert(beerEntity);
    }

    public void saveBeer() throws BadRequestException, BeerNotFoundException {

        List<BeerRandomModel> beerRandomModels = restTemplate
                .exchange("https://api.punkapi.com/v2/beers/random", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<BeerRandomModel>>() {
                })
                .getBody();

        if (CollectionUtils.isEmpty(beerRandomModels)) {
            throw new BeerNotFoundException("Random beer not found!");
        }

        BeerRandomModel beerRandomModel = beerRandomModels.get(0);
        beerValidator.validateInsertBeer(beerRandomModel.getName());
        beerRepository.save(beerConverter.convert(beerRandomModel));
    }

    public void deleteBeerById(Long id) throws BeerNotFoundException {

        BeerEntity beerEntity = beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException("There is no beer with ID: " + id));

        beerRepository.delete(beerEntity);
    }

    public PageResponseModel<BeerEntity> getUsers(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BeerEntity> all = beerRepository.findAll(pageable);
        return new PageResponseModel<>(all.getContent(), all.getTotalPages(), all.getNumber() + 1);
    }
}
