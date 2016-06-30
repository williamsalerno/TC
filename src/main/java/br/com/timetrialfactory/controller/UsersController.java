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

	@Post("/users")
	public void add(final User user) {
		if (dao.userExists(user)) {
			validator.add(new ValidationMessage(" message.userExists", "message.error"));
		}
		validator.onErrorUsePageOf(this).newUser(user);
		dao.insert(user);
		validator.add(new ValidationMessage("message.success", "1"));
		validator.onErrorRedirectTo(this).loginForm();
	}

	@Get("/users/selectCountry")
	public void selectCountry() {
	}

	@Get("/users/new")
	public User newUser(User user) {
		return user;
	}

	@Get("/login")
	public void loginForm() {
	}

	@Post("/login")
	public void login(User user) {
		User loaded = dao.load(user);
		if (loaded == null) {
			validator.add(new ValidationMessage(" message.invalidCredential", "message.error"));
		}
		validator.onErrorUsePageOf(this).loginForm();
		userWeb.login(loaded);
		result.redirectTo(GamesController.class).list();
	}

	@Restrict
	@Path("/logout")
	public void logout() {
		userWeb.logout();
		result.redirectTo(this).loginForm();
	}

}
