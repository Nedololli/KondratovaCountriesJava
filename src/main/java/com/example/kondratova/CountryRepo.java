package com.example.kondratova;

import com.example.kondratova.models.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CountryRepo extends JpaRepository<CountryModel, Long> {
    ArrayList<CountryModel> findAllByRegion(String string);
}
