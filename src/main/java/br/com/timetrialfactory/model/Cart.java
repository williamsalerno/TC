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
	private Long totalIds = 0L;
	private Item item;

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
		this.item = item;
		this.items.add(this.item);
		this.total = (this.item.getGame().getPrice()).add(total);
		this.totalIds = this.totalIds + this.item.getGame().getId();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void remove(int itemIndex) {
		this.item = items.remove(itemIndex);
		this.total = total.subtract(this.item.getGame().getPrice());
		this.totalIds = this.totalIds - this.item.getGame().getId();
	}

	public Long getTotalIds() {
		return totalIds;
	}

	public void setTotalIds(Long totalIds) {
		this.totalIds = totalIds;
	}

}
