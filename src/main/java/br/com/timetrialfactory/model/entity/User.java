package br.com.timetrialfactory.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity(name="users")
public class User {

    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_seq")
    private Long id;

    // @CPF
    // @Pattern(regexp = "\\d{11}", message = "CPF inválido. Deve conter 11 dígitos numéricos.")
    // @Column(unique = true)
    // private String cpf;

    @NotNull
    private String name;

    // @NotNull
    // private String lastName;

    @NotNull
    @Column(unique = true)
    private String login;

    @NotNull
    private String password;

    // @NotNull
    // @Email(regexp = "[a-z]+@{1}\\w+\\.com{1}(\\.br)*", message = "O email informado é inválido.")
    // @Column(unique = true)
    // private String email;
    //
    // @NotNull
    // @Valid
    // @Column
    // private Address address;
    //
    // @Valid
    // private Phone phone;
    //
    // @Valid
    // private Set<License> keys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public String getCpf() {
    // return cpf;
    // }
    //
    // public void setCpf(String cpf) {
    // this.cpf = cpf;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public String getLastName() {
    // return lastName;
    // }
    //
    // public void setLastName(String lastName) {
    // this.lastName = lastName;
    // }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public String getEmail() {
    // return email;
    // }
    //
    // public void setEmail(String email) {
    // this.email = email;
    // }
    //
    // public Address getAddress() {
    // return address;
    // }
    //
    // public void setAddress(Address address) {
    // this.address = address;
    // }
    //
    // public Phone getPhone() {
    // return phone;
    // }
    //
    // public void setPhone(Phone phone) {
    // this.phone = phone;
    // }
    //
    // public Set<License> getKeys() {
    // return keys;
    // }
    //
    // public void setKeys(Set<License> keys) {
    // this.keys = keys;
    // }

}
