package br.com.timetrialfactory.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "licenses")
public class License {

	@Id
	@Column(name = "license_Code", nullable = false, unique = true)
	@NotNull
	private String code;

	@NotNull
	@Column(name = "license_Game", nullable = false)
	private Long game;

	@NotNull
	@Column(name = "license_User", nullable = false)
	private String user;

	@NotNull
	@Column(name = "license_PurchaseCode", nullable = false, unique = true)
	private Long purchaseCode;

	private Boolean checkedCode;

	// private Integer copies;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getGame() {
		return game;
	}

	public void setGame(Long game) {
		this.game = game;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Long getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(Long purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public boolean isCheckedCode() {
		return checkedCode;
	}

	public void setCheckedCode(Boolean checkedCode) {
		this.checkedCode = checkedCode;
	}

}
