package String;

import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;
/*
451   Sort Characters By Frequency
 */
public class SortCharByFrequency {

    public static void main(String[] args) {
        String s = "tree";
        SortCharByFrequency obj = new SortCharByFrequency();
        System.out.println(obj.frequencySort2(s));
    }

    public static String frequencySort(String s) {
        StringBuilder builder = new StringBuilder();

        TreeMap<Character, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (char c : s.toCharArray()) {
            Integer i = map.get(c);
            if (i == null) {
                map.put(c, 1);
            } else {
                map.put(c, i + 1);
            }
        }

        map.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(record -> {
                    Character key = record.getKey();
                    int value = record.getValue();
                    for (int i = 0; i < value; i++) {
                        builder.append(key);
                    }
                });

        return builder.toString();
    }

    static <K, V extends Comparable<? super V>>
    List<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {

        List<Map.Entry<K, V>> sortedEntries = new ArrayList<>(map.entrySet());

        Collections.sort(sortedEntries,
                (e1, e2) -> e2.getValue().compareTo(e1.getValue())
        );

        return sortedEntries;
    }

    public static String frequencySort2(String s) {
        StringBuilder builder = new StringBuilder();

        Hashtable<Character, Integer> count = new Hashtable<>();
        Hashtable<Character, Integer> index = new Hashtable<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (count.containsKey(ch)) {
                count.put(ch, count.get(ch) + 1);
            } else {
                count.put(ch, 1);
                index.put(ch, i);
            }
        }

        List<Element> freq_arr = new ArrayList<>();
        count.forEach((k, v) -> {
            Element temp = new Element();
            temp.ch = k;
            temp.freq = v;
            temp.firstIndex = index.get(k);

            freq_arr.add(temp);
        });

        Collections.sort(freq_arr);

        for (Element e : freq_arr) {
            for (int j = 0; j < e.freq; j++) {
                builder.append(e.ch);
            }
        }
        return builder.toString();
    }
}

class Element implements Comparable<Element> {
    char ch;
    int freq;
    int firstIndex;

    @Override
    public int compareTo(Element e) {
        int compareFreq = e.freq;
        if (this.freq != compareFreq) {
            return compareFreq - this.freq;
        } else {
            return this.firstIndex - e.firstIndex;
        }
    }
}