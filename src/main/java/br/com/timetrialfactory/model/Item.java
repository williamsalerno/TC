package br.com.timetrialfactory.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
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
	public boolean equals(Object obj) {
		if (!(obj instanceof Item)) {
			return false;
		}
		Item outra = (Item) obj;
		return new EqualsBuilder().append(this.game, outra.game).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.game).toHashCode();
	}

}
