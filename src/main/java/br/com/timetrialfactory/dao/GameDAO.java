package br.com.timetrialfactory.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.timetrialfactory.model.entity.Game;

@Component
public class GameDAO {

    private final Session session;

    public GameDAO(Session session) {
        this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<Game> listAll() {
        return this.session.createCriteria(Game.class).list();
    }

    public void insert(Game game) {
        Transaction tx = session.beginTransaction();
        this.session.save(game);
        tx.commit();
    }

    public Game load(Long id) {
        return (Game) this.session.get(Game.class, id);
    }

    public void update(Game game) {
        Transaction tx = session.beginTransaction();
        this.session.update(game);
        tx.commit();
    }

    public void delete(Game game) {
        Transaction tx = session.beginTransaction();
        this.session.delete(game);
        tx.commit();
    }

    @SuppressWarnings("unchecked")
    public List<Game> search(String title) {
        return session.createCriteria(Game.class).add(Restrictions.ilike("title", title, MatchMode.ANYWHERE)).list();
    }

    public void recharge(Game game) {
        session.refresh(game);

    }

}
