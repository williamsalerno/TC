package br.com.timetrialfactory.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import br.com.timetrialfactory.model.entity.enums.PurchaseSituationType;

@Entity(name = "purchases")
public class Purchase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "purchases_seq", sequenceName = "purchases_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "purchases_seq")
	@Column(name = "purchase_Id")
	private Long id;

	@NotNull
	@Column(name = "purchase_Game", nullable = false)
	private Long game;

	@NotNull
	@Column(name = "purchase_User", nullable = false)
	private Long user;

	@NotNull
	@Column(name = "purchase_Price", nullable = false)
	private BigDecimal price;

	@NotNull
	@Column(name = "purchase_Date", nullable = false)
	private Date purchaseDate;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name = "purchase_Situation", nullable = false)
	private PurchaseSituationType purchaseSituation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGame() {
		return game;
	}

	public void setGame(Long game) {
		this.game = game;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public PurchaseSituationType getPurchaseSituation() {
		return purchaseSituation;
	}

	public void setPurchaseSituation(PurchaseSituationType purchaseSituation) {
		this.purchaseSituation = purchaseSituation;
	}

}
