package br.com.timetrialfactory.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.timetrialfactory.model.entity.enums.PhoneType;

@Embeddable
public class Phone {

    @Enumerated(EnumType.STRING)
    @Column(name = "Phone_Type")
    private PhoneType phoneType;

    @Column(name = "Phone_Ddd")
    private Integer ddd;

    @Column(name = "Phone_Number")
    private String number;

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
