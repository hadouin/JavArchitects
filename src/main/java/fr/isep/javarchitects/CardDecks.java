package fr.isep.javarchitects;

import java.util.Arrays;
import java.util.List;

public class CardDecks {

	public static class CardTypeQuantity {
		public final int quantity;
		public final CardType cardType;
		public CardTypeQuantity(int quantity, CardType cardType) {
			this.quantity = quantity;
			this.cardType = cardType;
		}
	}
	
	/** Card Types x Quantities for Gizeh Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Gizeh = Arrays.asList(new CardTypeQuantity[] {
			// material
			new CardTypeQuantity(2, CardType.CardMaterialWood), //
			new CardTypeQuantity(2, CardType.CardMaterialPaper), //
			new CardTypeQuantity(1, CardType.CardMaterialBrick), // 2-1
			new CardTypeQuantity(2, CardType.CardMaterialStone), //
			new CardTypeQuantity(2, CardType.CardMaterialGlass), //
			new CardTypeQuantity(3, CardType.CardMaterialGold), // 2+1
			// science
			new CardTypeQuantity(1, CardType.CardScienceLaw), // 
			new CardTypeQuantity(1, CardType.CardScienceMechanic), // 
			new CardTypeQuantity(2, CardType.CardScienceArchitect), // 
			// war
			new CardTypeQuantity(2, CardType.CardWar_barbarian), // 
			new CardTypeQuantity(2, CardType.CardWar_centurion), // 
			new CardTypeQuantity(0, CardType.CardWar_archer), // 0 ! 
			// politics
			new CardTypeQuantity(2, CardType.CardPolitic_emperor), // 
			new CardTypeQuantity(3, CardType.CardPolitic_cat), // 
	});

	/** Card Types x Quantities for Rhodes Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Rhodes = Arrays.asList(new CardTypeQuantity[] {
			// material
			new CardTypeQuantity(2, CardType.CardMaterialWood), //
			new CardTypeQuantity(2, CardType.CardMaterialPaper), //
			new CardTypeQuantity(2, CardType.CardMaterialBrick), //
			new CardTypeQuantity(2, CardType.CardMaterialStone), //
			new CardTypeQuantity(2, CardType.CardMaterialGlass), //
			new CardTypeQuantity(2, CardType.CardMaterialGold), //
			// science
			new CardTypeQuantity(1, CardType.CardScienceLaw), // 
			new CardTypeQuantity(2, CardType.CardScienceMechanic), // 
			new CardTypeQuantity(1, CardType.CardScienceArchitect), // 
			// war
			new CardTypeQuantity(2, CardType.CardWar_barbarian), // 
			new CardTypeQuantity(2, CardType.CardWar_centurion), // 
			new CardTypeQuantity(1, CardType.CardWar_archer), // 
			// politics
			new CardTypeQuantity(2, CardType.CardPolitic_emperor), // 
			new CardTypeQuantity(2, CardType.CardPolitic_cat), // 
	});

	/** Card Types x Quantities for Babylon Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Babylon = Arrays.asList(new CardTypeQuantity[] {
			// material
			new CardTypeQuantity(2, CardType.CardMaterialWood), //
			new CardTypeQuantity(2, CardType.CardMaterialPaper), //
			new CardTypeQuantity(2-1, CardType.CardMaterialBrick), // 2-1
			new CardTypeQuantity(2, CardType.CardMaterialStone), //
			new CardTypeQuantity(2, CardType.CardMaterialGlass), //
			new CardTypeQuantity(2+1, CardType.CardMaterialGold), // 2+1
			// science
			new CardTypeQuantity(1, CardType.CardScienceLaw), // 
			new CardTypeQuantity(2, CardType.CardScienceMechanic), // 
			new CardTypeQuantity(2, CardType.CardScienceArchitect), // 
			// war
			new CardTypeQuantity(1, CardType.CardWar_barbarian), // 
			new CardTypeQuantity(2, CardType.CardWar_centurion), // 
			new CardTypeQuantity(1, CardType.CardWar_archer), // 
			// politics
			new CardTypeQuantity(2, CardType.CardPolitic_emperor), // 
			new CardTypeQuantity(2, CardType.CardPolitic_cat), // 
	});
	
	/** Card Types x Quantities for Halicarnasse Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Halicarnasse = Arrays.asList(new CardTypeQuantity[] {
			// material
			new CardTypeQuantity(2, CardType.CardMaterialWood), //
			new CardTypeQuantity(1, CardType.CardMaterialPaper), // 2-1
			new CardTypeQuantity(2, CardType.CardMaterialBrick), //
			new CardTypeQuantity(2, CardType.CardMaterialStone), //
			new CardTypeQuantity(2, CardType.CardMaterialGlass), //
			new CardTypeQuantity(3, CardType.CardMaterialGold), // 2+1
			// science
			new CardTypeQuantity(2, CardType.CardScienceLaw), // 
			new CardTypeQuantity(1, CardType.CardScienceMechanic), // 
			new CardTypeQuantity(1, CardType.CardScienceArchitect), // 
			// war
			new CardTypeQuantity(2, CardType.CardWar_barbarian), // 
			new CardTypeQuantity(2, CardType.CardWar_centurion), // 
			new CardTypeQuantity(1, CardType.CardWar_archer), // 
			// politics
			new CardTypeQuantity(2, CardType.CardPolitic_emperor), // 
			new CardTypeQuantity(2, CardType.CardPolitic_cat), // 
	});

	/** Card Types x Quantities for Alexandrie Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Alexandrie = Arrays.asList(new CardTypeQuantity[] {
			// material
			new CardTypeQuantity(2, CardType.CardMaterialWood), //
			new CardTypeQuantity(2, CardType.CardMaterialPaper), //
			new CardTypeQuantity(2, CardType.CardMaterialBrick), //
			new CardTypeQuantity(2, CardType.CardMaterialStone), //
			new CardTypeQuantity(1, CardType.CardMaterialGlass), // 2-1
			new CardTypeQuantity(4, CardType.CardMaterialGold), // 2+2
			// science
			new CardTypeQuantity(1, CardType.CardScienceLaw), // 
			new CardTypeQuantity(2, CardType.CardScienceMechanic), // 
			new CardTypeQuantity(1, CardType.CardScienceArchitect), // 
			// war
			new CardTypeQuantity(1, CardType.CardWar_barbarian), // 
			new CardTypeQuantity(2, CardType.CardWar_centurion), // 
			new CardTypeQuantity(1, CardType.CardWar_archer), // 
			// politics
			new CardTypeQuantity(2, CardType.CardPolitic_emperor), // 
			new CardTypeQuantity(2, CardType.CardPolitic_cat), // 
	});

	/** Card Types x Quantities for Ephese Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Ephese = Arrays.asList(new CardTypeQuantity[] {
			// material
			new CardTypeQuantity(2, CardType.CardMaterialWood), //
			new CardTypeQuantity(2, CardType.CardMaterialPaper), //
			new CardTypeQuantity(2, CardType.CardMaterialBrick), //
			new CardTypeQuantity(2, CardType.CardMaterialStone), //
			new CardTypeQuantity(2, CardType.CardMaterialGlass), //
			new CardTypeQuantity(3, CardType.CardMaterialGold), // 2+1
			// science
			new CardTypeQuantity(2, CardType.CardScienceLaw), // 
			new CardTypeQuantity(1, CardType.CardScienceMechanic), // 
			new CardTypeQuantity(2, CardType.CardScienceArchitect), // 
			// war
			new CardTypeQuantity(1, CardType.CardWar_barbarian), // 
			new CardTypeQuantity(2, CardType.CardWar_centurion), // 
			new CardTypeQuantity(1, CardType.CardWar_archer), // 
			// politics
			new CardTypeQuantity(1, CardType.CardPolitic_emperor), // 
			new CardTypeQuantity(2, CardType.CardPolitic_cat), // 
	});

	/** Card Types x Quantities for Olympie Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Olympie = Arrays.asList(new CardTypeQuantity[] {
			// material
			new CardTypeQuantity(1, CardType.CardMaterialWood), // 2-1
			new CardTypeQuantity(2, CardType.CardMaterialPaper), //
			new CardTypeQuantity(2, CardType.CardMaterialBrick), //
			new CardTypeQuantity(2, CardType.CardMaterialStone), //
			new CardTypeQuantity(2, CardType.CardMaterialGlass), //
			new CardTypeQuantity(3, CardType.CardMaterialGold), // 2+1
			// science
			new CardTypeQuantity(2, CardType.CardScienceLaw), // 
			new CardTypeQuantity(1, CardType.CardScienceMechanic), // 
			new CardTypeQuantity(1, CardType.CardScienceArchitect), // 
			// war
			new CardTypeQuantity(2, CardType.CardWar_barbarian), // 
			new CardTypeQuantity(2, CardType.CardWar_centurion), // 
			new CardTypeQuantity(1, CardType.CardWar_archer), // 
			// politics
			new CardTypeQuantity(1, CardType.CardPolitic_emperor), // 
			new CardTypeQuantity(3, CardType.CardPolitic_cat), // 
	});

	/** Card Types x Quantities for extra Question Deck */
	public static final List<CardTypeQuantity> deckCardQuantities_Extra = Arrays.asList(new CardTypeQuantity[] {
			// material
			new CardTypeQuantity(4, CardType.CardMaterialWood), //
			new CardTypeQuantity(4, CardType.CardMaterialPaper), //
			new CardTypeQuantity(4, CardType.CardMaterialBrick), //
			new CardTypeQuantity(4, CardType.CardMaterialStone), //
			new CardTypeQuantity(4, CardType.CardMaterialGlass), //
			new CardTypeQuantity(6, CardType.CardMaterialGold), //
			// science
			new CardTypeQuantity(4, CardType.CardScienceLaw), // 
			new CardTypeQuantity(4, CardType.CardScienceMechanic), // 
			new CardTypeQuantity(4, CardType.CardScienceArchitect), // 
			// war
			new CardTypeQuantity(4, CardType.CardWar_barbarian), // 
			new CardTypeQuantity(4, CardType.CardWar_centurion), // 
			new CardTypeQuantity(2, CardType.CardWar_archer), // 
			// politics
			new CardTypeQuantity(4, CardType.CardPolitic_emperor), // 
			new CardTypeQuantity(8, CardType.CardPolitic_cat), // 
	});
}
