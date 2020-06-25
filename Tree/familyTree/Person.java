package Tree.familyTree;

public class Person {
    String name;
    Gender gender;
    PartnerShip partnerShip;
    Person myFather;
    Person myMother;

    public Person(String name, Gender gender) {
        this.name = name;
        this.partnerShip = new PartnerShip();
        this.gender = gender;
        this.myFather = null;
        this.myMother = null;
    }

    public void setMother(Person mother){
        this.myMother=mother;
    }
    public void setFather(Person father){
        this.myFather=father;
    }
}
