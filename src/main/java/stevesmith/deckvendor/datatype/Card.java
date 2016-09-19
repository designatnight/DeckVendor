package stevesmith.deckvendor.datatype;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Card {

	private RankAceLow rank;
	private Suit suit;

	public Card(RankAceLow rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public RankAceLow getRank() {
		return rank;

	}

	public Suit getSuit() {
		return suit;
	}

	// for convenience overrode this to make debugging easier
	@Override
	public String toString() {
		return rank.getShortName() + "-" + suit.getShortName();
	}

}
