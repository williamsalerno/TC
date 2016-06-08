package br.com.timetrialfactory.model.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

@Entity(name = "users")
public class User {

	@Id
	@SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "users_seq")
	@Column(name = "User_Id")
	private Long id;

	@Column(name = "User_FirstName", nullable = false)
	@Pattern(regexp = "[a-zA-Z ]+", message = "O nome deve conter apenas letras.")
	private String firstName;

	@Column(name = "User_LasttName", nullable = false)
	@Pattern(regexp = "[a-zA-Z ]+", message = "O nome deve conter apenas letras.")
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

	@Column(name = "User_Admin", nullable = false)
	private boolean admin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fullName) {
		this.firstName = fullName;
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
