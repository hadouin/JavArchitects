package fr.isep.javarchitects;

public enum Wonder {

	Alexandrie("Alexandrie", "Alexandrie", //
			"Prenez la premi�re carte d'une pioche au choix, n'importe o� sur la table, et posez-la devant vous"),
	
	Halicarnasse("Halicarnasse", "Halicarnasse", //
			"Prenez les 5 premi�res cartes de la pioche � votre gauche ou � votre droite, choisissez-en 1 et posez-la devant vous" //
			+ "M�langez-les cartes restantes dans leur pioche"),
	
	Ephese("Ephese", "Eph�se", //
			"Prenez la premi�re carte de la pioche centrale et posez-la devant vous"),
	
	Olympie("Olympie", "Olympie", //
			"Prenez la premi�re carte de la pioche � votre cauche et de celle � votre droite, et posez-les devant vous"),
	
	Babylone("Babylone", "Babylone", //
			"Choisissez 1 jeton Progr�s parmi les 4 disponibles, et posez-le devant vous"),
	
	Rhodes("Rhodes", "Rhodes", //
			"Ajoutez 1 Bouclier � votre total de Boucliers"),
	
	Gizeh("Gizeh", "Gizeh", //
			"Cette merveille n'a pas d'effet particulier, mais rapporte plus de points de victoire que les autres Merveilles");
	
	// ------------------------------------------------------------------------
	
	public final String displayName;
	
	public final String frenchName;
	
	public final String effectDescription;
	
	// ------------------------------------------------------------------------
	
	Wonder(String displayName, String frenchName, String effectDescription) {
		this.displayName = displayName;
		this.frenchName = frenchName;
		this.effectDescription = effectDescription;
	}
}
