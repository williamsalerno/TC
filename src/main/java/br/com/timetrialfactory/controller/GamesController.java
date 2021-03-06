package br.com.timetrialfactory.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import br.com.timetrialfactory.annotations.Restrict;
import br.com.timetrialfactory.dao.GameDAO;
import br.com.timetrialfactory.images.Images;
import br.com.timetrialfactory.model.entity.Game;

@Resource
public class GamesController {

    private final GameDAO dao;
    private final Result result;
    private final Validator validator;
    private final Images images;

    public GamesController(GameDAO dao, Result result, Validator validator, Images images) {
        this.dao = dao;
        this.result = result;
        this.validator = validator;
        this.images = images;
    }

    @Get("/games")
    public List<Game> list() {
        return dao.listAll();
    }
    
    @Restrict
    @Post("/games")
    public void add(final Game game) {
        validator.validate(game);
        if (dao.gameExists(game)) {
            validator.add(new ValidationMessage(" Título duplicado na base de dados.", "Erro "));
        }
        validator.onErrorUsePageOf(GamesController.class).form();
        dao.insert(game);
        this.result.redirectTo(this).list();
    }

    @Restrict
    @Get("/games/{id}")
    public Game edit(Long id) {
        return dao.load(id);
    }

    @Restrict
    @Put("/games/{game.id}")
    public void change(Game game) {
        if (dao.gameExists(game)) {
            validator.add(new ValidationMessage(" Título duplicado na base de dados.", "Erro "));
        }
        validator.onErrorUsePageOf(this).edit(game.getId());
        dao.update(game);
        this.result.redirectTo(this).list();

    }

    @Restrict
    @Delete("/games/{id}")
    public void remove(Long id) {
        Game game = dao.load(id);
        dao.delete(game);
        images.delete(game);
        this.result.redirectTo(this).list();
    }

    @Get("/games/search")
    public List<Game> search(String title) {
        result.include("title", title);
        return dao.search(title);
    }

    @Get("/games/search.json")
    public void searchJson(String q) {
        result.use(Results.json()).withoutRoot().from(dao.search(q)).exclude("id").serialize();
    }

    @Restrict
    @Get("/games/new")
    public void form() {

    }

}
