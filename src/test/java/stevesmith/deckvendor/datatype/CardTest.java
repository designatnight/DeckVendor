package stevesmith.deckvendor.datatype;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardTest {

	Card card = new Card(Rank.ACE, Suit.CLUB);

	@Test
	public void hasRank() {
		Rank rank = card.getRank();
		assertNotNull(rank);

	}

	@Test
	public void hasSuit() {
		Suit suit = card.getSuit();
		assertNotNull(suit);
	}

	@Test
	public void cardsEqualIfTheyHaveTheSameSuitAndRank() {
		Card aceOfClub = new Card(Rank.ACE, Suit.CLUB);

		assertTrue(card.equals(aceOfClub));
	}
}
