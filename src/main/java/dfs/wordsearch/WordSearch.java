package dfs.wordsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class WordSearch {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        char[] chars = word.toCharArray();
        List<Character> characterList = new ArrayList<>();
//        characterList.addAll(Arrays.asList(chars));
        return false;
    }
}
