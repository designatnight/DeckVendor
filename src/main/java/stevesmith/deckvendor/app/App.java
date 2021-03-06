package stevesmith.deckvendor.app;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import stevesmith.deckvendor.resource.HttpController;
import stevesmith.deckvendor.service.DeckService;

public class App {

	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://localhost:8080/myapp/";

	private static volatile HttpServer SERVER = null;

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 */
	public static HttpServer startServer() {
		// create a resource config that scans for JAX-RS resources and
		// providers
		// in com.example package
		final ResourceConfig rc = new ResourceConfig().packages("stevesmith.deckvendor.resource.")
				.register(new AbstractBinder() {

					@Override
					protected void configure() {
						bindAsContract(DeckService.class);
						bind(HttpController.class);
					}
				});

		// create and start a new instance of grizzly http server
		// exposing the Jersey application at BASE_URI
		return SERVER = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		startServer();
		System.out.println(String.format(
				"Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
				BASE_URI));
		System.in.read();
		stopServer();
	}

	public static void stopServer() {
		SERVER.stop();
		SERVER = null;
	}
}
