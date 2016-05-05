package br.com.timetrialfactory.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Cart {

    private List<Item> items = new ArrayList<Item>();
    private BigDecimal total = new BigDecimal("0.0");
    private BigInteger totalItems = new BigInteger("0");

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
        this.items.add(item);
        this.total = (item.getGame().getPrice().multiply(new BigDecimal(item.getQuantity()))).add(total);
        this.totalItems = totalItems.add(new BigInteger(item.getQuantity()));
    }

    public BigInteger getTotalItems() {
        return totalItems;
    }

    public void remove(int itemIndex) {
        Item removed = items.remove(itemIndex);
        this.total = total.subtract(new BigDecimal(removed.getQuantity()).multiply(removed.getGame().getPrice()));

    }

}
