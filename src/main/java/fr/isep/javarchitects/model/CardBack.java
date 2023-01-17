package fr.isep.javarchitects.model;

public enum CardBack {

	Extra(null), //
	
	Alexandrie(WonderFactory.Alexandria), //
	Halicarnassus(WonderFactory.Halicarnassus),
	Ephesus(WonderFactory.Ephesus), //
	Olympia(WonderFactory.Olympia), //,
	Babylon(WonderFactory.Babylon), //
	Rhodes(WonderFactory.Rhodes), //
	Gizeh(WonderFactory.Gizeh); //
	
	public final boolean centralDeck;
	// set only when not centralDeck
	public final WonderFactory wonderDeck;
	
	CardBack(WonderFactory wonderDeck) {
		this.centralDeck = (wonderDeck == null);
		this.wonderDeck = wonderDeck;
	}
	
}
