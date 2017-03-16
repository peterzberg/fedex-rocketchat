package ch.css.fedex.rocketchat;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/message")
public class FakeIncomingWebhook {

	private static final String WEBHOOK_URL = "http://rocketchat:3000/hooks/8BzESGHQqr2yR6ovm/5bwGtXQMdeDQfSbWLCadTSEkmcDNQZrFf62KE5y5dxqhyqAZ";

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response doGet(final Message message) {
		System.out.println("Message received: " + message.getContent());
		Client client = ClientBuilder.newClient();
		final Response response = client.target(WEBHOOK_URL) //
				.request(MediaType.APPLICATION_JSON_TYPE) //
				.accept(MediaType.APPLICATION_JSON_TYPE) //
				.post(Entity.entity(message, MediaType.APPLICATION_JSON_TYPE), Response.class);
		System.out.println("Message transmitted to rocket.chat: " + response.getStatus());
		return Response.ok("Hello from WildFly Swarm!").build();
	}
}