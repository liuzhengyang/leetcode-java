package array;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) throws Exception {
        SubarraysWithKDifferentIntegers subarraysWithKDifferentIntegers = new SubarraysWithKDifferentIntegers();
        System.out.println(subarraysWithKDifferentIntegers.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(subarraysWithKDifferentIntegers.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
        System.out.println(subarraysWithKDifferentIntegers.subarraysWithKDistinct(new int[]{1, 1, 2, 1, 3, 4}, 1));
        String s = Files.readAllLines(Paths.get("/Users/liuzhengyang/Code/leetcode-java/src/main/resources/subarray.txt")).get(0);
        String[] split = s.split(",");
        List<Integer> collect = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int[] input = new int[collect.size()];
        for (int i = 0; i < input.length; i++) {
            input[i] = collect.get(i);
        }
        System.out.println("Length " + input.length);
        System.out.println(subarraysWithKDifferentIntegers.subarraysWithKDistinct(input, 360));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        if (A == null || A.length == 0 || K <= 0 || A.length < K) {
            return 0;
        }

        List<SetCount> setCounts = new ArrayList<>();
        int totalCount = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            Set<Integer> thisNumSet = new HashSet<>();
            thisNumSet.add(A[i]);
            setCounts.add(new SetCount(thisNumSet, 1));
            for (SetCount setCount : setCounts) {
                setCount.ints.add(A[i]);
                if (setCount.ints.size() == K) {
                    totalCount += setCount.count;
                }
            }
        }

        return totalCount;
    }

    private static class SetCount {
        Set<Integer> ints;
        int count;

        public SetCount(Set<Integer> ints, int count) {
            this.ints = ints;
            this.count = count;
        }

        public Set<Integer> getInts() {
            return ints;
        }

        public int getCount() {
            return count;
        }
    }

}
