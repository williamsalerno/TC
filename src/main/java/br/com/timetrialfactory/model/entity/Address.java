package br.com.timetrialfactory.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.timetrialfactory.model.entity.enums.Country;

@Embeddable
public class Address {

    @Column(name = "Address_Country", nullable = true)
    private Country country;

    @Column(name = "Address_State", nullable = false)
    private String state;

    @Column(name = "Address_City", nullable = true)
    private String city;

    @Column(name = "Address_Cep", nullable = true)
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
