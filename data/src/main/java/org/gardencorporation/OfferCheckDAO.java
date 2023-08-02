package org.gardencorporation;

import java.util.ArrayList;
import java.util.List;

public class OfferCheckDAO implements DAO<OfferCheck> {

    private ArrayList<OfferCheck> offerCheckList = new ArrayList<>();
    
    public OfferCheckDAO() {
        offerCheckList = Helper.readObj(OfferCheck.ENTITY_PATH, offerCheckList);
    }
    
    @Override
    public void add(OfferCheck t) {
        offerCheckList.add(t);
        Helper.saveObj(OfferCheck.ENTITY_PATH, offerCheckList);
    }

    @Override
    public List<OfferCheck> getAll() {
        return offerCheckList;
    }
    
}
