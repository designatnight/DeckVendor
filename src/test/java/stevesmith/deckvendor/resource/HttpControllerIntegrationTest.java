package stevesmith.deckvendor.resource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientProperties;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import stevesmith.deckvendor.app.App;

public class HttpControllerIntegrationTest {

	final String url = "http://localhost:8080/myapp/";
	final String deckName = "test";
	private Client client;
	private WebTarget webTarget;
	private JsonParser jsonParser;

	@Before
	public void setup() {

		client = ClientBuilder.newClient();
		client.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
		webTarget = client.target(url + "deck/" + deckName);
		jsonParser = new JsonParser();
		App.startServer();
	}

	@After
	public void shutdown() {
		App.stopServer();
	}

	@Test
	public void verifyCreateGetAndShuffle() {
		JsonObject aceOfSpades = createNewDeck();
		Assert.assertEquals("ACE", aceOfSpades.get("rank").getAsString());
		Assert.assertEquals("SPADE", aceOfSpades.get("suit").getAsString());

		JsonObject aceOfSpades2 = canGetDeck();
		Assert.assertEquals("ACE", aceOfSpades2.get("rank").getAsString());
		Assert.assertEquals("SPADE", aceOfSpades2.get("suit").getAsString());

		JsonObject firstCard = canShuffleDeck();
		Assert.assertTrue(
				"ACE" != firstCard.get("rank").getAsString() || "SPADE" != firstCard.get("suit").getAsString());

	}

	private JsonObject createNewDeck() {
		Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).put(null);

		JsonObject jsonObject = jsonParser.parse(response.readEntity(String.class)).getAsJsonObject();
		response.close();
		return jsonObject.getAsJsonArray("cards").get(0).getAsJsonObject();
	}

	private JsonObject canShuffleDeck() {

		Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).post(null);
		JsonObject jsonObject = jsonParser.parse(response.readEntity(String.class)).getAsJsonObject();
		response.close();
		return jsonObject.getAsJsonArray("cards").get(0).getAsJsonObject();
	}

	private JsonObject canGetDeck() {
		Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).get();
		JsonObject jsonObject = jsonParser.parse(response.readEntity(String.class)).getAsJsonObject();
		response.close();
		return jsonObject.getAsJsonArray("cards").get(0).getAsJsonObject();
	}

}
