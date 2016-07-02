package br.com.timetrialfactory.model.entity.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.timetrialfactory.model.entity.enums.PhoneType;

@Embeddable
public class Phone {

    @Enumerated(EnumType.STRING)
    @Column(name = "phone_Type")
    private PhoneType phoneType;

    @Column(name = "phone_Ddd")
    private Integer ddd;

    @Column(name = "phone_Number")
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
