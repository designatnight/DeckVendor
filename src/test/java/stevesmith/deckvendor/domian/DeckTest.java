package stevesmith.deckvendor.domian;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import stevesmith.deckvendor.datatype.Card;
import stevesmith.deckvendor.datatype.RankAceLow;
import stevesmith.deckvendor.datatype.Suit;
import stevesmith.deckvendor.domain.Deck;

public class DeckTest {

	private String deckName;
	private Deck deck;
	private Card aceOfSpades = new Card(RankAceLow.ACE, Suit.SPADE);
	private Card aceOfHeart = new Card(RankAceLow.ACE, Suit.HEART);
	private Card aceOfClub = new Card(RankAceLow.ACE, Suit.CLUB);
	private Card aceOfDiamonds = new Card(RankAceLow.ACE, Suit.DIAMOND);
	private Card kingOfDiamond = new Card(RankAceLow.KING, Suit.DIAMOND);

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
	public void reshuffleingAShuffledDeckCreatesNewOrder() {

		deck.shuffle();

		Card card0 = deck.getCard(0);
		Card card13 = deck.getCard(13);
		Card card26 = deck.getCard(26);
		Card card39 = deck.getCard(39);
		Card card51 = deck.getCard(51);

		deck.shuffle();

		assertThat(card0, not(deck.getCard(0)));
		assertThat(card13, not(deck.getCard(13)));
		assertThat(card26, not(deck.getCard(26)));
		assertThat(card39, not(deck.getCard(39)));
		assertThat(card51, not(deck.getCard(51)));

	}

	@Test
	public void canPassInShuffleingAlgorithm() {

		// deck.customeShuffle();
	}

	private Deck createStandardDeck() {
		List<Card> cards = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (RankAceLow rank : RankAceLow.values()) {
				Card card = new Card(rank, suit);
				cards.add(card);
			}
		}
		Deck deck = new Deck(deckName, cards);
		return deck;
	}

}
