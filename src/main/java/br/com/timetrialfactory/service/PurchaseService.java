package br.com.timetrialfactory.service;

import static br.com.timetrialfactory.model.entity.enums.PurchaseSituationType.PROCESSANDO;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

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
			purchase.setPurchaseDate(LocalDateTime.now(DateTimeZone.forID("America/Sao_Paulo")));
			purchase.setUser(userWeb.getLoggedUser());
			purchase.setPurchaseSituation(PROCESSANDO);
			dao.insertPurchase(purchase);
		}
	}

}
