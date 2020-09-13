package weekly.contest.week206;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzhengyang
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.unhappyFriends(4, new int[][]{{1,2,3}, {3,2,0}, {3,1,0}, {1,2,0}}, new int[][]{{0,1}, {2,3}}));
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] preferenceIndexMap = getPreferenceIndexMap(preferences);
        int[] pairMap = getPairMap(n, pairs);
        Set<Integer> unhappyIndex = new HashSet<>();
        for (int[] pair : pairs) {
            int first = pair[0];
            int second = pair[1];
            int preferenceIndexOfSecond = preferenceIndexMap[first][second];
            for (int i = 0; i < preferenceIndexOfSecond; i++) {
                int candidate = preferences[first][i];
                int pairOfCandidate = pairMap[candidate];
                if (preferenceIndexMap[candidate][pairOfCandidate] > preferenceIndexMap[candidate][first]) {
                    unhappyIndex.add(first);
                }
            }

            int preferenceIndexOfFirst = preferenceIndexMap[second][first];
            for (int i = 0; i < preferenceIndexOfFirst; i++) {
                int candidate = preferences[second][i];
                int pairOfCandidate = pairMap[candidate];
                if (preferenceIndexMap[candidate][pairOfCandidate] > preferenceIndexMap[candidate][second]) {
                    unhappyIndex.add(second);
                }
            }

        }
        return unhappyIndex.size();
    }

    private int[][] getPreferenceIndexMap(int[][] preferences) {
        int[][] preferenceIndexMap = new int[preferences.length][preferences.length];
        for (int i = 0; i < preferences.length; i++) {
            int[] preference = preferences[i];
            for (int j = 0; j < preference.length; j++) {
                int target = preference[j];
                preferenceIndexMap[i][target] = j;
            }
        }
        return preferenceIndexMap;
    }

    private int[] getPairMap(int n, int[][] pairs) {
        int[] pairMap = new int[n];
        for (int[] pair : pairs) {
            pairMap[pair[0]] = pair[1];
            pairMap[pair[1]] = pair[0];
        }
        return pairMap;
    }
}
