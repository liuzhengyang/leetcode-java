package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 先O(N2)遍历找到所有的两数相加到index之间的映射Map<integer, list<int[]>>
 * 然后再遍历，找到target - currentValue的映射且排除掉自己
 *
 * @author liuzhengyang
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Map<Integer, List<int[]>> sumToIndexesMap = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                sumToIndexesMap.computeIfAbsent(sum, key -> new ArrayList<>()).add(new int[] {i, j});
            }
        }
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<int[]> indexesList = sumToIndexesMap.get(-nums[i]);
            if (indexesList != null) {
                for (int[] indexes : indexesList) {
                    if (indexes[0] == i || indexes[1] == i) {
                        continue;
                    }
                    List<Integer> triplet = new ArrayList<>(3);
                    triplet.add(nums[indexes[0]]);
                    triplet.add(nums[indexes[1]]);
                    triplet.add(nums[i]);
                    triplet.sort(Integer::compare);
                    result.add(triplet);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
