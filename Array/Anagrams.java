package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Anagrams {
    public static String str = "Mary had a little lamb its fleece was white as snow;\n" +
            "And everywhere that Mary went, the lamb was sure to go.\n" +
            "It followed her to school one day, which was against the rule;\n" +
            "It made the children laugh and play, to see a lamb at school.\n" +
            "And so the teacher turned it out, but still it lingered near,\n" +
            "And waited patiently about till Mary did appear.\n" +
            "\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"";

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        str = str.replace(".", "");
        str = str.replace(";", "");
        str = str.replace(",", "");
        str = str.replaceAll("\"", "");
        str = str.replaceAll("\n", "");
        String[] dict = str.split("\r\n");
        TreeMap<String, Double> map = new TreeMap<>();
        int occurnces = 0;
        while ((line = in.readLine()) != null) {
            //if ((line = in.readLine()) != null) {
            System.out.println(line);
            String[] arr = line.split(",");
            int anagramLength = Integer.parseInt(arr[0]);
            String anagram = arr[1];


            String[] words = str.split(" ");

            Set<String> wordSet = new HashSet<>();

            for (String word : words) {
                wordSet.add(word);
            }

            for (String word : wordSet) {
                int count = 0;
                if (word.length() > anagramLength) {
                    for (int j = 0; j < dict.length; j++) {
                        String[] pieces = dict[j].split(anagram);
                        occurnces = pieces.length - 1;
                        for (int k = 1; k < pieces.length; k++) {
                            if (pieces[k].contains(word)) {
                                count++;
                                Double freq = map.getOrDefault(word.toLowerCase(), 0D);
                                map.put(word, freq + 1D);
                            }

                        }
                    }
                    if (count != 0)
                        map.put(word, map.get(word) / occurnces);
                }


            }


        }

        List<Map.Entry<String, Double>> list = entriesSortedByValues(map);
        System.out.println(list);
    }

    static <K, V extends Comparable<? super V>>
    List<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {

        List<Map.Entry<K, V>> sortedEntries = new ArrayList<>(map.entrySet());

        Collections.sort(sortedEntries,
                (e1, e2) -> e2.getValue().compareTo(e1.getValue())
        );

        return sortedEntries;
    }
}
