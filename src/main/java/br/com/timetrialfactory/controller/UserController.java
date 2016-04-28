package br.com.timetrialfactory.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.timetrialfactory.model.repository.UserRepository;

@Controller
@Path("/users")
public class UserController {

    @Inject
    private Result result;

    @Inject
    private UserRepository userRepository;

    @Get
    @Path("/list")
    public void listAllUsers() {
        result.use(Results.json()).withoutRoot().from(userRepository.list()).serialize();
    }

}
