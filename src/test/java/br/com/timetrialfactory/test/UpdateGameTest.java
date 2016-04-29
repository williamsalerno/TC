package br.com.timetrialfactory.test;

import java.math.BigDecimal;

import br.com.timetrialfactory.dao.GameDAO;
import br.com.timetrialfactory.model.entity.Game;

public class UpdateGameTest {

    public static void main(String[] args) {

        Game game = updateGame("Teste", new BigDecimal("20"));
        new GameDAO().update(game);
    }

    private static Game updateGame(String title, BigDecimal price) {
        Game game = new Game();
        game.setTitle(title);
        game.setPrice(price);
        return null;

    }

}
