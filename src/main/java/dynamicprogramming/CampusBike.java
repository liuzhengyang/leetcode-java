package dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CampusBike {
    public static void main(String[] args) {
        CampusBike campusBike = new CampusBike();
        System.out.println(campusBike.assignBikes(new int[][]{{0,0}, {1,1}, {2,0}}, new int[][]{{1,0}, {2,2}, {2,1}}));
    }

    private Map<Pair, Integer> cache = new HashMap<>();
    public int assignBikes(int[][] workers, int[][] bikes) {
        if (workers == null || workers.length == 0 || bikes == null || bikes.length == 0) {
            return 0;
        }
        int[][] workerToBikeLengths = new int[workers.length][];
        for (int i = 0; i < workers.length; i++) {
            workerToBikeLengths[i] = new int[bikes.length];
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(bikes[j][0] - workers[i][0]) + Math.abs(bikes[j][1] - workers[i][1]);
                workerToBikeLengths[i][j] = distance;
            }
        }

        Set<Integer> existingBikes = new HashSet<>();
        for (int i = 0; i < bikes.length; i++) {
            existingBikes.add(i);
        }
        return findMin(existingBikes, 0, workers.length, workerToBikeLengths);
    }

    private int findMin(Set<Integer> existingBikes, int workerIndex, int totalWorker, int[][] workerToBikeLengths) {
        if (workerIndex == totalWorker - 1) {
            int min = Integer.MAX_VALUE;
            for (int i : existingBikes) {
                min = Math.min(min, workerToBikeLengths[workerIndex][i]);
            }
            return min;
        }
        Pair pair = new Pair(existingBikes, workerIndex);
        if (cache.get(pair) != null) {
            return cache.get(pair);
        }

        int min = Integer.MAX_VALUE;
        for (int i : existingBikes) {
            Set<Integer> newExistBikes = new HashSet<>(existingBikes);
            newExistBikes.remove(i);
            int nextMin = findMin(newExistBikes, workerIndex + 1, totalWorker, workerToBikeLengths);
            min = Math.min(workerToBikeLengths[workerIndex][i] + nextMin, min);
        }

        cache.put(new Pair(existingBikes, workerIndex), min);
        return min;
    }

    private static class Pair {
        private Set<Integer> existingBikes;
        private int workerIndex;

        public Pair(Set<Integer> existingBikes, int workerIndex) {
            this.existingBikes = existingBikes;
            this.workerIndex = workerIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return workerIndex == pair.workerIndex &&
                    Objects.equals(existingBikes, pair.existingBikes);
        }

        @Override
        public int hashCode() {
            return Objects.hash(existingBikes, workerIndex);
        }
    }
}
