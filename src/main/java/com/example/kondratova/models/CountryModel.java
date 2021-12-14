package com.example.kondratova.models;

import javax.persistence.*;

@Entity
@Table
public class CountryModel {

    @Id
    private Long id;

    private String country;

    private String region;

    private int happinessRank;

    private Float happinessScore;

    private Float whiskerHigh;

    private Float whiskerLow;

    private Float economyGDPPerCapita;

    private Float family;

    private Float healthLifeExpectancy;

    private Float freedom;

    private Float generosity;

    private Float trustGovernmentCorruption;

    private Float dystopiaResidual;

    @OneToOne(mappedBy="country", fetch = FetchType.LAZY)
    private CountryValuesModel countryValuesModel;

    public CountryModel() {
    }

    public CountryModel(Long id, String country, String region, int happinessRank, Float happinessScore, Float whiskerHigh, Float whiskerLow, Float economyGDPPerCapita, Float family, Float healthLifeExpectancy, Float freedom, Float generosity, Float trustGovernmentCorruption, Float dystopiaResidual) {
        this.id = id;
        this.country = country;
        this.region = region;
        this.happinessRank = happinessRank;
        this.happinessScore = happinessScore;
        this.whiskerHigh = whiskerHigh;
        this.whiskerLow = whiskerLow;
        this.economyGDPPerCapita = economyGDPPerCapita;
        this.family = family;
        this.healthLifeExpectancy = healthLifeExpectancy;
        this.freedom = freedom;
        this.generosity = generosity;
        this.trustGovernmentCorruption = trustGovernmentCorruption;
        this.dystopiaResidual = dystopiaResidual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getHappinessRank() {
        return happinessRank;
    }

    public void setHappinessRank(int happinessRank) {
        this.happinessRank = happinessRank;
    }

    public Float getHappinessScore() {
        return happinessScore;
    }

    public void setHappinessScore(Float happinessScore) {
        this.happinessScore = happinessScore;
    }

    public Float getWhiskerHigh() {
        return whiskerHigh;
    }

    public void setWhiskerHigh(Float whiskerHigh) {
        this.whiskerHigh = whiskerHigh;
    }

    public Float getWhiskerLow() {
        return whiskerLow;
    }

    public void setWhiskerLow(Float whiskerLow) {
        this.whiskerLow = whiskerLow;
    }

    public Float getEconomyGDPPerCapita() {
        return economyGDPPerCapita;
    }

    public void setEconomyGDPPerCapita(Float economyGDPPerCapita) {
        this.economyGDPPerCapita = economyGDPPerCapita;
    }

    public Float getFamily() {
        return family;
    }

    public void setFamily(Float family) {
        this.family = family;
    }

    public Float getHealthLifeExpectancy() {
        return healthLifeExpectancy;
    }

    public void setHealthLifeExpectancy(Float healthLifeExpectancy) {
        this.healthLifeExpectancy = healthLifeExpectancy;
    }

    public Float getFreedom() {
        return freedom;
    }

    public void setFreedom(Float freedom) {
        this.freedom = freedom;
    }

    public Float getGenerosity() {
        return generosity;
    }

    public void setGenerosity(Float generosity) {
        this.generosity = generosity;
    }

    public Float getTrustGovernmentCorruption() {
        return trustGovernmentCorruption;
    }

    public void setTrustGovernmentCorruption(Float trustGovernmentCorruption) {
        this.trustGovernmentCorruption = trustGovernmentCorruption;
    }

    public Float getDystopiaResidual() {
        return dystopiaResidual;
    }

    public void setDystopiaResidual(Float dystopiaResidual) {
        this.dystopiaResidual = dystopiaResidual;
    }

    public CountryValuesModel getCountryValuesModel() {
        return countryValuesModel;
    }

    public void setCountryValuesModel(CountryValuesModel countryValuesModel) {
        this.countryValuesModel = countryValuesModel;
    }

    public Float sum(){
        return happinessScore + whiskerHigh + whiskerLow + economyGDPPerCapita + family + healthLifeExpectancy + freedom + generosity + trustGovernmentCorruption + dystopiaResidual;
    }
}
