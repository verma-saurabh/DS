package Tree.familyTree;

import java.util.List;

public class Relationship {
    private RelationType relationshipType;
    private List<Person> personList;

    public Relationship(RelationType type) {
        this.relationshipType=type;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }
    public RelationType getRelationshipType(){
        return relationshipType;
    }
}
