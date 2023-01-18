package fr.isep.javarchitects.core;

import java.util.Arrays;
import java.util.List;

public class CardDecks {

	public static class CardQuantityType {
		public final int quantity;
		public final Card card;
		public CardQuantityType(int quantity, Card card) {
			this.quantity = quantity;
			this.card = card;
		}

		public int getQuantity() {
			return quantity;
		}

		public Card getCardType() {
			return card;
		}


	}
	
	/** Card Types x Quantities for Gizeh Deck */
	public static final List<CardQuantityType> deckCardQuantities_Gizeh = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(2, Card.CardMaterialWood), //
			new CardQuantityType(2, Card.CardMaterialPaper), //
			new CardQuantityType(1, Card.CardMaterialBrick), // 2-1
			new CardQuantityType(2, Card.CardMaterialStone), //
			new CardQuantityType(2, Card.CardMaterialGlass), //
			new CardQuantityType(3, Card.CardMaterialGold), // 2+1
			// science
			new CardQuantityType(1, Card.CardScienceLaw), //
			new CardQuantityType(1, Card.CardScienceMechanic), //
			new CardQuantityType(2, Card.CardScienceArchitect), //
			// war
			new CardQuantityType(2, Card.CardWar_barbarian), //
			new CardQuantityType(2, Card.CardWar_centurion), //
			new CardQuantityType(0, Card.CardWar_archer), // 0 !
			// politics
			new CardQuantityType(2, Card.CardPolitic_emperor), //
			new CardQuantityType(3, Card.CardPolitic_cat), //
	});



	/** Card Types x Quantities for Rhodes Deck */
	public static final List<CardQuantityType> deckCardQuantities_Rhodes = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(2, Card.CardMaterialWood), //
			new CardQuantityType(2, Card.CardMaterialPaper), //
			new CardQuantityType(2, Card.CardMaterialBrick), //
			new CardQuantityType(2, Card.CardMaterialStone), //
			new CardQuantityType(2, Card.CardMaterialGlass), //
			new CardQuantityType(2, Card.CardMaterialGold), //
			// science
			new CardQuantityType(1, Card.CardScienceLaw), //
			new CardQuantityType(2, Card.CardScienceMechanic), //
			new CardQuantityType(1, Card.CardScienceArchitect), //
			// war
			new CardQuantityType(2, Card.CardWar_barbarian), //
			new CardQuantityType(2, Card.CardWar_centurion), //
			new CardQuantityType(1, Card.CardWar_archer), //
			// politics
			new CardQuantityType(2, Card.CardPolitic_emperor), //
			new CardQuantityType(2, Card.CardPolitic_cat), //
	});

	/** Card Types x Quantities for Babylon Deck */
	public static final List<CardQuantityType> deckCardQuantities_Babylon = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(2, Card.CardMaterialWood), //
			new CardQuantityType(2, Card.CardMaterialPaper), //
			new CardQuantityType(2-1, Card.CardMaterialBrick), // 2-1
			new CardQuantityType(2, Card.CardMaterialStone), //
			new CardQuantityType(2, Card.CardMaterialGlass), //
			new CardQuantityType(2+1, Card.CardMaterialGold), // 2+1
			// science
			new CardQuantityType(1, Card.CardScienceLaw), //
			new CardQuantityType(2, Card.CardScienceMechanic), //
			new CardQuantityType(2, Card.CardScienceArchitect), //
			// war
			new CardQuantityType(1, Card.CardWar_barbarian), //
			new CardQuantityType(2, Card.CardWar_centurion), //
			new CardQuantityType(1, Card.CardWar_archer), //
			// politics
			new CardQuantityType(2, Card.CardPolitic_emperor), //
			new CardQuantityType(2, Card.CardPolitic_cat), //
	});
	
	/** Card Types x Quantities for Halicarnasse Deck */
	public static final List<CardQuantityType> deckCardQuantities_Halicarnassus = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(2, Card.CardMaterialWood), //
			new CardQuantityType(1, Card.CardMaterialPaper), // 2-1
			new CardQuantityType(2, Card.CardMaterialBrick), //
			new CardQuantityType(2, Card.CardMaterialStone), //
			new CardQuantityType(2, Card.CardMaterialGlass), //
			new CardQuantityType(3, Card.CardMaterialGold), // 2+1
			// science
			new CardQuantityType(2, Card.CardScienceLaw), //
			new CardQuantityType(1, Card.CardScienceMechanic), //
			new CardQuantityType(1, Card.CardScienceArchitect), //
			// war
			new CardQuantityType(2, Card.CardWar_barbarian), //
			new CardQuantityType(2, Card.CardWar_centurion), //
			new CardQuantityType(1, Card.CardWar_archer), //
			// politics
			new CardQuantityType(2, Card.CardPolitic_emperor), //
			new CardQuantityType(2, Card.CardPolitic_cat), //
	});

	/** Card Types x Quantities for Alexandrie Deck */
	public static final List<CardQuantityType> deckCardQuantities_Alexandria = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(2, Card.CardMaterialWood), //
			new CardQuantityType(2, Card.CardMaterialPaper), //
			new CardQuantityType(2, Card.CardMaterialBrick), //
			new CardQuantityType(2, Card.CardMaterialStone), //
			new CardQuantityType(1, Card.CardMaterialGlass), // 2-1
			new CardQuantityType(4, Card.CardMaterialGold), // 2+2
			// science
			new CardQuantityType(1, Card.CardScienceLaw), //
			new CardQuantityType(2, Card.CardScienceMechanic), //
			new CardQuantityType(1, Card.CardScienceArchitect), //
			// war
			new CardQuantityType(1, Card.CardWar_barbarian), //
			new CardQuantityType(2, Card.CardWar_centurion), //
			new CardQuantityType(1, Card.CardWar_archer), //
			// politics
			new CardQuantityType(2, Card.CardPolitic_emperor), //
			new CardQuantityType(2, Card.CardPolitic_cat), //
	});

	/** Card Types x Quantities for Ephese Deck */
	public static final List<CardQuantityType> deckCardQuantities_Ephesus = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(2, Card.CardMaterialWood), //
			new CardQuantityType(2, Card.CardMaterialPaper), //
			new CardQuantityType(2, Card.CardMaterialBrick), //
			new CardQuantityType(2, Card.CardMaterialStone), //
			new CardQuantityType(2, Card.CardMaterialGlass), //
			new CardQuantityType(3, Card.CardMaterialGold), // 2+1
			// science
			new CardQuantityType(2, Card.CardScienceLaw), //
			new CardQuantityType(1, Card.CardScienceMechanic), //
			new CardQuantityType(2, Card.CardScienceArchitect), //
			// war
			new CardQuantityType(1, Card.CardWar_barbarian), //
			new CardQuantityType(2, Card.CardWar_centurion), //
			new CardQuantityType(1, Card.CardWar_archer), //
			// politics
			new CardQuantityType(1, Card.CardPolitic_emperor), //
			new CardQuantityType(2, Card.CardPolitic_cat), //
	});

	/** Card Types x Quantities for Olympie Deck */
	public static final List<CardQuantityType> deckCardQuantities_Olympia = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(1, Card.CardMaterialWood), // 2-1
			new CardQuantityType(2, Card.CardMaterialPaper), //
			new CardQuantityType(2, Card.CardMaterialBrick), //
			new CardQuantityType(2, Card.CardMaterialStone), //
			new CardQuantityType(2, Card.CardMaterialGlass), //
			new CardQuantityType(3, Card.CardMaterialGold), // 2+1
			// science
			new CardQuantityType(2, Card.CardScienceLaw), //
			new CardQuantityType(1, Card.CardScienceMechanic), //
			new CardQuantityType(1, Card.CardScienceArchitect), //
			// war
			new CardQuantityType(2, Card.CardWar_barbarian), //
			new CardQuantityType(2, Card.CardWar_centurion), //
			new CardQuantityType(1, Card.CardWar_archer), //
			// politics
			new CardQuantityType(1, Card.CardPolitic_emperor), //
			new CardQuantityType(3, Card.CardPolitic_cat), //
	});

	/** Card Types x Quantities for extra Question Deck */
	public static final List<CardQuantityType> deckCardQuantities_Extra = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(4, Card.CardMaterialWood), //
			new CardQuantityType(4, Card.CardMaterialPaper), //
			new CardQuantityType(4, Card.CardMaterialBrick), //
			new CardQuantityType(4, Card.CardMaterialStone), //
			new CardQuantityType(4, Card.CardMaterialGlass), //
			new CardQuantityType(6, Card.CardMaterialGold), //
			// science
			new CardQuantityType(4, Card.CardScienceLaw), //
			new CardQuantityType(4, Card.CardScienceMechanic), //
			new CardQuantityType(4, Card.CardScienceArchitect), //
			// war
			new CardQuantityType(4, Card.CardWar_barbarian), //
			new CardQuantityType(4, Card.CardWar_centurion), //
			new CardQuantityType(2, Card.CardWar_archer), //
			// politics
			new CardQuantityType(4, Card.CardPolitic_emperor), //
			new CardQuantityType(8, Card.CardPolitic_cat), //
	});

}
