package stevesmith.deckvendor.datatype;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CardTest {

	Card card = new Card(RankAceLow.ACE, Suit.CLUB);

	@Test
	public void hasRank() {
		RankAceLow rank = card.getRank();
		assertNotNull(rank);

	}

	@Test
	public void hasSuit() {
		Suit suit = card.getSuit();
		assertNotNull(suit);
	}

}
