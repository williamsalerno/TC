package br.com.timetrialfactory.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.timetrialfactory.model.entity.enums.PhoneType;

@Entity
public class Phone {

    private PhoneType phoneType;

    private int ddd;

    @Column(unique = true)
    private String number;

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
