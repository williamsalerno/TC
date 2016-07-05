package br.com.timetrialfactory.api.paypal;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import br.com.caelum.vraptor.Resource;

@Resource
public class PayPalApiCall {
	
	private String clientId = "AYSq3RDGsmBLJE-otTkBtM-jBRd1TCQwFf9RGfwddNXWz0uFU9ztymylOhRS";
	private String clientSecret = "EGnHDxD_qRPdaLdZz8iCr8N7_MzF-YHPTkjs6NKYQvQSBngp4PTTVWkPZRbL";
	private APIContext context;
	private Payment payment;
	
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

	public PayPalApiCall(String clientId, String clientSecret, APIContext context, Payment payment){
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.context = new APIContext(clientId, clientSecret, "sandbox");
		this.payment = payment;
	}
	
	public void fetchPaymentById(){
		try {
			this.payment = Payment.get(context, "PAY-4T698276NC427425EK5QIV7Y");
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
		System.out.println(this.payment);
	}

}
