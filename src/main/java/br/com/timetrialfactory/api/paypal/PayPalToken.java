package br.com.timetrialfactory.api.paypal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class PayPalToken {

	private String clientId = "Ab_nlXTzR9qxmh-auNEbmrboX_IRtra8Y_oDbQFR9wcP4BEgKwJbmsNsfff0UFFvG1DBDk0qZS2me7DU";
	private String clientSecret = "ENFb67rL3BZC0Qj4c-j9WJZY9xUB2MpgVAgkVxioN5nzy24LOWv9GmQX3M389lyOZTXBKUJZDpPEEMbB";

	public Payment testApi() throws PayPalRESTException {
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");

		APIContext apiContext = new APIContext(clientId, clientSecret, "sandbox");
		apiContext.setConfigurationMap(sdkConfig);

		Amount amount = new Amount();
		amount.setCurrency("BRL");
		amount.setTotal("12");

		Transaction transaction = new Transaction();
		transaction.setDescription("creating a payment");
		transaction.setAmount(amount);

		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("https://devtools-paypal.com/guide/pay_paypal?cancel=true");
		redirectUrls.setReturnUrl("https://devtools-paypal.com/guide/pay_paypal?success=true");
		payment.setRedirectUrls(redirectUrls);

		Payment createdPayment = payment.create(apiContext);
		System.out.println(createdPayment);

		return createdPayment;
	}

	public void testPayment() throws PayPalRESTException {
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");
		APIContext apiContext = new APIContext(clientId, clientSecret, "sandbox");
		apiContext.setConfigurationMap(sdkConfig);
		
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		Payment payment = new Payment("PAY-39V52565ES208061HK56Z26I", payer);
		PaymentExecution paymentExecute = new PaymentExecution();
		paymentExecute.setPayerId("743WADY6RL6BS");
		payment.execute(apiContext, paymentExecute);
	}

}
