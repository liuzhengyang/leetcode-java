package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndexPairsOfAString {
    public static void main(String[] args) {
        IndexPairsOfAString indexPairsOfAString = new IndexPairsOfAString();
        System.out.println(Arrays.deepToString(indexPairsOfAString.indexPairs("thestoryofleetcodeandme", new String[]{"story", "fleet", "leetcode"})));
        System.out.println(Arrays.deepToString(indexPairsOfAString.indexPairs("ababa", new String[]{"aba", "ab"})));
    }

    public int[][] indexPairs(String text, String[] words) {
        if (text == null || text.isEmpty() || words == null || words.length == 0) {
            return new int[0][];
        }

        List<int[]> pairs = new ArrayList<>();
        for (String word : words) {
            int fromIndex = 0;
            int i = 0;
            while ((i = text.indexOf(word, fromIndex)) != -1) {
                fromIndex = i + 1;
                pairs.add(new int[]{i, (i + word.length() - 1)});
            }
        }
        pairs.sort((o1, o2) -> {
            int compare = Integer.compare(o1[0], o2[0]);
            if (compare == 0) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return compare;
            }
        });
        int size = pairs.size();
        int[][] result = new int[size][];
        for (int i = 0; i < size; i++) {
            result[i] = pairs.get(i);
        }
        return result;
    }
}
