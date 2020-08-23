package weekly.contest.week203;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/contest/weekly-contest-203/problems/find-latest-group-of-size-m/
 * @author liuzhengyang
 */
public class Problem3 {
    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.findLatestStep(new int[] {3, 5, 1, 2, 4,}, 1));
        System.out.println(problem3.findLatestStep(new int[] {3, 5, 1, 2, 4,}, 2));
        System.out.println(problem3.findLatestStep(new int[] {1}, 1));
        System.out.println(problem3.findLatestStep(new int[] {2, 1}, 2));
        System.out.println(problem3.findLatestStep(new int[] {10,6,9,4,7,8,5,2,1,3}, 1));
    }

    public int findLatestStep(int[] arr, int m) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int length = arr.length;
        boolean[] oneArray = new boolean[length + 1];
        UF uf = new UF(length + 1, m);
        List<Integer> equalsIndexList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            oneArray[index] = true;
            uf.init(index);
            if (index - 1 >= 0 && oneArray[index - 1]) {
                uf.union(index, index - 1);
            }
            if (index + 1 < oneArray.length && oneArray[index + 1]) {
                uf.union(index, index + 1);
            }
            boolean newExist = uf.targetExist();
            if (newExist) {
                equalsIndexList.add(i + 1);
            }
        }
        if (!equalsIndexList.isEmpty()) {
            return equalsIndexList.get(equalsIndexList.size() - 1);
        }
        return -1;
    }

    private static class UF {
        private int n;
        private int[] parent;
        private int[] count;
        private int targetSum;
        private Set<Integer> targetSumSet = new HashSet<>();

        public UF(int n, int targetSum) {
            this.n = n;
            this.parent = new int[n];
            this.count = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            this.targetSum = targetSum;
        }

        public void init(int x) {
            if (count[x] == 0) {
                count[x] = 1;
            }
            if (count[x] == targetSum) {
                targetSumSet.add(x);
            }
        }

        public int union(int x, int y) {
            int parentX = parent(x);
            int parentY = parent(y);
            if (parentX == parentY) {
                return count[parentX];
            }
            if (count[parentX] == targetSum) {
                targetSumSet.remove(parentX);
            }
            if (count[parentY] == targetSum) {
                targetSumSet.remove(parentY);
            }
            parent[parentX] = parentY;
            count[parentY] += count[parentX];
            count[parentX] = 0;
            if (count[parentY] == targetSum) {
                targetSumSet.add(parentY);
            }
            return count[parentY];
        }

        private int count(int x) {
            return count[x];
        }

        public int parent(int x) {
            if (parent[x] != x) {
                parent[x] = parent(parent[x]);
            }
            return parent[x];
        }

        public boolean targetExist() {
            return !targetSumSet.isEmpty();
        }
    }
}
