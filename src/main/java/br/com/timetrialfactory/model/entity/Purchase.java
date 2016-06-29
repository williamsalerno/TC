package br.com.timetrialfactory.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.joda.time.DateTime;

@Entity(name = "purchases")
public class Purchase {
	
	@Id
	@SequenceGenerator(name = "purchases_seq", sequenceName = "purchases_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "purchases_seq")
	@Column(name = "purchase_Id")
	private Long id;
	
	@Column(name = "purchase_User", nullable = false)
	private User user;
	
	@Column(name = "purchase_Game", nullable = false)
	private Game game;
	
	@Column(name = "purchase_Price", nullable = false)
	private BigDecimal price;
	
	@Column(name = "purchase_Date", nullable = false)
	private DateTime purchaseDate;

}
