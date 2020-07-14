package dfs.timeneededtoinformallempolyees;

/**
 * 解法1: 对每个员工进行dfs遍历，计算从header到自己的时间。最后遍历一遍时间找最大值
 * 解法2: 构建出树状结构，计算从根到叶子节点的最大时间
 * @author liuzhengyang
 * Created on 2020-07-13
 */
public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n <= 1) {
            return 0;
        }
        int[] time = new int[manager.length];
        boolean[] visited = new boolean[manager.length];
        for (int i = 0; i < manager.length; i++) {
            calculateTimeOfEmployee(manager, informTime, visited, time, i);
        }
        int maxTime = 0;
        for (int t : time) {
            maxTime = Math.max(t, maxTime);
        }
        return maxTime;
    }

    private int calculateTimeOfEmployee(int[] manager, int[] informTime, boolean[] visited, int[] time, int index) {
        visited[index] = true;
        if (manager[index] == -1) {
            time[index] = 0;
            return 0;
        }
        time[index] = informTime[manager[index]] + calculateTimeOfEmployee(manager, informTime, visited, time, manager[index]);
        return time[index];
    }
}
