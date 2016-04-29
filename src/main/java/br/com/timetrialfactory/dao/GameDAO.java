package br.com.timetrialfactory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.timetrialfactory.model.entity.Game;
import br.com.timetrialfactory.session.SessionCreator;

public class GameDAO {

    private final Session session;
    private final Transaction tx;

    public GameDAO() {
        this.session = SessionCreator.getSession();
        this.tx = session.beginTransaction();
    }

    public void insert(Game game) {
        this.session.save(game);
        this.tx.commit();
    }

    public void update(Game game) {
        game = (Game) this.session.load(Game.class, 1L);
        this.session.update(game);
        this.tx.commit();
    }

}
