package br.com.timetrialfactory.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.timetrialfactory.model.repository.GameRepository;

@Controller
@Path("/games")
public class GameController {

    @Inject
    private Result result;

    @Inject
    private GameRepository gameRepository;

    @Get
    @Path("/gamesList")
    public void listAllGames() {
        result.use(Results.json()).withoutRoot().from(gameRepository.list()).serialize();
    }

}
