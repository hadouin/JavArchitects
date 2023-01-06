package fr.isep.javarchitects.model;

import java.util.Arrays;
import java.util.List;

public class CardDecks {

	public static class CardQuantityType {
		public final int quantity;
		public final CardType cardType;
		public CardQuantityType(int quantity, CardType cardType) {
			this.quantity = quantity;
			this.cardType = cardType;
		}

		public int getQuantity() {
			return quantity;
		}

		public CardType getCardType() {
			return cardType;
		}


	}
	
	/** Card Types x Quantities for Gizeh Deck */
	public static final List<CardQuantityType> deckCardQuantities_Gizeh = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(2, CardType.CardMaterialWood), //
			new CardQuantityType(2, CardType.CardMaterialPaper), //
			new CardQuantityType(1, CardType.CardMaterialBrick), // 2-1
			new CardQuantityType(2, CardType.CardMaterialStone), //
			new CardQuantityType(2, CardType.CardMaterialGlass), //
			new CardQuantityType(3, CardType.CardMaterialGold), // 2+1
			// science
			new CardQuantityType(1, CardType.CardScienceLaw), //
			new CardQuantityType(1, CardType.CardScienceMechanic), //
			new CardQuantityType(2, CardType.CardScienceArchitect), //
			// war
			new CardQuantityType(2, CardType.CardWar_barbarian), //
			new CardQuantityType(2, CardType.CardWar_centurion), //
			new CardQuantityType(0, CardType.CardWar_archer), // 0 !
			// politics
			new CardQuantityType(2, CardType.CardPolitic_emperor), //
			new CardQuantityType(3, CardType.CardPolitic_cat), //
	});



	/** Card Types x Quantities for Rhodes Deck */
	public static final List<CardQuantityType> deckCardQuantities_Rhodes = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(2, CardType.CardMaterialWood), //
			new CardQuantityType(2, CardType.CardMaterialPaper), //
			new CardQuantityType(2, CardType.CardMaterialBrick), //
			new CardQuantityType(2, CardType.CardMaterialStone), //
			new CardQuantityType(2, CardType.CardMaterialGlass), //
			new CardQuantityType(2, CardType.CardMaterialGold), //
			// science
			new CardQuantityType(1, CardType.CardScienceLaw), //
			new CardQuantityType(2, CardType.CardScienceMechanic), //
			new CardQuantityType(1, CardType.CardScienceArchitect), //
			// war
			new CardQuantityType(2, CardType.CardWar_barbarian), //
			new CardQuantityType(2, CardType.CardWar_centurion), //
			new CardQuantityType(1, CardType.CardWar_archer), //
			// politics
			new CardQuantityType(2, CardType.CardPolitic_emperor), //
			new CardQuantityType(2, CardType.CardPolitic_cat), //
	});

	/** Card Types x Quantities for Babylon Deck */
	public static final List<CardQuantityType> deckCardQuantities_Babylon = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(2, CardType.CardMaterialWood), //
			new CardQuantityType(2, CardType.CardMaterialPaper), //
			new CardQuantityType(2-1, CardType.CardMaterialBrick), // 2-1
			new CardQuantityType(2, CardType.CardMaterialStone), //
			new CardQuantityType(2, CardType.CardMaterialGlass), //
			new CardQuantityType(2+1, CardType.CardMaterialGold), // 2+1
			// science
			new CardQuantityType(1, CardType.CardScienceLaw), //
			new CardQuantityType(2, CardType.CardScienceMechanic), //
			new CardQuantityType(2, CardType.CardScienceArchitect), //
			// war
			new CardQuantityType(1, CardType.CardWar_barbarian), //
			new CardQuantityType(2, CardType.CardWar_centurion), //
			new CardQuantityType(1, CardType.CardWar_archer), //
			// politics
			new CardQuantityType(2, CardType.CardPolitic_emperor), //
			new CardQuantityType(2, CardType.CardPolitic_cat), //
	});
	
	/** Card Types x Quantities for Halicarnasse Deck */
	public static final List<CardQuantityType> deckCardQuantities_Halicarnasse = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(2, CardType.CardMaterialWood), //
			new CardQuantityType(1, CardType.CardMaterialPaper), // 2-1
			new CardQuantityType(2, CardType.CardMaterialBrick), //
			new CardQuantityType(2, CardType.CardMaterialStone), //
			new CardQuantityType(2, CardType.CardMaterialGlass), //
			new CardQuantityType(3, CardType.CardMaterialGold), // 2+1
			// science
			new CardQuantityType(2, CardType.CardScienceLaw), //
			new CardQuantityType(1, CardType.CardScienceMechanic), //
			new CardQuantityType(1, CardType.CardScienceArchitect), //
			// war
			new CardQuantityType(2, CardType.CardWar_barbarian), //
			new CardQuantityType(2, CardType.CardWar_centurion), //
			new CardQuantityType(1, CardType.CardWar_archer), //
			// politics
			new CardQuantityType(2, CardType.CardPolitic_emperor), //
			new CardQuantityType(2, CardType.CardPolitic_cat), //
	});

	/** Card Types x Quantities for Alexandrie Deck */
	public static final List<CardQuantityType> deckCardQuantities_Alexandrie = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(2, CardType.CardMaterialWood), //
			new CardQuantityType(2, CardType.CardMaterialPaper), //
			new CardQuantityType(2, CardType.CardMaterialBrick), //
			new CardQuantityType(2, CardType.CardMaterialStone), //
			new CardQuantityType(1, CardType.CardMaterialGlass), // 2-1
			new CardQuantityType(4, CardType.CardMaterialGold), // 2+2
			// science
			new CardQuantityType(1, CardType.CardScienceLaw), //
			new CardQuantityType(2, CardType.CardScienceMechanic), //
			new CardQuantityType(1, CardType.CardScienceArchitect), //
			// war
			new CardQuantityType(1, CardType.CardWar_barbarian), //
			new CardQuantityType(2, CardType.CardWar_centurion), //
			new CardQuantityType(1, CardType.CardWar_archer), //
			// politics
			new CardQuantityType(2, CardType.CardPolitic_emperor), //
			new CardQuantityType(2, CardType.CardPolitic_cat), //
	});

	/** Card Types x Quantities for Ephese Deck */
	public static final List<CardQuantityType> deckCardQuantities_Ephese = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(2, CardType.CardMaterialWood), //
			new CardQuantityType(2, CardType.CardMaterialPaper), //
			new CardQuantityType(2, CardType.CardMaterialBrick), //
			new CardQuantityType(2, CardType.CardMaterialStone), //
			new CardQuantityType(2, CardType.CardMaterialGlass), //
			new CardQuantityType(3, CardType.CardMaterialGold), // 2+1
			// science
			new CardQuantityType(2, CardType.CardScienceLaw), //
			new CardQuantityType(1, CardType.CardScienceMechanic), //
			new CardQuantityType(2, CardType.CardScienceArchitect), //
			// war
			new CardQuantityType(1, CardType.CardWar_barbarian), //
			new CardQuantityType(2, CardType.CardWar_centurion), //
			new CardQuantityType(1, CardType.CardWar_archer), //
			// politics
			new CardQuantityType(1, CardType.CardPolitic_emperor), //
			new CardQuantityType(2, CardType.CardPolitic_cat), //
	});

	/** Card Types x Quantities for Olympie Deck */
	public static final List<CardQuantityType> deckCardQuantities_Olympie = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(1, CardType.CardMaterialWood), // 2-1
			new CardQuantityType(2, CardType.CardMaterialPaper), //
			new CardQuantityType(2, CardType.CardMaterialBrick), //
			new CardQuantityType(2, CardType.CardMaterialStone), //
			new CardQuantityType(2, CardType.CardMaterialGlass), //
			new CardQuantityType(3, CardType.CardMaterialGold), // 2+1
			// science
			new CardQuantityType(2, CardType.CardScienceLaw), //
			new CardQuantityType(1, CardType.CardScienceMechanic), //
			new CardQuantityType(1, CardType.CardScienceArchitect), //
			// war
			new CardQuantityType(2, CardType.CardWar_barbarian), //
			new CardQuantityType(2, CardType.CardWar_centurion), //
			new CardQuantityType(1, CardType.CardWar_archer), //
			// politics
			new CardQuantityType(1, CardType.CardPolitic_emperor), //
			new CardQuantityType(3, CardType.CardPolitic_cat), //
	});

	/** Card Types x Quantities for extra Question Deck */
	public static final List<CardQuantityType> deckCardQuantities_Extra = Arrays.asList(new CardQuantityType[] {
			// material
			new CardQuantityType(4, CardType.CardMaterialWood), //
			new CardQuantityType(4, CardType.CardMaterialPaper), //
			new CardQuantityType(4, CardType.CardMaterialBrick), //
			new CardQuantityType(4, CardType.CardMaterialStone), //
			new CardQuantityType(4, CardType.CardMaterialGlass), //
			new CardQuantityType(6, CardType.CardMaterialGold), //
			// science
			new CardQuantityType(4, CardType.CardScienceLaw), //
			new CardQuantityType(4, CardType.CardScienceMechanic), //
			new CardQuantityType(4, CardType.CardScienceArchitect), //
			// war
			new CardQuantityType(4, CardType.CardWar_barbarian), //
			new CardQuantityType(4, CardType.CardWar_centurion), //
			new CardQuantityType(2, CardType.CardWar_archer), //
			// politics
			new CardQuantityType(4, CardType.CardPolitic_emperor), //
			new CardQuantityType(8, CardType.CardPolitic_cat), //
	});

}
