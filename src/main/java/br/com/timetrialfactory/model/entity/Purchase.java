package br.com.timetrialfactory.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import br.com.timetrialfactory.model.entity.enums.PurchaseSituationType;

@Entity(name = "PURCHASES")
public class Purchase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "purchases_seq", sequenceName = "purchases_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "purchases_seq")
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull
	@Column(name = "game_price", nullable = false)
	private BigDecimal price;

	@NotNull
	@Column(name = "purchase_date", nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime purchaseDate;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name = "purchase_situation", nullable = false)
	private PurchaseSituationType purchaseSituation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public DateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(DateTime dateTime) {
		this.purchaseDate = dateTime;
	}

	public PurchaseSituationType getPurchaseSituation() {
		return purchaseSituation;
	}

	public void setPurchaseSituation(PurchaseSituationType purchaseSituation) {
		this.purchaseSituation = purchaseSituation;
	}

}
