package br.com.timetrialfactory.model.entity.enums;

public enum Country {

	BRAZIL("BRAZIL"), OTHER("OTHER");

	private Country(String name) {
	}

	public String getName(){
		return this.name();
	}
}
