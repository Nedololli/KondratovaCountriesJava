package com.example.kondratova;

import com.example.kondratova.models.CountryValuesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Set;

@Repository
public interface CountryValuesRepository extends JpaRepository<CountryValuesModel, Long> {
    List<CountryValuesModel> findAllByOrderByValueAsc();
}
