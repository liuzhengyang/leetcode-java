package dfs.wordsearch;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-search/
 * @author liuzhengyang
 */
public class WordSearch {
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] chars = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(wordSearch.exist(chars, "ABCCED"));
        System.out.println(wordSearch.exist(chars, "SEE"));
        System.out.println(wordSearch.exist(chars, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    if (findIfMatch(board, i, j, chars, 0, new HashSet<>())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean findIfMatch(char[][] board, int i, int j, char[] word, int wordIndex, Set<Integer> path) {
        if (wordIndex >= word.length || board[i][j] != word[wordIndex]) {
            return false;
        }
        if (wordIndex == word.length - 1 && word[wordIndex] == board[i][j]) {
            return true;
        }
        boolean match = false;
        int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        path.add(i * board[0].length + j);
        for (int[] d : direction) {
            int newI = i + d[0];
            int newJ = j + d[1];
            if (!path.contains(newI * board[0].length + newJ)
                    && newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                match = findIfMatch(board, newI, newJ, word, wordIndex + 1, path);
                if (match) {
                    break;
                }
            }
        }
        path.remove(i * board[0].length + j);
        return match;
    }
}
