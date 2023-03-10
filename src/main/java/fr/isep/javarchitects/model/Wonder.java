package fr.isep.javarchitects.model;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

import java.util.List;

public class Wonder {
	public final String displayName;
	public final String frenchName;
	public final String effectDescription;
	public final int ID;
	private final ObservableList<WonderFragment> wonderFragments = FXCollections.observableArrayList(new Callback<WonderFragment, Observable[]>() {
		@Override
		public Observable[] call(WonderFragment wonderFragment) {
			return new Observable[] {wonderFragment.builtProperty()};
		}
	});
	private final DeckFactory deckFactory;

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
		this.wonderFragments.setAll(wonderFragments);
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
		List<WonderFragment> previousFloorNotBuiltFragments = wonderFragments.stream()
				.filter(fragment -> {
					boolean isUnderFloor = fragment.getFloorNumber() == floorNumber - 1;
					return isUnderFloor && !fragment.isBuilt();
				}).toList();
		return previousFloorNotBuiltFragments.isEmpty();
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

	public ObservableList<WonderFragment> getWonderFragmentList(){
		return wonderFragments;
	}
}