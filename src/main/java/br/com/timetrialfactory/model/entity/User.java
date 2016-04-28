package br.com.timetrialfactory.model.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class User {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "user_seq")
    private Long id;

    @CPF
    @Pattern(regexp = "\\d{11}", message = "CPF inválido. Deve conter 11 dígitos numéricos.")
    @Column(unique = true)
    private String cpf;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String nick;

    @NotNull
    @Email(regexp = "[a-z]+@{1}\\w+\\.com{1}(\\.br)*", message = "O email informado é inválido.")
    private String email;

    @NotNull
    @Valid
    private Address address;

    @Valid
    private Phone phone;

    @Valid
    private Set<License> keys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Set<License> getKeys() {
        return keys;
    }

    public void setKeys(Set<License> keys) {
        this.keys = keys;
    }

}
