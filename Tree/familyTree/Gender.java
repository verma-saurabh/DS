package Tree.familyTree;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public enum Gender {
    male(0), female(1);

    private static Map map = new HashMap();

    private int value;

    private Gender(int value) {
        this.value = value;
    }

    public static Gender valueOf(int gender) {
        return (Gender) map.get(gender);
    }

    static {
        for (Gender gender : Gender.values()) {
            map.put(gender.value, gender);
        }
    }

}
