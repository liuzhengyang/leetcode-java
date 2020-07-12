package p5;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    // //[[1,1,0],
    //// [1,1,0],
    //// [0,0,1]]

    @Test
    public void testFriendCircle() {
        int[][] nums = {{1,1,0}, {1,1,0}, {0,0,1}};
        int length = nums.length;
        visited = new int[length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            max = Math.max(max, dfs(nums, i));
        }
        System.out.println(max);
    }
    public int findCircleNum(int[][] nums) {
        int length = nums.length;
        visited = new int[length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            max = Math.max(max, dfs(nums, i));
        }
        return max;
    }
    static int[] visited;

    int dfs(int[][] nums, int i) {
        visited[i] = 1;
        int result = 1;
        for (int j = 0; j < nums[i].length; j++) {
            if (visited[j] == 0 && nums[i][j] == 1) {
                result += dfs(nums, j);
            }
        }
        return result;
    }

    @Test
    public void longestPalindrome() throws Exception {
    }

    @Test
    public void testLCCS() {
//        String s = new Solution().longestPalindrome("abcd", "ebcd");
//        Assert.assertEquals("bcd", s);
    }

    @Test
    public void testReverseString() {
//        Assert.assertEquals("abc", new Solution().reverseString("cba"));
    }

}