package fr.isep.javarchitects.utils;

import fr.isep.javarchitects.core.Card;

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
	
}
