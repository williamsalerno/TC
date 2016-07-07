package br.com.timetrialfactory.controller;

import static br.com.timetrialfactory.service.LicenseService.registerService;
import static br.com.timetrialfactory.service.PurchaseService.registerPurchase;

import com.paypal.base.rest.PayPalRESTException;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.timetrialfactory.api.paypal.PayPalToken;
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
	private final PayPalToken payPal;
	private final Result result;

	public PurchaseController(Cart cart, UserWeb userWeb, PurchaseDAO purchaseDao, LicenseDAO licenseDao,
			PayPalToken payPal, Result result) {
		this.cart = cart;
		this.userWeb = userWeb;
		this.purchaseDao = purchaseDao;
		this.licenseDao = licenseDao;
		this.payPal = payPal;
		this.result = result;
	}

	@Post("/buy")
	public void addPurchaseAndLicense() throws PayPalRESTException {
		registerPurchase(cart, userWeb, purchaseDao);
		registerService(cart, userWeb, licenseDao);
		this.payPal.testApi();
		result.redirectTo(GamesController.class).list();
	}
	
	@Post("/comprovaBuy")
		public void comprovaBuy() throws PayPalRESTException{
		this.payPal.testPayment();
		result.redirectTo(GamesController.class).list();
	}
}
