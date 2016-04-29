package br.com.timetrialfactory.test;

import java.math.BigDecimal;

import br.com.timetrialfactory.dao.GameDAO;
import br.com.timetrialfactory.model.entity.Game;

public class InsertGameTest {

    public static void main(String[] args) {
        Game game = createGame();
        new GameDAO().insert(game);
    }

    private static Game createGame() {
        BigDecimal price = new BigDecimal("2.95");
        Game game = new Game();
        game.setTitle("Disruption");
        game.setPrice(price);
        return game;
    }

}
