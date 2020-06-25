package Tree.familyTree;

import java.util.*;

public class FamilyTree {
    public Map<Person, Set<Relationship>> directRelationships = new HashMap<>();

    public void addPerson(String[] person) {
        Person p = new Person(person[1], Gender.valueOf(Integer.valueOf(person[2])));
        directRelationships.put(p, new HashSet<>());
        System.out.println("Person Added :-"+p.name);
    }

    public void marry(Person personA, Person personB) {
        personA.partnerShip.makePartners(personA, personB);
        personB.partnerShip.makePartners(personB, personA);

        System.out.println(personA.name + " and " + personB.name + " are married now");
    }

    public void addChild(Person mother, Person child) {
        mother.partnerShip.children.add(child);
        child.setMother(mother);
        child.setFather(mother.partnerShip.partner.get(mother));
        child.myFather.partnerShip.children.add(child);

        System.out.println(mother.name + " and " + child.myFather.name + " child is " + child.name);
    }

    public Person getPerson(String name) {
        Person p = null;
        for (Map.Entry<Person, Set<Relationship>> e : directRelationships.entrySet()) {
            if (e.getKey().name.equals(name)) {
                p = e.getKey();
                break;
            }
        }
        return p;
    }

    public void processRelationships() {

        for (Map.Entry<Person, Set<Relationship>> entry : directRelationships.entrySet()) {
            Person person = entry.getKey();
            Set<Relationship> relationships = new HashSet<>();
            for (RelationType r : RelationType.values()) {

                switch (r) {
                    case ParentChild:
                        Relationship parentChild = new Relationship(RelationType.ParentChild);
                        parentChild.setPersonList(getParents(person));
                        relationships.add(parentChild);
                        break;
                    case Spouse:
                        Relationship spouse = new Relationship(RelationType.Spouse);
                        spouse.setPersonList(getSpouse(person));
                        relationships.add(spouse);
                        break;
                    case Sibling:
                        Relationship siblings = new Relationship(RelationType.Sibling);
                        siblings.setPersonList(getSiblings(person));
                        relationships.add(siblings);
                        break;
                    case Sister:
                        Relationship sister = new Relationship(RelationType.Sister);
                        sister.setPersonList(getSiblings(person, Gender.female));
                        relationships.add(sister);
                        break;
                    case Brother:
                        Relationship brother = new Relationship(RelationType.Brother);
                        brother.setPersonList(getSiblings(person, Gender.male));
                        relationships.add(brother);
                        break;
                    case MaternalAunt:
                        Relationship maternalAunt = new Relationship(RelationType.MaternalAunt);
                        maternalAunt.setPersonList(getMaternalAunt(person));
                        relationships.add(maternalAunt);
                        break;
                    case MaternalUncle:
                        Relationship maternalUncle = new Relationship(RelationType.MaternalUncle);
                        maternalUncle.setPersonList(getMaternalUncle(person));
                        relationships.add(maternalUncle);
                        break;
                    case Uncle:
                        Relationship uncle = new Relationship(RelationType.Uncle);
                        uncle.setPersonList(getUncle(person));
                        relationships.add(uncle);
                        break;
                    case Aunt:
                        Relationship aunt = new Relationship(RelationType.Aunt);
                        aunt.setPersonList(getAunt(person));
                        relationships.add(aunt);
                        break;
                    case Cousin:
                        break;
                }
            }
            directRelationships.put(person, relationships);
        }
    }

    public List<Person> getParents(Person person) {
        Person mother = person.myMother;
        Person father = person.myFather;
        List<Person> parents = new ArrayList<>();
        parents.add(mother);
        parents.add(father);
        return parents;
    }

    public List<Person> getSpouse(Person person) {
        List<Person> spouse = new ArrayList<>();
        spouse.add(person.partnerShip.partner.get(person));
        return spouse;
    }

    public List<Person> getSiblings(Person person) {
        Set<Person> siblings = new HashSet<>();

        Person mother = person.myMother;
        Person father = person.myFather;

        if (mother != null) {
            for (Person child : mother.partnerShip.children) {
                siblings.add(child);
            }
        }

        if (father != null) {
            for (Person child : father.partnerShip.children) {
                siblings.add(child);
            }
        }
        siblings.remove(person);
        return new ArrayList<>(siblings);
    }

    public List<Person> getSiblings(Person person, Gender gender) {
        Set<Person> siblings = new HashSet<>();

        Person mother = person.myMother;
        Person father = person.myFather;

        if (mother != null) {
            for (Person child : mother.partnerShip.children) {
                if (child.gender.equals(gender)) {
                    siblings.add(child);
                }
            }
        }
        if (father != null) {
            for (Person child : father.partnerShip.children) {
                if (child.gender.equals(gender)) {
                    siblings.add(child);
                }
            }
        }
        siblings.remove(person);
        return new ArrayList<>(siblings);
    }

    public List<Person> getMaternalUncle(Person person) {
        List<Person> maternalUncle = new ArrayList<>();

        if (person.myMother != null) {
            Person mother = person.myMother;
            if (mother.myMother != null) {
                Person mothersMother = mother.myMother;
                for (Person child : mothersMother.partnerShip.children) {
                    if (child.gender.equals(Gender.male)) {
                        maternalUncle.add(child);
                    }
                }
            }
        }

        return maternalUncle;
    }

    public List<Person> getMaternalAunt(Person person) {
        List<Person> maternalAunt = new ArrayList<>();
        if (person.myMother != null) {
            Person mother = person.myMother;
            if (mother.myMother != null) {
                Person mothersMother = mother.myMother;
                for (Person child : mothersMother.partnerShip.children) {
                    if (child.gender.equals(Gender.female)) {
                        maternalAunt.add(child);
                    }
                }
            }
        }
        maternalAunt.remove(person.myMother);
        return maternalAunt;
    }

    public List<Person> getAunt(Person person) {
        Set<Person> aunt = new HashSet<>();

        if (person.myMother != null) {
            Person mother = person.myMother;
            if (mother.myMother != null) {
                Person mothersMother = mother.myMother;
                for (Person child : mothersMother.partnerShip.children) {
                    if (child.gender.equals(Gender.female)) {
                        aunt.add(child);
                    }
                }
            }
        }
        if (person.myFather != null) {
            Person father = person.myFather;
            if (father.myFather != null) {
                Person fathersFather = father.myMother;
                for (Person child : fathersFather.partnerShip.children) {
                    if (child.gender.equals(Gender.female)) {
                        aunt.add(child);
                    }
                }
            }
        }

        aunt.remove(person.myMother);
        return new ArrayList<>(aunt);
    }

    public List<Person> getUncle(Person person) {
        Set<Person> uncle = new HashSet<>();

        if (person.myMother != null) {
            Person mother = person.myMother;
            if (mother.myMother != null) {
                Person mothersMother = mother.myMother;
                for (Person child : mothersMother.partnerShip.children) {
                    if (child.gender.equals(Gender.male)) {
                        uncle.add(child);
                    }
                }
            }
        }
        if (person.myFather != null) {
            Person father = person.myFather;
            if (father.myFather != null) {
                Person fathersFather = father.myMother;
                for (Person child : fathersFather.partnerShip.children) {
                    if (child.gender.equals(Gender.male)) {
                        uncle.add(child);
                    }
                }
            }
        }

        uncle.remove(person.myFather);
        return new ArrayList<>(uncle);
    }
}
