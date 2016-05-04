package br.com.timetrialfactory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.timetrialfactory.model.entity.User;

@Component
public class UserDAO {

    private final Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public boolean userExists(User user) {
        User found = (User) session.createCriteria(User.class).add(Restrictions.eq("login", user.getLogin())).uniqueResult();
        return found != null;
    }

    public void insert(User user) {
        Transaction tx = session.beginTransaction();
        this.session.save(user);
        tx.commit();
    }

    public User load(User user) {
        return (User) this.session.createCriteria(User.class).add(Restrictions.eq("login", user.getLogin())).add(Restrictions.eq("password", user.getPassword())).uniqueResult();
    }
}
