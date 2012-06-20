package lemon.tool.validation.entities;

import lemon.tool.validation.annotation.NotNull;
import lemon.tool.validation.annotation.StringPattern;

public class Foo {
	@NotNull
	private String name;
	@NotNull
	private int id;
	@StringPattern("D.*")
	private String doo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoo() {
		return doo;
	}
	public void setDoo(String doo) {
		this.doo = doo;
	}

}
