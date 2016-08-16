package stevesmith.deckvendor.domian;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import stevesmith.deckvendor.datatype.Card;
import stevesmith.deckvendor.datatype.Rank;
import stevesmith.deckvendor.datatype.Suit;
import stevesmith.deckvendor.domain.Deck;

public class DeckTest {

	private String deckName;
	private Deck deck;
	private Card aceOfSpades = new Card(Rank.ACE, Suit.SPADE);
	private Card aceOfHeart = new Card(Rank.ACE, Suit.HEART);
	private Card aceOfClub = new Card(Rank.ACE, Suit.CLUB);
	private Card aceOfDiamonds = new Card(Rank.ACE, Suit.DIAMOND);
	private Card kingOfDiamond = new Card(Rank.KING, Suit.DIAMOND);

	@Before
	public void doSetup() {
		deckName = "test";
		deck = createStandardDeck();
	}

	@Test
	public void deckCanShuffleItSelf() {

		deck.shuffle();

		assertThat(aceOfSpades, not(deck.getCard(0)));
		assertThat(aceOfHeart, not(deck.getCard(13)));
		assertThat(aceOfClub, not(deck.getCard(26)));
		assertThat(aceOfDiamonds, not(deck.getCard(39)));
		assertThat(kingOfDiamond, not(deck.getCard(51)));
	}

	/*
	 * @Test public void canShuffleDeckByUsingSet() { deck.shuffle2();
	 * 
	 * assertNotEquals(aceOfSpades, deck.getCard(0));
	 * assertNotEquals(aceOfHeart, deck.getCard(13)); assertNotEquals(aceOfClub,
	 * deck.getCard(26)); assertNotEquals(aceOfDiamonds, deck.getCard(39));
	 * assertNotEquals(kingOfDiamond, deck.getCard(51)); }
	 */

	@Test
	public void canShuffleDeckByUsingSetNullListCheck() {
		Deck deck2 = new Deck("test2", null);
		deck2.shuffle2();
	}

	@Test
	public void canShuffleDeckByUsingSetNullCardsInListCheck() {
		ArrayList<Card> listWithNulls = new ArrayList<Card>();
		listWithNulls.add(null);
		listWithNulls.add(null);
		Deck deck2 = new Deck("test2", listWithNulls);
		deck2.shuffle2();
	}

	@Test
	public void canPassInShuffleingAlgorithm() {

	}

	private Deck createStandardDeck() {
		List<Card> cards = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(rank, suit);
				cards.add(card);
			}
		}
		Deck deck = new Deck(deckName, cards);
		return deck;
	}

}
