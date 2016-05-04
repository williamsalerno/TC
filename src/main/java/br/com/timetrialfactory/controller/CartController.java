package br.com.timetrialfactory.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.timetrialfactory.dao.GameDAO;
import br.com.timetrialfactory.model.Cart;
import br.com.timetrialfactory.model.Item;

@Resource
public class CartController {

    private final Cart cart;
    private final GameDAO dao;
    private final Result result;

    public CartController(Cart cart, GameDAO dao, Result result) {
        this.cart = cart;
        this.dao = dao;
        this.result = result;
    }

    @Get("/cart")
    public void view() {
    }

    @Post("/cart")
    public void add(Item item) {
        dao.recharge(item.getGame());
        cart.add(item);
        result.redirectTo(this).view();
    }

    @Delete("/cart/{itemIndex}")
    public void remove(int itemIndex) {
        cart.remove(itemIndex);
        result.redirectTo(this).view();
    }
}
