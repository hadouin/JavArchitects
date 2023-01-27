package fr.isep.javarchitects.utils;

import fr.isep.javarchitects.model.Card;

import java.util.List;

/**
 * cf MutableCardByTypeCounters
 * 
 */
public class ImmutableCardByTypeCounts {

	// Material cards
	public final int materialWoodCount;
	public final int materialPaperCount;
	public final int materialBrickCount;
	public final int materialStoneCount;
	public final int materialGlassCount;
	public final int materialGoldCount;
	public int getMaterialTotalCount() { 
		return materialWoodCount + materialPaperCount + materialBrickCount + materialStoneCount + materialGlassCount + materialGoldCount; 
	}   
	
	// Science cards
	public final int progressLawCount;
	public final int progressMechanicCount;
	public final int progressArchitectCount;
	public int getProgressTotalCount() { return progressLawCount + progressMechanicCount + progressArchitectCount; }   
	
	// War Cards
	public final int warBarbarianCardCount;
	public final int warCenturionCardCount;
	public final int warArcherCardCount;
	public int getWarTotalCount() { 
		return warBarbarianCardCount + warCenturionCardCount + warArcherCardCount; 
	}   

	// Polics Cards
	public final int politicEmperorCount;
	public final int politicCatCount;
	public int getPoliticTotalCount() {
		return politicEmperorCount + politicCatCount;
	}
	
	// ------------------------------------------------------------------------
	
	public ImmutableCardByTypeCounts(List<Card> cards) {
		this(new CardByTypeCounters(cards));
	}
	
	public ImmutableCardByTypeCounts(CardByTypeCounters src) {
		this.materialWoodCount = src.materialWoodCount;
		this.materialPaperCount = src.materialPaperCount;
		this.materialBrickCount = src.materialBrickCount;
		this.materialStoneCount = src.materialStoneCount;
		this.materialGlassCount = src.materialGlassCount;
		this.materialGoldCount = src.materialGoldCount;
		this.progressLawCount = src.progressLawCount;
		this.progressMechanicCount = src.progressMechanicCount;
		this.progressArchitectCount = src.progressArchitectCount;
		this.warBarbarianCardCount = src.warBarbarianCardCount;
		this.warCenturionCardCount = src.warCenturionCardCount;
		this.warArcherCardCount = src.warArcherCardCount;
		this.politicEmperorCount = src.politicEmperorCount;
		this.politicCatCount = src.politicCatCount;
	}

	public int get(Card cardType) {
		switch(cardType) {
			case CardMaterialWood: return materialWoodCount;
			case CardMaterialPaper: return materialPaperCount;
			case CardMaterialBrick: return materialBrickCount;
			case CardMaterialStone: return materialStoneCount;
			case CardMaterialGlass: return materialGlassCount;
			case CardMaterialGold: return materialGoldCount;
			// Science cards
			case CardScienceLaw: return progressLawCount;
			case CardScienceMechanic: return progressMechanicCount;
			case CardScienceArchitect: return progressArchitectCount;
			// War Cards
			case CardWar_barbarian: return warBarbarianCardCount;
			case CardWar_centurion: return warCenturionCardCount;
			case CardWar_archer: return warArcherCardCount;
			// Polics Cards
			case CardPolitic_emperor: return politicEmperorCount;
			case CardPolitic_cat: return politicEmperorCount;
			default: throw new IllegalStateException();
		}
	}
	
}
