package org.gardencorporation;

import org.gardencorporation.entities.CustomerCard;
import org.gardencorporation.entities.OfferCheck;

public class OfferCheckService {

    public OfferCheckService() {

    }

    public void addOfferCheck(OfferCheck offerCheck) {
        DAO<OfferCheck> offerCheckDAO = new DAO<>();
        DAO<CustomerCard> customerCardDAO = new DAO<>();

        offerCheckDAO.create(offerCheck);
        CustomerCard customerCard = offerCheck.getOwner();
        customerCard.addPoints(SaleService.pointsCalculation(offerCheck.getValue()));

        customerCardDAO.update(customerCard);
    }

}
