package br.com.timetrialfactory.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.timetrialfactory.model.entity.Game;

public class Item {

	private Game game;


	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}


	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.game).toHashCode();
	}
	
	

}
