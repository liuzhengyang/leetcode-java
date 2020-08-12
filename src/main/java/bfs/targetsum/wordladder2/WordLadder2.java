package bfs.targetsum.wordladder2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 * 类似 word ladder 1, 这次要记录跳转的路径，在bfs过程中，通过一个map来记录prev，最后找到endWord后通过不断寻找prev找出路径
 * @author liuzhengyang
 * 2020/8/12
 */
public class WordLadder2 {
    public static void main(String[] args) {
        WordLadder2 wordLadder2 = new WordLadder2();
        System.out.println(wordLadder2.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return Collections.emptyList();
        }
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Map<String, Set<String>> nextMap = new HashMap<>();
        Set<String> prev = new HashSet<>();
        Set<String> next = new HashSet<>();
        prev.add(beginWord);
        visited.add(beginWord);
        boolean found = false;
        while (!prev.isEmpty()) {
            for (String s : prev) {
                if (s.equals(endWord)) {
                    found = true;
                    break;
                } else {
                    Set<String> adjacentWords = getAdjacentWords(s, wordSet);
                    for (String adj : adjacentWords) {
                        if (!visited.contains(adj)) {
                            nextMap.computeIfAbsent(s, k -> new HashSet<>()).add(adj);
                            next.add(adj);
                        }
                    }
                }
            }
            if (found) {
                break;
            }
            visited.addAll(next);
            prev = next;
            next = new HashSet<>();

        }
        if (!found) {
            return Collections.emptyList();
        } else {
            List<List<String>> result = new ArrayList<>();
            dfsFindPath(beginWord, endWord, nextMap, new LinkedList<>(), result);
            return result;
        }
    }

    private void dfsFindPath(String currentWord, String end, Map<String, Set<String>> graph, LinkedList<String> currentPath, List<List<String>> result) {
        if (currentWord.equals(end)) {
            ArrayList<String> copyPath = new ArrayList<>(currentPath);
            copyPath.add(end);
            result.add(copyPath);
        } else {
            currentPath.add(currentWord);
            Set<String> adjacent = graph.getOrDefault(currentWord, Collections.emptySet());
            for (String adj : adjacent) {
                dfsFindPath(adj, end, graph, currentPath, result);
            }
            currentPath.removeLast();
        }
    }

    private Set<String> getAdjacentWords(String from, Set<String> wordSet) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < from.length(); i++) {
            char[] chars = from.toCharArray();
            for (int j = 0; j < 26; j++) {
                chars[i] = (char) ('a' + j);
                String newStr = new String(chars);
                if (wordSet.contains(newStr)) {
                    result.add(newStr);
                }
            }
        }
        return result;
    }

}
