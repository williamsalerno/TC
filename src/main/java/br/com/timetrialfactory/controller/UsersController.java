package br.com.timetrialfactory.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.timetrialfactory.annotations.Restrict;
import br.com.timetrialfactory.dao.UserDAO;
import br.com.timetrialfactory.infra.UserWeb;
import br.com.timetrialfactory.model.entity.User;

@Resource
public class UsersController {

	private final UserWeb userWeb;
	private final UserDAO dao;
	private final Result result;
	private final Validator validator;

	public UsersController(UserWeb userWeb, UserDAO dao, Result result, Validator validator) {
		this.userWeb = userWeb;
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	@Restrict
	@Post("/users")
	public void add(final User user) {
		if (dao.userExists(user)) {
			validator.add(new ValidationMessage(" Usuário já existe", "Erro "));
		}
		validator.onErrorUsePageOf(this).newUser();
		dao.insert(user);
		result.redirectTo(GamesController.class).list();
	}

	@Get("/users/selectCountry")
	public void selectCountry() {
	}

	@Get("/users/new")
	public void newUser() {
	}

	@Get("/login")
	public void loginForm() {
	}

	@Restrict
	@Post("/login")
	public void login(User user) {
		User loaded = dao.load(user);
		if (loaded == null) {
			validator.add(new ValidationMessage("Login e/ou senha inválido.", "Erro!"));
		}
		validator.onErrorUsePageOf(this).loginForm();
		userWeb.login(loaded);
		result.redirectTo(GamesController.class).list();
	}

	@Restrict
	@Path("/logout")
	public void logout() {
		userWeb.logout();
		result.redirectTo(GamesController.class).list();
	}
}
