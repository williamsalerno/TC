package br.com.timetrialfactory.api.paypal;

import static br.com.timetrialfactory.api.paypal.PayPalToken.getClientId;
import static br.com.timetrialfactory.api.paypal.PayPalToken.getClientSecret;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonElement;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import br.com.caelum.vraptor.ioc.Component;
import br.com.timetrialfactory.model.Cart;

@Component
public class PayPalApiCall {

	private Payer payer;

	public PayPalApiCall() {
		this.payer = new Payer();
		this.payer.setPaymentMethod("paypal");
	}

	private static APIContext setAPIContext() {
		APIContext apiContext = new APIContext(getClientId(), getClientSecret(), "sandbox");
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");
		apiContext.setConfigurationMap(sdkConfig);
		return apiContext;
	}

	private Amount setAmount(String currency, Cart cart) {
		Amount amount = new Amount();
		amount.setCurrency(currency);
		amount.setTotal(cart.getTotal().toString());

		return amount;
	}

	private ItemList setItemsInListPayPal(String currency, Cart cart) {
		Item itemPayPal = new Item();
		ItemList itemList = new ItemList();
		List<Item> items = new ArrayList<>();

		for (int i = 0; i < cart.getItems().size(); i++) {
			itemPayPal.setName(cart.getItems().get(i).getGame().getTitle());
			itemPayPal.setPrice(cart.getItems().get(i).getGame().getPrice().toString());
			itemPayPal.setCurrency(currency);
			itemPayPal.setQuantity("1");
			items.add(itemPayPal);
		}

		itemList.setItems(items);

		return itemList;
	}

	private List<Transaction> listTransactions(String currency, Cart cart) {
		Transaction transaction = new Transaction();
		transaction.setDescription("creating a payment");
		transaction.setAmount(this.setAmount(currency, cart));
		transaction.setItemList(setItemsInListPayPal(currency, cart));

		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		return transactions;
	}

	public String apiRequest(String currency, Cart cart) throws PayPalRESTException {
		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(this.payer);
		payment.setTransactions(this.listTransactions(currency, cart));
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("https://devtools-paypal.com/guide/pay_paypal?cancel=true");
		redirectUrls.setReturnUrl("https://http://timetrialfac.wix.com/ttfac");
		payment.setRedirectUrls(redirectUrls);

		Payment createdPayment = payment.create(setAPIContext());
		System.out.println(createdPayment);

		return createdPayment.toJSON();
	}

	public void apiReturn(String paymentId) throws PayPalRESTException {
		Payment payment = new Payment(paymentId, this.payer);
		PaymentExecution paymentExecute = new PaymentExecution();
		paymentExecute.setPayerId("743WADY6RL6BS");
		payment.execute(setAPIContext(), paymentExecute);

		System.out.println(paymentExecute.getPayerId());
	}

}
