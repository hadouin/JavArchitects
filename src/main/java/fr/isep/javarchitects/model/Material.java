package fr.isep.javarchitects.model;

import fr.isep.javarchitects.utils.Icons;

public enum Material {
	Wood(Icons.WOOD), //
	Paper(Icons.PAPER), //
	Brick(Icons.CLAY), //
	Stone(Icons.STONE), //
	Glass(Icons.GLASS), //
	Gold(Icons.COIN); //

	public Icons icon;
	Material(Icons icon) {
		this.icon = icon;
	}
}
