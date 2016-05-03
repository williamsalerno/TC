package br.com.timetrialfactory.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Cart {

    private List<Item> items = new ArrayList<Item>();
    private BigDecimal total = new BigDecimal("0.0");

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void add(Item item) {
        items.add(item);
        total = total.plus().add(item.getGame().getPrice());
    }

    public Integer getTotalItems() {
        return items.size();
    }

}
