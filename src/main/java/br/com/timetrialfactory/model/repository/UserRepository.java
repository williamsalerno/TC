package br.com.timetrialfactory.model.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.timetrialfactory.model.entity.User;

@RequestScoped
public class UserRepository {

    @Inject
    private Session session;

    private Criteria createCriteria() {
        return this.session.createCriteria(User.class);
    }

    @SuppressWarnings("unchecked")
    public List<User> list() {
        return createCriteria().list();
    }

}
