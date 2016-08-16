package stevesmith.deckvendor.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Singleton;

import stevesmith.deckvendor.datatype.Card;
import stevesmith.deckvendor.datatype.Rank;
import stevesmith.deckvendor.datatype.Suit;
import stevesmith.deckvendor.domain.Deck;

@Singleton
public class DeckService {

	public HashMap<String, Deck> decks;

	public DeckService() {
	}

	/**
	 * creates a standard 52 card deck in order. Suit order: spades hearts clubs
	 * diamonds Rank order: Ace - King
	 * 
	 * @param name
	 * @return
	 */
	// creates a standard 52 card deck in order.
	public Deck createStandardDeck(String name) {
		List<Card> cards = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(rank, suit);
				cards.add(card);
			}
		}
		Deck deck = new Deck(name, cards);
		if (decks == null) {
			decks = new HashMap<>();
		}
		decks.put(deck.getName(), deck);
		return deck;
	}

	public Deck getDeckByName(String deckName) {
		return decks.get(deckName);
	}

	public List<Deck> getDecks() {
		List<Deck> deckList = new ArrayList<Deck>();
		decks.values().forEach((deck) -> deckList.add(deck));
		return deckList;
	}
}
