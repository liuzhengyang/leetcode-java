package unionfind.smalleststringwithswaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/smallest-string-with-swaps/
 * @author liuzhengyang
 */
public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        SmallestStringWithSwaps smallestStringWithSwaps = new SmallestStringWithSwaps();
        System.out.println(smallestStringWithSwaps.smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0,3), Arrays.asList(1,2))));
        System.out.println(smallestStringWithSwaps.smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0,3), Arrays.asList(1,2), Arrays.asList(0,2))));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();
        int[] unionFindArray = new int[chars.length];
        for (int i = 0; i < unionFindArray.length; i++) {
            unionFindArray[i] = i;
        }
        for (List<Integer> pair : pairs) {
            Integer first = pair.get(0);
            Integer second = pair.get(1);
            union(first, second, unionFindArray);
        }
        Map<Integer, List<Character>> charsByGroup = new HashMap<>();
        for (int i = 0; i < unionFindArray.length; i++) {
            charsByGroup.computeIfAbsent(find(i, unionFindArray), k -> new ArrayList<>())
                    .add(chars[i]);
        }
        charsByGroup.values().forEach(list -> {
            list.sort(Character::compare);
        });
        int[] countByGroup = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            int group = find(i, unionFindArray);
            int count = countByGroup[group];
            chars[i] = charsByGroup.get(group).get(count);
            countByGroup[group] += 1;
        }
        return new String(chars);
    }

    private int find(int x, int[] unionFindArray) {
        int target = x;
        while (target != unionFindArray[target]) {
            target = unionFindArray[target];
        }
        unionFindArray[x] = target;
        return target;
    }

    private void union(int x, int y, int[] unionFindArray) {
        int xParent = find(x, unionFindArray);
        int yParent = find(y, unionFindArray);
        unionFindArray[xParent] = yParent;
    }
}
