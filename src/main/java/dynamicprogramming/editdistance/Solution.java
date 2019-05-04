package dynamicprogramming.editdistance;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

        int res1 = new Solution().minDistance("horse", "ros");
        int res2 = new Solution().minDistance("intention", "execution");
        System.out.println(res1);
        System.out.println(res2);
    }

    private int[][] cacheTable;

    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2 == null ? 0 : word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1 == null ? 0 : word1.length();
        }
        cacheTable = new int[word1.length() + 1][];
        for (int i = 0; i <= word1.length(); i++) {
            cacheTable[i] = new int[word2.length() + 1];
        }
        return trans(word1, 0, word2, 0);
    }

    private int trans(String world1, int i, String world2, int j) {
        if (cacheTable[i][j] > 0) {
            return cacheTable[i][j];
        }
        int result;
        if (i == world1.length() || j == world2.length()) {
            result = Math.max(world1.length() - i, world2.length() - j);
        } else if (world1.charAt(i) == world2.charAt(j)) {
            result = trans(world1, i + 1, world2, j + 1);
        } else {
            int insertOps = 1 + trans(world1, i, world2, j + 1);
            int deleteOps = 1 + trans(world1, i + 1, world2, j);
            int replaceOps = 1 + trans(world1, i + 1, world2, j + 1);
            result = Math.min(Math.min(insertOps, deleteOps), replaceOps);
        }
        cacheTable[i][j] = result;
        return result;
    }
}
