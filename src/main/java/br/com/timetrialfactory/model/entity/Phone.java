package br.com.timetrialfactory.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.timetrialfactory.model.entity.enums.PhoneType;

@Embeddable
public class Phone {

    @Column(name = "Phone_Type", nullable = false)
    private PhoneType phoneType;

    @Column(name = "Phone_Ddd", nullable = false)
    private Integer ddd;

    @Column(name = "Phone_Number", nullable = false, unique = true)
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
