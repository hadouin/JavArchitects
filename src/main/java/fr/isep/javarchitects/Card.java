package fr.isep.javarchitects;

public class Card {

	public final CardType front;
	public final CardBack back;
	
	/*pp*/ Card(CardType front, CardBack back) {
		this.front = front;
		this.back = back;
	}

	public Card piocherUneCarte(Card[] deck) {
		Card carte = deck[0];
		return carte;
	}

	public CardType getFront() {
		return front;
	}

	public CardBack getBack() {
		return back;
	}
}
