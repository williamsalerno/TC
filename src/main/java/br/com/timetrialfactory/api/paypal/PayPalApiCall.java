package br.com.timetrialfactory.api.paypal;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import br.com.caelum.vraptor.Resource;

@Resource
public class PayPalApiCall {
	
	private String clientId = "Ab_nlXTzR9qxmh-auNEbmrboX_IRtra8Y_oDbQFR9wcP4BEgKwJbmsNsfff0UFFvG1DBDk0qZS2me7DU";
	private String clientSecret = "ENFb67rL3BZC0Qj4c-j9WJZY9xUB2MpgVAgkVxioN5nzy24LOWv9GmQX3M389lyOZTXBKUJZDpPEEMbB";
	private APIContext context;
	private Payment payment;
	
	public PayPalApiCall(String clientId, String clientSecret, APIContext context, Payment payment){
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.context = new APIContext(clientId, clientSecret, "sandbox");
		this.payment = payment;
	}
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}


	public void fetchPaymentById(){
		try {
			this.context.addConfiguration("http.ConnectionTimeOut", "2000");
			this.payment = Payment.get(this.context, "PAY-4T698276NC427425EK5QIV7Y");
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
		System.out.println(this.payment);
	}

}
