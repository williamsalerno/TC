package br.com.timetrialfactory.controller;

import static br.com.timetrialfactory.service.LicenseService.registerService;
import static br.com.timetrialfactory.service.PurchaseService.registerPurchase;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.timetrialfactory.dao.LicenseDAO;
import br.com.timetrialfactory.dao.PurchaseDAO;
import br.com.timetrialfactory.infra.UserWeb;
import br.com.timetrialfactory.model.Cart;

@Resource
public class PurchaseController {

	private final Cart cart;
	private final UserWeb userWeb;
	private final PurchaseDAO purchaseDao;
	private final LicenseDAO licenseDao;
	private final Result result;

	public PurchaseController(Cart cart, UserWeb userWeb, PurchaseDAO purchaseDao, LicenseDAO licenseDao,
			Result result) {
		this.cart = cart;
		this.userWeb = userWeb;
		this.purchaseDao = purchaseDao;
		this.licenseDao = licenseDao;
		this.result = result;
	}

	@Post("/buy")
	public void addPurchaseAndLicense() {
		registerPurchase(cart, userWeb, purchaseDao);
		registerService(cart, userWeb, licenseDao);
		result.redirectTo(GamesController.class).list();
	}
}
