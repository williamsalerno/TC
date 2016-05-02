package br.com.timetrialfactory.test;

import java.math.BigDecimal;

import br.com.caelum.vraptor.Resource;
import br.com.timetrialfactory.dao.GameDAO;
import br.com.timetrialfactory.model.entity.Game;

@Resource
public class InsertGameTest {

//    public static void main(String[] args) {
//        Game game = createGame();
//        new GameDAO().insert(game);
//    }

    private static Game createGame() {
        BigDecimal price = new BigDecimal("20.95");
        Game game = new Game();
        game.setTitle("Disruption3");
        game.setPrice(price);
        return game;
    }

}
