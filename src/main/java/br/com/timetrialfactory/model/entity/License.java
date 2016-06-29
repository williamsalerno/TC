package br.com.timetrialfactory.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "licenses")
public class License {

	@Id
	@Column(name = "license_Code", nullable = false, unique = true)
	private String code;

	@Column(name = "license_Game", nullable = false)
	private Game game;

	@Column(name = "license_User", nullable = false)
	private User user;

	@Column(name = "license_PurchaseCode", nullable = false, unique = true)
	private String purchaseCode;

	private boolean checkedCode;

	// private Integer copies;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public boolean isCheckedCode() {
		return checkedCode;
	}

	public void setCheckedCode(boolean checkedCode) {
		this.checkedCode = checkedCode;
	}

}
