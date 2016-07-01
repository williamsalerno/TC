package br.com.timetrialfactory.controller;

import static br.com.timetrialfactory.model.entity.enums.PurchaseSituationType.EM_ANDAMENTO;
import static java.util.UUID.randomUUID;

import java.util.Date;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.timetrialfactory.dao.GameDAO;
import br.com.timetrialfactory.dao.LicenseDAO;
import br.com.timetrialfactory.dao.PurchaseDAO;
import br.com.timetrialfactory.infra.UserWeb;
import br.com.timetrialfactory.model.Cart;
import br.com.timetrialfactory.model.Item;
import br.com.timetrialfactory.model.entity.License;
import br.com.timetrialfactory.model.entity.Purchase;

@Resource
public class CartController {

	private final Cart cart;
	private final Purchase purchase;
	private final License license;
	private final GameDAO gameDao;
	private final UserWeb userWeb;
	private final PurchaseDAO purchaseDao;
	private final LicenseDAO licenseDao;
	private final Result result;

	public CartController(Cart cart, Purchase purchase, License license, GameDAO gameDao, LicenseDAO licenseDao,
			UserWeb userWeb, PurchaseDAO purchaseDao, Result result) {
		this.cart = cart;
		this.purchase = purchase;
		this.license = license;
		this.gameDao = gameDao;
		this.licenseDao = licenseDao;
		this.userWeb = userWeb;
		this.purchaseDao = purchaseDao;
		this.result = result;
	}

	@Get("/cart")
	public void view() {
	}

	@Post("/cart")
	public void add(Item item) {
		gameDao.recharge(item.getGame());
		cart.add(item);
		result.redirectTo(this).view();
	}

	@Post("/testeJogoComprado")
	public void add() {
		for (int i = 0; i < cart.getItems().size(); i++) {
			purchase.setUser(this.userWeb.getId());
			purchase.setPurchaseDate(new Date());
			purchase.setPurchaseSituation(EM_ANDAMENTO);
			purchase.setGame(this.cart.getItems().get(i).getGame().getId());
			purchase.setPrice(this.cart.getItems().get(i).getGame().getPrice());
			purchaseDao.registerPurchase(purchase);
			license.setCode(randomUUID().toString());
			license.setUser(this.userWeb.getId());
			license.setPurchaseCode(purchase.getId());
			license.setCheckedCode(false);
			license.setGame(this.cart.getItems().get(i).getGame().getId());
			licenseDao.insertLicense(this.license);
		}
		result.redirectTo(GamesController.class).list();
	}

	@Delete("/cart/{itemIndex}")
	public void remove(int itemIndex) {
		cart.remove(itemIndex);
		result.redirectTo(this).view();
	}
}
