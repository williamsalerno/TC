package br.com.timetrialfactory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.timetrialfactory.model.entity.License;

@Component
public class LicenseDAO {
	
	  private final Session session;
	  
	    public LicenseDAO(Session session) {
	        this.session = session;
	    }
	    
	    public void insertLicense(License license){
	        Transaction tx = session.beginTransaction();
	        this.session.save(license);
	        tx.commit();
	        session.clear();
	    }

}
