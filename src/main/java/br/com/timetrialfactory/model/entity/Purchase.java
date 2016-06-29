package br.com.timetrialfactory.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

@Entity(name = "purchases")
public class Purchase {
	
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
	private String user;
	
	@NotNull
	@Column(name = "purchase_Price", nullable = false)
	private BigDecimal price;
	
	@NotNull
	@Column(name = "purchase_Date", nullable = false)
	private DateTime purchaseDate;

}
