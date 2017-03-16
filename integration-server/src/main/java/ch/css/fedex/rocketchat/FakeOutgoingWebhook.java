package ch.css.fedex.rocketchat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/menu")
public class FakeOutgoingWebhook {
	private static final String SV_SERVICE_URL_LUZERN = "http://css-luzern.sv-restaurant.ch/de.html";

    @GET
    @Produces("application/json")
    public Response doGet() {
        System.out.println("Menu asked");
        try {
            final Menu menu = new Menu();
            Document doc = Jsoup.connect(SV_SERVICE_URL_LUZERN).get();
            Elements menuElement = doc.select("#content > div.content-container > div.content-col > div.html-menu > div.menu-plan-content > div.offer > div.menu-description");
            for (Element element : menuElement) {
                Element titleElement = element.getElementsByClass("title").get(0);
                Element trimmingsElement = element.getElementsByClass("trimmings").get(0);
                menu.addOffer(titleElement.text() + " - " + trimmingsElement.text());
            }
            return Response.ok(menu).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }

    }


}