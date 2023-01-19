package fr.isep.javarchitects.core;

import fr.isep.javarchitects.model.DeckModel;

import java.util.ArrayList;
import java.util.List;

public class Wonder {
	public final String displayName;
	public final String frenchName;
	public final String effectDescription;
	public final int ID;
	private List<WonderFragment> wonderFragments;
	private DeckFactory deckFactory;

	// ------------------------------------------------------------------------

	Wonder(int id,
		   String displayName,
		   String frenchName,
		   String effectDescription,
		   DeckFactory deckFactory,
		   List<WonderFragment> wonderFragments
		   ) {
		this.displayName = displayName;
		this.frenchName = frenchName;
		this.effectDescription = effectDescription;
		this.ID = id;
		this.deckFactory = deckFactory;
		this.wonderFragments = new ArrayList<>(wonderFragments);
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

	public List<WonderFragment> getWonderFragments() {
		int size = this.wonderFragments.size();
		return this.wonderFragments;
	}

	/**
	 * @param floorNumber floor to check
	 * @return if fragments of the previous floor are built
	 */
    public boolean isFloorOpen(int floorNumber) {
		if (floorNumber == 0){
			return true;
		}
		List<WonderFragment> previousFloorNotbuiltFragments = wonderFragments.stream()
				.filter(fragment -> !fragment.getIsBuilt() && fragment.getFloorNumber() == floorNumber - 1).toList();
		return previousFloorNotbuiltFragments.isEmpty();
	}

	@Override
	public String toString() {
		return "Wonder{" +
				"displayName='" + displayName + '\'' +
				", wonderFragments=" + wonderFragments +
				'}';
	}

	public DeckModel createDeck() {
		return deckFactory.createDeck();
	}
}