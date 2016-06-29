package br.com.timetrialfactory.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity(name = "games")
public class Game {

	@Id
	@SequenceGenerator(name = "game_seq", sequenceName = "game_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
	@Column(name = "game_Id")
	private Long id;

	@NotNull
	@Length(min = 5, message = "Título do jogo é obrigatório e deve ter, no mínimo, 5 caracteres.")
	@Column(name = "game_Title", nullable = false, unique = true)
	private String title;

	@NotNull
	@Min(value = 1, message = "O preço do jogo deve ser maior que ou igual a 1.")
	@Column(name = "game_Price", nullable = false)
	private BigDecimal price;

	@Column(name = "game_Description")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
