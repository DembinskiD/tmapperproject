package com.tmapper.tmapperproject.service;

import com.tmapper.tmapperproject.dataaccess.HuntingSpotRepository;

public class VocationService {

    HuntingSpotRepository repository;

    VocationService(HuntingSpotRepository repository) {
        this.repository = repository;
    }



}
