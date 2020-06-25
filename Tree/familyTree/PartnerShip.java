package Tree.familyTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartnerShip {
    HashMap<Person, Person> partner;
    List<Person> children;

    public PartnerShip() {
        partner = new HashMap<>();
        this.children = new ArrayList<>();
    }

    public void makePartners(Person groom, Person bride){
        this.partner.put(groom,bride);
        this.partner.put(bride,groom);
    }
}
