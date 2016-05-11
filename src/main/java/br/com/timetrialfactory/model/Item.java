package br.com.timetrialfactory.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.caelum.vraptor.ioc.Component;
import br.com.timetrialfactory.model.entity.Game;

@Component
public class Item {

	private Game game;
	private Integer quantity;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.game).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Item other;
		if (!(obj instanceof Item)) {
			return false;
		}
		other = (Item) obj;
		return new EqualsBuilder().append(this.game, other.game).isEquals();
	}

}
