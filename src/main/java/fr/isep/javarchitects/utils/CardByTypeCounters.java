package fr.isep.javarchitects.utils;

import fr.isep.javarchitects.model.Card;

import java.util.List;

/**
 * counter of cards by type in a deck. 
 * Typically in a deck, card are randomly shuffled, but any "intelligent" enough user could maintain counters of already seen cards
 * 
 * this is mostly equivalent to <code> Map<CardType,Integer> </code>
 * 
 * cf corresponding ImmutableCardByTypeCounters
 */
public class CardByTypeCounters {

	// Material cards
	public int materialWoodCount;
	public int materialPaperCount;
	public int materialBrickCount;
	public int materialStoneCount;
	public int materialGlassCount;
	public int materialGoldCount;
	public int getMaterialTotalCount() { 
		return materialWoodCount + materialPaperCount + materialBrickCount + materialStoneCount + materialGlassCount + materialGoldCount; 
	}   
	
	// Science cards
	public int progressLawCount;
	public int progressMechanicCount;
	public int progressArchitectCount;
	public int getProgressTotalCount() { return progressLawCount + progressMechanicCount + progressArchitectCount; }
	
	// War Cards
	public int warBarbarianCardCount;
	public int warCenturionCardCount;
	public int warArcherCardCount;
	public int getWarTotalCount() { 
		return warBarbarianCardCount + warCenturionCardCount + warArcherCardCount; 
	}   

	// Polics Cards
	public int politicEmperorCount;
	public int politicCatCount;
	public int getPoliticTotalCount() {
		return politicEmperorCount + politicCatCount;
	}

	// ------------------------------------------------------------------------
	
	public CardByTypeCounters(List<Card> cards) {
		if (cards != null && !cards.isEmpty()) {
			for(Card card: cards) {
				setIncr(card, 1);
			}
		}
	}

	public CardByTypeCounters(ImmutableCardByTypeCounts src) {
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
	
	// ------------------------------------------------------------------------
	

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

	public void setIncr(Card cardType, int by) {
		switch(cardType) {
		case CardMaterialWood: this.materialWoodCount += by; break;
		case CardMaterialPaper: this.materialPaperCount += by; break;
		case CardMaterialBrick: this.materialBrickCount += by; break;
		case CardMaterialStone: this.materialStoneCount += by; break;
		case CardMaterialGlass: this.materialGlassCount += by; break;
		case CardMaterialGold: this.materialGoldCount += by; break;
		// Science cards
		case CardScienceLaw: this.progressLawCount += by; break;
		case CardScienceMechanic: this.progressMechanicCount += by; break;
		case CardScienceArchitect: this.progressArchitectCount += by; break;
		// War Cards
		case CardWar_barbarian: this.warBarbarianCardCount += by; break;
		case CardWar_centurion: this.warCenturionCardCount += by; break;
		case CardWar_archer: this.warArcherCardCount += by; break;
		// Polics Cards
		case CardPolitic_emperor: this.politicEmperorCount += by; break;
		case CardPolitic_cat: this.politicEmperorCount += by; break;
		default: throw new IllegalStateException();
		}
	}

	public ImmutableCardByTypeCounts toImmutable() {
		return new ImmutableCardByTypeCounts(this);
	}
	
}
