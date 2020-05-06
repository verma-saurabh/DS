package graph;

import java.util.*;

public class WordLadder_II_126 {

    public static void main(String[] args) {
        WordLadder_II_126 obj = new WordLadder_II_126();

        String beignWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        List<List<String>> ans = obj.findLadders(beignWord, endWord, wordList);

        for (List list : ans) {
            System.out.println(list);
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> wordGroups = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String wordGroup = word.substring(0, i) + "*" + word.substring(i + 1);
                wordGroups.computeIfAbsent(wordGroup, wg -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visitedWords = new HashSet<>();
        Map<String, Set<String>> previousWords = new HashMap<>();

        Queue<String> currentWordsQueue = new LinkedList<>();
        currentWordsQueue.add(beginWord);

        boolean foundEndWord = false;
        while (!foundEndWord && !currentWordsQueue.isEmpty()) {
            Queue<String> nextWordsQueue = new LinkedList<>();

            while (!currentWordsQueue.isEmpty()) {
                String currentWord = currentWordsQueue.remove();

                for (int i = 0; i < currentWord.length(); i++) {
                    String currentWordGroup = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1);

                    for (String nextWord : wordGroups.getOrDefault(currentWordGroup, Collections.emptyList())) {
                        if (!nextWord.equals(currentWord) && !visitedWords.contains(nextWord)) {

                            nextWordsQueue.add(nextWord);
                            previousWords.computeIfAbsent(nextWord, w -> new HashSet<>()).add(currentWord);

                            if (nextWord.equals(endWord)) {
                                foundEndWord = true;
                            }
                        }
                    }
                }
            }

            visitedWords.addAll(nextWordsQueue);
            currentWordsQueue = nextWordsQueue;
        }

        if (!foundEndWord) {
            return Collections.emptyList();
        }

        List<List<String>> ladders = new ArrayList<>();

        List<String> ladder = new ArrayList<>();
        ladder.add(endWord);

        buildLadders(beginWord, endWord, previousWords, ladder, ladders);

        return ladders;
    }

    private void buildLadders(String beginWord, String currentWord, Map<String, Set<String>> previousWords, List<String> ladder, List<List<String>> ladders) {
        if (currentWord.equals(beginWord)) {
            List<String> reversedLadder = new ArrayList<>(ladder);
            Collections.reverse(reversedLadder);
            ladders.add(reversedLadder);
            return;
        }

        for (String previousWord : previousWords.get(currentWord)) {
            ladder.add(previousWord);

            buildLadders(beginWord, previousWord, previousWords, ladder, ladders);

            ladder.remove(previousWord);
        }
    }
}
