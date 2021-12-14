package com.example.kondratova.models;

import com.example.kondratova.models.CountryModel;

import javax.persistence.*;

@Entity
@Table
public class CountryValuesModel {

    @Id
    private Long id;

    @OneToOne(optional=true, fetch = FetchType.EAGER)
    private CountryModel country;

    private Float value;

    public CountryValuesModel() {
    }

    public CountryValuesModel(Long id, CountryModel country, Float value) {
        this.id = id;
        this.country = country;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CountryModel getCountry() {
        return country;
    }

    public void setCountry(CountryModel country) {
        this.country = country;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
