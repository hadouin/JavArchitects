package fr.isep.javarchitects.core;

import com.google.common.collect.ImmutableList;
import fr.isep.javarchitects.utils.images.Icons;

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

	public static ImmutableList<Material> allExceptGolds() {
		return ImmutableList.of(Wood, Paper, Brick, Stone, Glass);
	}
}
