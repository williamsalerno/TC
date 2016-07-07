package br.com.timetrialfactory.service;

import static br.com.timetrialfactory.utils.LicenseGenerator.generateCode;

import br.com.timetrialfactory.dao.LicenseDAO;
import br.com.timetrialfactory.infra.UserWeb;
import br.com.timetrialfactory.model.Cart;
import br.com.timetrialfactory.model.entity.License;

public class LicenseService {

	private LicenseService() {
	}

	public static void registerLicense(Cart cart, UserWeb userWeb, LicenseDAO dao) {
		for (int i = 0; i < cart.getItems().size(); i++) {
			License license = new License();
			license.setCode(generateCode());
			license.setGame(cart.getItems().get(i).getGame());
			license.setUser(userWeb.getLoggedUser());
			dao.insertLicense(license);
		}
	}
}
