package Tree.familyTree;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FamilyTreeTest {

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        BufferedReader reader;
        String line;

        try {
            reader = new BufferedReader(
                    new FileReader(System.getProperty("user.dir")
                            + "/src/main/java/Tree/familyTree/"
                            + "family.txt"));

            while ((line = reader.readLine()) != null) {
                String[] command = line.split("\\|");
                switch (command[0].trim()) {
                    case "CreatePerson":
                        familyTree.addPerson(command);
                        break;
                    case "Marry":
                        Person spouse1 = familyTree.getPerson(command[1]);
                        Person spouse2 = familyTree.getPerson(command[2]);
                        familyTree.marry(spouse1, spouse2);
                        break;
                    case "Add_Child":
                        Person mother = familyTree.getPerson(command[1]);
                        Person child = familyTree.getPerson(command[2]);
                        familyTree.addChild(mother, child);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        familyTree.processRelationships();
        display(familyTree);
        System.out.println(familyTree);


    }

    public static void display(FamilyTree tree) {


        for (Map.Entry<Person, Set<Relationship>> entry : tree.directRelationships.entrySet()) {
            Person person = entry.getKey();

            System.out.println(" Person " + person.name);
            Set<Relationship> relationships = entry.getValue();
            for (Relationship relation : relationships) {
                System.out.println("\t" + relation.getRelationshipType());

                List<Person> personList = relation.getPersonList();

                for (Person members : personList) {
                    if (members!=null)System.out.println("\t\t" + members.name + " ,");
                }
                System.out.println();
            }
            System.out.println("==========================");
        }

    }
}
