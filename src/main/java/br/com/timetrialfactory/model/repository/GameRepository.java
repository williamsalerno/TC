package br.com.timetrialfactory.model.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.timetrialfactory.model.entity.Game;

@RequestScoped
public class GameRepository {

    @Inject
    private Session session;

    private Criteria createCriteria() {
        return this.session.createCriteria(Game.class);
    }

    @SuppressWarnings("unchecked")
    public List<Game> list() {
        return createCriteria().list();
    }

}
