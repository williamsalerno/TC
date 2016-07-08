package br.com.timetrialfactory.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class SessionFactoryCreator implements ComponentFactory<SessionFactory> {

	private SessionFactory factory;

	@PostConstruct
	public void openFactory() {
		this.factory = new Configuration().configure().buildSessionFactory();
	}

	public SessionFactory getInstance() {
		return this.factory;
	}

	@PreDestroy
	public void closeFactory() {
		this.factory.close();
	}

}
