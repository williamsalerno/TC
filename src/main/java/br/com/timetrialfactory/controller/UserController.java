package br.com.timetrialfactory.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.timetrialfactory.model.entity.User;
import br.com.timetrialfactory.model.repository.UserRepository;

@Controller
public class UserController {

    @Inject
    private UserRepository userRepository;

    private final User user;

    private Result result;

    public UserController(User user, Result result) {
        this.user = user;
        this.result = result;
    }

    @Path("/list")
    public void listAllUsers() {
        result.use(Results.json()).withoutRoot().from(userRepository.list()).serialize();
    }

    @Post("/register")
    public void register(User user) {
        this.userRepository.addUser(user);
        this.result.redirectTo(this).listAllUsers();
    }

}
