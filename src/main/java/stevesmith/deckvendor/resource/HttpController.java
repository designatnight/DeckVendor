package stevesmith.deckvendor.resource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import stevesmith.deckvendor.domain.Deck;
import stevesmith.deckvendor.service.DeckService;

@Path("/deck/")

@Singleton
public class HttpController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7450503638443942983L;

	@Inject
	public DeckService deckService;

	public HttpController() {

	}

	// Normally I wouldn't make a put create a new object. Usually I would use a
	// post for this, also using a path variable
	// is not in the long term wise, but for now it will work.
	@Path(value = "/{name}")
	@PUT
	@Produces("application/json")
	public Deck createNewDeck(@PathParam("name") String name) {
		return deckService.createStandardDeck(name);
	}

	@Path(value = "{name}")
	@POST
	@Produces("application/json")
	public Deck shuffleDeck(@PathParam("name") String name) {
		Deck deck = deckService.getDeckByName(name);
		deck.shuffle();
		return deck;
	}

	@Path(value = "{name}")
	@GET
	@Produces("application/json")
	public Deck getDeck(@PathParam("name") String name) {
		return deckService.getDeckByName(name).shuffle();
	}

	@Path(value = "")
	@GET
	@Produces("application/json")
	public List<Deck> getDecks() {
		return deckService.getDecks();
	}

	@Path(value = "{name}")
	@DELETE
	@Produces("application/json")
	public void deleteDeck(@PathParam("name") String name) {
		deckService.deleteDeck(name);
	}

}
