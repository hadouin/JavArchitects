package fr.isep.javarchitects;

public enum ProgressToken {

	Urbanism("urbanism", "urbanisme", //
			"Lorsque vous prenez une carte grise 'bois' ou 'brique', " //
			+ "choisissez 1 carte suppl�mentaire parmi les 3 disponibles et posez-la devant vous", //
			"token-culture.png"),
	
	ArtsAndCrafts("Arts and crafts", "artisanat", //
			"Lorsque vous prenez une carte grise 'papier' ou 'verre', " //
			+ "choisissez 1 carte suppl�mentaire parmi les 3 disponibles et posez-la devant vous", //
			"token-artsAndCrafts.png"),
	
	Jewelry("jewelry", "joaillerie", //
			"Lorsque vous prenez une carte grise 'pierre' ou une carte jaune, " //
			+ "choisissez 1 carte suppl�mentaire parmi les 3 disponibles et posez-la devant vous", //
			"token-jewelry.png"),
	
	Science("science", "science", //
			"Lorsque vous prenez une carte verte, " // 
			+ "choisissez 1 carte suppl�mentaire parmi les 3 disponibles et posez-la devant vous", //
			"token-science.png"),
	
	Propaganda("propaganda", "propagande", // 
			"Lorsque vous prenez une carte Rouge avec 1 ou 2 ic�nes 'corne', " //
			+ "choisissez 1 carte suppl�mentaire parmi les 3 disponibles et posez-la devant vous", //
			"token-propaganda.png"),
	
	Architecture("architecture", "architecture", // 
			"Lorsque vous construisez un �tape, " // 
			+ "choisissez 1 carte parmi les 3 disponibles et posez-la devant vous", //
			"token-architecture.png"),
	
	Economy("economy", "�conomie", // 
			"1 carte jaune en votre possession vous offre 2 pi�ces au lieu d'une seule", //
			"token-economy.png"), 
	
	Ingeniery("ingeniery", "ing�nierie", //
			"Lorsque vous construisez un �tape, " 
			+ "vous pouvez utiliser n'importe quelle ressource sans tenir compte de la restriction 'identique' ou 'diff�rente'", //
			"token-ingeniery.png"),
	
	Tactic("tactic", "tactique", //
			"Ajoutez 2 Boucliers � votre total de Boucliers", //
			"token-tactic.png"),

	Decoration("decoration", "d�coration", //
			"A la fin de la partie, " // 
			+ "gagnez 4 Points de victoire si votre Merveille est encore en construction, " //
			+ "ou 6 Points de victoire si vous avez termin� sa construction", //
			"token-decoration.png"),
	
	Politic("politic", "politique", //
			"A la fin de la partie, " // 
			+ "gagnez 1 Point de victoire par �cone 'chat', pr�sente sur vos cartes bleues", //
			"token-politic.png"),

	Strategy("strategy", "strat�gie", //
			"A la fin de la partie, " //
			+ "gagnez 1 Point de victoire par jeton militaire en votre possession", //
			"token-strategy.png"),
	
	Education("education", "�ducation", //
			"A la fin de la partie, " // 
			+ "gagnez 2 Points de victoire par jeton de Progr�s en votre possession (celui-ci y compris)", //
			"token-education.png"),

	Culture("culture", "culture", // 
			"Ce jeton est pr�sent en 2 exemplaires. A la fin de la partie, " //
			+ " gagnez 4 Points de victoire si vous poss�dez 1, ou 12 Points de victoire si vous poss�dez les 2", //
			"token-culture.png");
	
	// ------------------------------------------------------------------------
	
	public final String displayName;

	public final String frenchName;
	
	public final String effectDescription; // in french
	
	public final String imageResource;
	
	// ------------------------------------------------------------------------
	
	private ProgressToken(String displayName, String frenchName, String effectDescription, String imageResource) {
		this.displayName = displayName;
		this.frenchName = frenchName;
		this.effectDescription = effectDescription;
		this.imageResource = "images/tokens-progress/" + imageResource;
	}

}
