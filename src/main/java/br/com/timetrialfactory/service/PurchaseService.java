package br.com.timetrialfactory.service;

import static br.com.timetrialfactory.model.entity.enums.PurchaseSituationType.PROCESSANDO;
import static br.com.timetrialfactory.service.LicenseService.purchaseIdToLicenseTable;
import static org.joda.time.DateTime.now;

import br.com.timetrialfactory.dao.PurchaseDAO;
import br.com.timetrialfactory.infra.UserWeb;
import br.com.timetrialfactory.model.Cart;
import br.com.timetrialfactory.model.entity.Purchase;

public class PurchaseService {

	private PurchaseService() {
	}

	public static void registerPurchase(Cart cart, UserWeb userWeb, PurchaseDAO dao) {
		Purchase purchase = new Purchase();
		for (int i = 0; i < cart.getItems().size(); i++) {
			purchase.setGame(cart.getItems().get(i).getGame());
			purchase.setPrice(cart.getItems().get(i).getGame().getPrice());
			purchase.setPurchaseDate(now());
			purchase.setUser(userWeb.getLoggedUser());
			purchase.setPurchaseSituation(PROCESSANDO);
			dao.insertPurchase(purchase);
			purchaseIdToLicenseTable(purchase);
		}
	}

}
