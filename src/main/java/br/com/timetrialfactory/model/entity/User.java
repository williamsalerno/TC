package br.com.timetrialfactory.model.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;

@Entity(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_seq")
    @Column(name = "User_Id")
    private Long id;

    @Column(name = "User_Cpf", unique = true)
    private String cpf;

    @Column(name = "User_Name", nullable = false)
    private String name;

    @Column(name = "User_LastName", nullable = false)
    private String lastName;

    @Column(name = "User_Login", nullable = false, unique = true)
    private String login;

    @Column(name = "User_Password", nullable = false)
    private String password;

    @Email(regexp = "[a-z]+@{1}\\w+\\.com{1}(\\.br)*", message = "O email informado é inválido.")
    @Column(name = "User_Email", nullable = false, unique = true)
    private String email;

    @Embedded
    @Valid
    private Address address;

    @Embedded
    @Valid
    private Phone phone;

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

}
