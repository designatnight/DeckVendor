package stevesmith.deckvendor.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Singleton;

import stevesmith.deckvendor.datatype.Card;
import stevesmith.deckvendor.datatype.RankAceLow;
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
	public Deck createStandardDeck(String name) {
		List<Card> cards = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (RankAceLow rank : RankAceLow.values()) {
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
		if (decks.containsKey(deckName)) {
			return decks.get(deckName);
		}
		return null;
	}

	public List<Deck> getDecks() {
		List<Deck> deckList = new ArrayList<Deck>();
		decks.values().forEach((deck) -> deckList.add(deck));
		return deckList;
	}

	public void deleteDeck(String deckName) {
		if (decks.containsKey(deckName)) {
			decks.remove(deckName);
		}
	}
}
