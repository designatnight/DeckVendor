package stevesmith.deckvendor.resource;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import stevesmith.deckvendor.datatype.Card;
import stevesmith.deckvendor.datatype.RankAceLow;
import stevesmith.deckvendor.datatype.Suit;
import stevesmith.deckvendor.domain.Deck;
import stevesmith.deckvendor.service.DeckService;

//@RunWith(MockitoJUnitRunner.class)
public class HttpControllerTest {

	private String deckName = "test";
	private String mockedName = "mocked";
	private HttpController controller;
	private Deck deck;
	private Deck shuffledDeck;
	private Deck mockedDeck;
	@Mock
	private DeckService deckService;

	@Before
	public void setup() {
		controller = new HttpController();

		deckService = Mockito.mock(DeckService.class);
		mockedDeck = Mockito.mock(Deck.class);

		controller.deckService = deckService;
		deck = createStandardDeck();

		when(deckService.createStandardDeck(anyString())).thenReturn(deck);
		when(deckService.getDeckByName(anyString())).thenReturn(deck);
	}

	@Test
	public void contollerCanCallCreateDeck() {

		deck = controller.createNewDeck(deckName);

		assertNotNull(deck);
		verify(deckService).createStandardDeck(deckName);
	}

	@Test
	public void controllerCanCallDecksShuffleMethod() {

		when(deckService.getDeckByName(mockedName)).thenReturn(mockedDeck);

		controller.shuffleDeck(mockedName);

		verify(mockedDeck).shuffle();
	}

	@Test
	public void controllerCanCallGetDeck() {

		deck = controller.getDeck(deckName);

		assertNotNull(deck);
		verify(deckService).getDeckByName(deckName);
	}

	/*
	 * @Test(expected=error) public void controllerReturns
	 */

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
