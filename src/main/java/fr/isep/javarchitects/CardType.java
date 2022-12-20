package fr.isep.javarchitects;

/**
 * type of cards
 */
public enum CardType {

	// Material Cards
	CardMaterialWood("material:wood", Material.Wood, "card-material-wood-lumberjack.png"), //
	CardMaterialPaper("material:paper", Material.Paper, "card-material-paper-women.png"), //
	CardMaterialBrick("material:brick", Material.Brick, "card-material-brick-women.png"), //
	CardMaterialStone("material:stone", Material.Stone, "card-material-stone-stonecutter.png"), //
	CardMaterialGlass("material:glass", Material.Glass, "card-material-glass-women.png"), //
	// joker (mandatory replacing any material) 
	CardMaterialGold("material:gold", Material.Gold, "card-material-gold-vizir.png"), //
	
	// Science cards
	CardScienceLaw("science:law", ScienceCategory.Law, "card-progress-law.png"), //
	CardScienceMechanic("science:mechanic", ScienceCategory.Mechanic, "card-progress-mechanic.png"), //
	CardScienceArchitect("science:architect", ScienceCategory.Architect, "card-progress-architect.png"), //
	
	// War Cards
	CardWar_barbarian("war:barbarian", 1, 1, "card-war-barbarian-1corn.png"), //
	CardWar_centurion("war:centurion", 1, 0, "card-war-centurion.png"),  //
	CardWar_archer("war:archer", 1, 2, "card-war-archer-2corns.png"), //

	// Polics Cards
	CardPolitic_emperor("politic:emperor", 3, false, "card-politic-emperor-3laurel.png"), //
	CardPolitic_cat("politic:cat", 2, true, "card-politic-women-2laurel-cat.png") //
	;

	// ------------------------------------------------------------------------
	
	public final String cardDisplayName;
	
	public final CardCategory cardCategory;
	
	/** material of the card, meaningfull only cardCategory==Material */
	public final Material material;

	/** drawing on the card, meaningfull only cardCategory==Science */
	public final ScienceCategory scienceCategory;

	/** number of shields, meaningfull only cardCategory==War */
	public final int shieldCount;
	/** number of corns, meaningfull only cardCategory==War */
	public final int cornCount;
	
	/** number of laurel, meaningfull only cardCategory==Politic */
	public final int laurelCount;
	/** with cat, meaningfull only cardCategory==Politic */
	public final boolean cat;
	
	public final String imageResource;

	// ------------------------------------------------------------------------

	private CardType(String cardDisplayName, CardCategory cardCategory, // 
			Material material, // only when cardCategory==Material
			ScienceCategory scienceCategory, // only when cardCategory==Science
			int shieldCount, int cornCount, // only when cardCategory==War
			int laurelCount, boolean cat, // only when cardCategory==Politic
			String imageResource) {
		this.cardDisplayName = cardDisplayName;
		this.cardCategory = cardCategory;
		this.material = material;
		this.scienceCategory = scienceCategory;
		this.shieldCount = shieldCount;
		this.cornCount = cornCount;
		this.laurelCount = laurelCount;
		this.cat = cat;
		this.imageResource = "images/cards/" + imageResource;
	}
	
	// for Material card
	private CardType(String cardDisplayName, Material material, String imageResource) {
		this(cardDisplayName, CardCategory.MaterialCard, material, null, 0, 0, 0, false, imageResource);
	}
	// for Science card
	private CardType(String cardDisplayName, ScienceCategory scienceCategory, String imageResource) {
		this(cardDisplayName, CardCategory.ProgressCard, null, scienceCategory, 0, 0, 0, false, imageResource);
	}
	// for War card
	private CardType(String cardDisplayName, int shieldCount, int cornCount, String imageResource) {
		this(cardDisplayName, CardCategory.WarCard, null, null, shieldCount, cornCount, 0, false, imageResource);
	}
	// for Politic card
	private CardType(String cardDisplayName, int laurelCount, boolean cat, String imageResource) {
		this(cardDisplayName, CardCategory.PoliticCard, null, null, 0, 0, laurelCount, cat, imageResource);
	}

}
