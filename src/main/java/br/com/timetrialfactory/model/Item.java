package br.com.timetrialfactory.model;

import br.com.timetrialfactory.model.entity.Game;

public class Item {

	private Game game;
	private Boolean inCart = false;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	protected Boolean getInCart() {
		return inCart;
	}

	protected void setInCart(Boolean inCart) {
		this.inCart = inCart;
	}

}
