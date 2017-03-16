package ch.css.fedex.rocketchat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cssweb on 15.03.17.
 */
public class Menu {
    private List<String> offers = new ArrayList<>();

    public void addOffer(String offer) {
        offers.add(offer);
    }

    public List<String> getOffers() {
        return offers;
    }

    public void setOffers(List<String> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "offers=" + offers +
                '}';
    }
}
