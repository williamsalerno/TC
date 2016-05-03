package br.com.timetrialfactory.model;

import br.com.timetrialfactory.model.entity.Game;

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

}
