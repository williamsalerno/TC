package br.com.timetrialfactory.controller;

import static br.com.timetrialfactory.service.LicenseService.registerLicense;
import static br.com.timetrialfactory.service.PurchaseService.registerPurchase;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.timetrialfactory.annotations.Restrict;
import br.com.timetrialfactory.api.paypal.PayPalApiCall;
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
	private final PayPalApiCall payPal;
	private final Result result;

	public PurchaseController(Cart cart, UserWeb userWeb, PurchaseDAO purchaseDao, LicenseDAO licenseDao,
			PayPalApiCall payPal, Result result) {
		this.cart = cart;
		this.userWeb = userWeb;
		this.purchaseDao = purchaseDao;
		this.licenseDao = licenseDao;
		this.payPal = payPal;
		this.result = result;
	}

	@Restrict
	@Post("/payment")
	public void getGeneratePayment(String currency) throws PayPalRESTException {
		Payment urlPayPal = this.payPal.apiRequest(currency, cart);
		registerPurchase(cart, userWeb, purchaseDao);
		result.redirectTo(urlPayPal.getLinks().get(1).getHref());
	}

	@Restrict
	@Post("/confirmedPayment")
	public void confirmPayment(String paymentId) throws PayPalRESTException {
		this.payPal.apiReturn(paymentId);
		registerLicense(cart, userWeb, licenseDao);
		result.redirectTo(GamesController.class).list();
	}

}
