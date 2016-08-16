package stevesmith.deckvendor.resource;

import java.util.List;

import stevesmith.deckvendor.domain.Deck;

public interface DataBase {

	public Deck storeNewDeck(Deck deck);

	public Deck updateDeck(Deck deck);

	public Deck getDeckByName(String name);

	public List<Deck> getAllDecks();

	public void deleteDeck(Deck deck);
}
