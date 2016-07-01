package br.com.timetrialfactory.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.timetrialfactory.model.entity.Purchase;

@Component
public class PurchaseDAO {

	  private final Session session;
	  
	    public PurchaseDAO(Session session) {
	        this.session = session;
	    }
	    
	    public void insertPurchase(Purchase purchase){
	        Transaction tx = session.beginTransaction();
	        this.session.save(purchase);
	        tx.commit();
	        session.clear();
	    }
	    
	    public Purchase showPurchase(Purchase purchase) {
	        return (Purchase) this.session.get(Purchase.class, (Serializable) purchase);
	    }
	    
	    public void updateSituation(Purchase purchase){
	        Transaction tx = session.beginTransaction();
	        this.session.update(purchase);
	        tx.commit();
	    }
}
