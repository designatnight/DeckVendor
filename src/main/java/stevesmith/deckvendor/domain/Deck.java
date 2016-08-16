package stevesmith.deckvendor.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import stevesmith.deckvendor.datatype.Card;

@JsonAutoDetect
public class Deck {

	public String name;

	private List<Card> cards;

	public Deck(String name, List<Card> cards) {
		this.cards = cards;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Card getCard(int index) {
		return cards.get(index);
	}

	public List<Card> getCards() {
		return cards;
	}

	public int getSize() {
		return cards.size();
	}

	public Deck shuffle() {
		Collections.shuffle(cards);
		return this;
	}

	public Deck shuffle2() {
		if (cards == null) {
			return this;
		}
		List<Card> shuffledList = new ArrayList<Card>();
		new HashSet<Card>(cards).forEach((card) -> shuffledList.add(card));
		cards = shuffledList;
		return this;
	}

}
