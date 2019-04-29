package dfs.accountmerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        // [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));
        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));
        System.out.println(new Solution().accountsMerge(accounts));
    }

    private int[] visited;
    Map<String, List<Integer>> emailToAccountMap;
    Map<Integer, Set<String>> result;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.isEmpty()) {
            return Collections.emptyList();
        }

        visited = new int[accounts.size()];
        result = new HashMap<>();

        emailToAccountMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            List<String> emails = account.subList(1, Math.max(1, account.size()));
            for (String email : emails) {
                emailToAccountMap.computeIfAbsent(email, k -> new ArrayList<>()).add(i);
            }
        }
        for (int i = 0; i < accounts.size(); i++) {
            if (visited[i] == 0) {
                dfs(i, i, accounts);
            }
        }

        List<List<String>> finalResult = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : result.entrySet()) {
            List<String> each = new ArrayList<>();
            each.add(accounts.get(entry.getKey()).get(0));
            each.addAll(entry.getValue());
            finalResult.add(each);
        }

        return finalResult;
    }

    private static class Account {
        private int index;
        private String name;
        private List<String> accounts = new ArrayList<>();

        public Account(int index, String name) {
            this.index = index;
            this.name = name;
        }
    }

    private void dfs(int i, int currentAccountIndex, List<List<String>> accounts) {
        if (visited[i] == 0) {
            visited[i] = 1;
        } else {
            return;
        }
        List<String> account = accounts.get(i);
        List<String> emails = account.subList(1, account.size());
        for (String email : emails) {
            List<Integer> index = emailToAccountMap.get(email);
            if (index == null || index.isEmpty()) {
                continue;
            }
            for (Integer e : index) {
                if (visited[e] == 0) {
                    dfs(e, currentAccountIndex, accounts);
                }
            }
        }
        visited[i] = 2;
        if (!result.containsKey(currentAccountIndex)) {
            result.put(currentAccountIndex, new TreeSet<>());
        }
        result.get(currentAccountIndex).addAll(emails);
    }
}
