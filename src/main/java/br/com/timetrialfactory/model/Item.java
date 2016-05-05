package br.com.timetrialfactory.model;

import br.com.timetrialfactory.model.entity.Game;

public class Item {

    private Game game;
    private String quantity;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
