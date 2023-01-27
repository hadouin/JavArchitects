package fr.isep.javarchitects.model;

import fr.isep.javarchitects.utils.images.CardImage;
import javafx.scene.image.Image;

public enum CardBack {

	Extra(CardImage.BACK_CENTER), //
	Alexandrie(CardImage.BACK_ALEXANDRIA), //
	Halicarnassus(CardImage.BACK_HALICARNASSUS),
	Ephesus(CardImage.BACK_EPHESUS), //
	Olympia(CardImage.BACK_OLYMPIA), //,
	Babylon(CardImage.BACK_BABYLON), //
	Rhodes(CardImage.BACK_RHODES), //
	Gizeh(CardImage.BACK_GIZEH); //

	public final Image image;

	CardBack(CardImage cardImage) {
		this.image = cardImage.image;
	}
	
}
