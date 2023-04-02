package com.AutomationFramework;

public enum Locators {
	
	
	ID("ID"),
	NAME("NAME"),
	XPATH("XPATH"),
	CLASSNAME("CLASSNAME"),
	LINKTEXT("LINKTEXT"),
	PARTIALLINKTEXT("PARTIALLINKTEXT"),
	TAGNAME("TAGNAME"),
	CSSSELECTOR("CSSSELECTOR");
	
	
	private String name;	
	
	private Locators(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
