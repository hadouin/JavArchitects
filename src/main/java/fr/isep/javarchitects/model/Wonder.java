package fr.isep.javarchitects.model;

import java.util.Arrays;
import java.util.List;

public enum Wonder {

	Alexandrie(0,"Alexandrie", "Alexandrie", //
			"Prenez la premi�re carte d'une pioche au choix, n'importe o� sur la table, et posez-la devant vous",
			Arrays.asList(
					new WonderFragment("images/wonders/alexandrie/piece-front-alexandrie-1.png", "images/wonders/alexandrie/piece-back-alexandrie-1.png", 0, false ),
					new WonderFragment("images/wonders/alexandrie/piece-front-alexandrie-2.png", "images/wonders/alexandrie/piece-back-alexandrie-2.png", 1, true ),
					new WonderFragment("images/wonders/alexandrie/piece-front-alexandrie-3.png", "images/wonders/alexandrie/piece-back-alexandrie-3.png", 2, false ),
					new WonderFragment("images/wonders/alexandrie/piece-front-alexandrie-4.png", "images/wonders/alexandrie/piece-back-alexandrie-4.png", 3, true ),
					new WonderFragment("images/wonders/alexandrie/piece-front-alexandrie-5.png", "images/wonders/alexandrie/piece-back-alexandrie-5.png", 4, false )
			)),
	
	Halicarnasse(1,"Halicarnasse", "Halicarnasse", //
			"Prenez les 5 premi�res cartes de la pioche � votre gauche ou � votre droite, choisissez-en 1 et posez-la devant vous" //
			+ "M�langez-les cartes restantes dans leur pioche",
			Arrays.asList(
					new WonderFragment("images/wonders/halicarnasse/piece-front-halicarnasse-1.png", "images/wonders/halicarnasse/piece-back-halicarnasse-1.png", 0, false ),
					new WonderFragment("images/wonders/halicarnasse/piece-front-halicarnasse-2.png", "images/wonders/halicarnasse/piece-back-halicarnasse-2.png", 1, true ),
					new WonderFragment("images/wonders/halicarnasse/piece-front-halicarnasse-3.png", "images/wonders/halicarnasse/piece-back-halicarnasse-3.png", 2, true ),
					new WonderFragment("images/wonders/halicarnasse/piece-front-halicarnasse-4.png", "images/wonders/halicarnasse/piece-back-halicarnasse-4.png", 2, false ),
					new WonderFragment("images/wonders/halicarnasse/piece-front-halicarnasse-5.png", "images/wonders/halicarnasse/piece-back-halicarnasse-5.png", 3, false )
			)),
	
	Ephese(2,"Ephese", "Eph�se", //
			"Prenez la premi�re carte de la pioche centrale et posez-la devant vous",
			Arrays.asList(
					new WonderFragment("images/wonders/ephese/piece-front-ephese-1.png", "images/wonders/ephese/piece-back-ephese-1.png", 0, false ),
					new WonderFragment("images/wonders/ephese/piece-front-ephese-2.png", "images/wonders/ephese/piece-back-ephese-2.png", 1, true ),
					new WonderFragment("images/wonders/ephese/piece-front-ephese-3.png", "images/wonders/ephese/piece-back-ephese-3.png", 1, true ),
					new WonderFragment("images/wonders/ephese/piece-front-ephese-4.png", "images/wonders/ephese/piece-back-ephese-4.png", 1, true ),
					new WonderFragment("images/wonders/ephese/piece-front-ephese-5.png", "images/wonders/ephese/piece-back-ephese-5.png", 2, false )
			)),
	
	Olympie(3,"Olympie", "Olympie", //
			"Prenez la premi�re carte de la pioche � votre cauche et de celle � votre droite, et posez-les devant vous",
			Arrays.asList(
					new WonderFragment("images/wonders/olympie/piece-front-olympie-1.png", "images/wonders/olympie/piece-back-olympie-1.png", 0, false ),
					new WonderFragment("images/wonders/olympie/piece-front-olympie-2.png", "images/wonders/olympie/piece-back-olympie-2.png", 2, true ),
					new WonderFragment("images/wonders/olympie/piece-front-olympie-3.png", "images/wonders/olympie/piece-back-olympie-3.png", 1, false ),
					new WonderFragment("images/wonders/olympie/piece-front-olympie-4.png", "images/wonders/olympie/piece-back-olympie-4.png", 2, true ),
					new WonderFragment("images/wonders/olympie/piece-front-olympie-5.png", "images/wonders/olympie/piece-back-olympie-5.png", 3, false )
			)),
	
	Babylone(4,"Babylone", "Babylone", //
			"Choisissez 1 jeton Progr�s parmi les 4 disponibles, et posez-le devant vous",
			Arrays.asList(
					new WonderFragment("images/wonders/babylon/piece-front-babylon-1.png", "images/wonders/babylon/piece-back-babylon-1.png", 0, false ),
					new WonderFragment("images/wonders/babylon/piece-front-babylon-2.png", "images/wonders/babylon/piece-back-babylon-2.png", 1, true ),
					new WonderFragment("images/wonders/babylon/piece-front-babylon-3.png", "images/wonders/babylon/piece-back-babylon-3.png", 2, false ),
					new WonderFragment("images/wonders/babylon/piece-front-babylon-4.png", "images/wonders/babylon/piece-back-babylon-4.png", 3, false ),
					new WonderFragment("images/wonders/babylon/piece-front-babylon-5.png", "images/wonders/babylon/piece-back-babylon-5.png", 3, true )
			)),
	
	Rhodes(5,"Rhodes", "Rhodes", //
			"Ajoutez 1 Bouclier � votre total de Boucliers",
			Arrays.asList(
					new WonderFragment("images/wonders/rhodes/piece-front-rhodes-1.png", "images/wonders/rhodes/piece-back-rhodes-1.png", 0, false ),
					new WonderFragment("images/wonders/rhodes/piece-front-rhodes-2.png", "images/wonders/rhodes/piece-back-rhodes-2.png", 0, true ),
					new WonderFragment("images/wonders/rhodes/piece-front-rhodes-3.png", "images/wonders/rhodes/piece-back-rhodes-3.png", 1, false ),
					new WonderFragment("images/wonders/rhodes/piece-front-rhodes-4.png", "images/wonders/rhodes/piece-back-rhodes-4.png", 2, true ),
					new WonderFragment("images/wonders/rhodes/piece-front-rhodes-5.png", "images/wonders/rhodes/piece-back-rhodes-5.png", 3, false )
			)),
	
	Gizeh(6,"Gizeh", "Gizeh", //
			"Cette merveille n'a pas d'effet particulier, mais rapporte plus de points de victoire que les autres Merveilles",);

	// ------------------------------------------------------------------------
	
	public final String displayName;
	public final String frenchName;
	public final String effectDescription;
	public final int ID;
	public List<WonderFragment> wonderFragments;
	
	// ------------------------------------------------------------------------
	
	Wonder(int id,
		   String displayName,
		   String frenchName,
		   String effectDescription,
		   List<WonderFragment> wonderFragments) {
		this.displayName = displayName;
		this.frenchName = frenchName;
		this.effectDescription = effectDescription;
		this.ID = id;
		this.wonderFragments = wonderFragments;
	}


	// ---------------------------------------------------------------------------


	public String getDisplayName() {
		return displayName;
	}

	public String getFrenchName() {
		return frenchName;
	}

	public String getEffectDescription() {
		return effectDescription;
	}

	public int getID() {
		return ID;
	}
}