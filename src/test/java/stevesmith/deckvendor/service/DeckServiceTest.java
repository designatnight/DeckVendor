package stevesmith.deckvendor.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import stevesmith.deckvendor.datatype.Card;
import stevesmith.deckvendor.datatype.Rank;
import stevesmith.deckvendor.datatype.Suit;
import stevesmith.deckvendor.domain.Deck;

public class DeckServiceTest {

	private DeckService deckService = new DeckService();
	private Deck deck;
	private String deckName;
	private Card aceOfSpades = new Card(Rank.ACE, Suit.SPADE);
	private Card aceOfHeart = new Card(Rank.ACE, Suit.HEART);
	private Card aceOfClub = new Card(Rank.ACE, Suit.CLUB);
	private Card aceOfDiamonds = new Card(Rank.ACE, Suit.DIAMOND);
	private Card kingOfDiamond = new Card(Rank.KING, Suit.DIAMOND);

	@Before
	public void doSetup() {
		deckName = "test";
	}

	@Test
	public void deckServiceCanCreateStandard52CardDeck() {

		deck = deckService.createStandardDeck(deckName);

		assertEquals(52, deck.getSize());

	}

	@Test
	public void deckServiceCanGetDeckByName() {
		deck = deckService.createStandardDeck(deckName);
		Deck sameDeck = deckService.getDeckByName(deckName);
		assertSame(deck, sameDeck);
	}

}
