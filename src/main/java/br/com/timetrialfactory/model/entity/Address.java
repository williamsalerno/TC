package br.com.timetrialfactory.model.entity;

import javax.persistence.Entity;

import br.com.timetrialfactory.model.entity.enums.Country;

@Entity
public class Address {

    private Country country;

    private String state;

    private String city;

    private String cep;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
