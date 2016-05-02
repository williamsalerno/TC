package br.com.timetrialfactory.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.timetrialfactory.dao.GameDAO;
import br.com.timetrialfactory.model.entity.Game;

@Resource
public class GamesController {

    private final GameDAO dao;
    private final Result result;
    private final Validator validator;

    public GamesController(GameDAO dao, Result result, Validator validator) {
        this.dao = dao;
        this.result = result;
        this.validator = validator;
    }

    @Get("/games")
    public List<Game> list() {
        return dao.listAll();
    }

    @Post("/games")
    public void add(final Game game) {
        validator.validate(game);
        validator.onErrorUsePageOf(GamesController.class).form();
        dao.insert(game);
        this.result.redirectTo(this).list();
    }

    @Get("/games/{id}")
    public Game edit(Long id) {
        return dao.load(id);
    }

    @Put("/games/{game.id}")
    public void change(Game game) {
        validator.validate(game);
        validator.onErrorUsePageOf(GamesController.class).edit(game.getId());
        dao.update(game);
        this.result.redirectTo(this).list();
    }

    @Get("/games/new")
    public void form() {

    }

}
