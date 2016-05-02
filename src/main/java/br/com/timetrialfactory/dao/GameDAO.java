package br.com.timetrialfactory.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
        return (Game) this.session.load(Game.class, id);
    }

    public void update(Game game) {
        Transaction tx = session.beginTransaction();
        this.session.update(game);
        tx.commit();
    }

}
