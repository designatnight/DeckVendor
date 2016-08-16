package stevesmith.deckvendor.datatype;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Card {

	// @JsonProperty
	private Rank rank;
	// @JsonProperty
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;

	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == Card.class) {
			Card card = (Card) obj;
			if (card.rank == this.rank && card.suit == this.suit) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return rank.getShortName() + "-" + suit.getShortName();
	}

}
