package dfs.possiblebipartition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/possible-bipartition/
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {
        // {{4,7},{4,8},{5,6},{1,6},{3,7},{2,5},{5,8},{1,2},{4,9},{6,10},{8,10},{3,6},{2,10},{9,10},{3,9},{2,3},{1,9},{4,6},{5,7},{3,8},{1,8},{1,7},{2,4}}
        int[][] arrays = {{4,7},{4,8},{5,6},{1,6},{3,7},{2,5},{5,8},{1,2},{4,9},{6,10},{8,10},{3,
                6},{2,10},{9,10},{3,9},{2,3},{1,9},{4,6},{5,7},{3,8},{1,8},{1,7},{2,4}};
        int[][] array2 = {{1,2}, {2,3}, {3,4}, {4,5}, {1,5}};
        int[][] array3 = {{1,2}, {1,3}, {2,4}};
        boolean b = new Solution().possibleBipartition(10, arrays);
        System.out.println(b);
    }

    private static final int GROUP_1 = 1;
    private static final int GROUP_2 = 2;
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    Map<Integer, Node> nodeByIndex = new HashMap<>();
    public boolean possibleBipartition(int N, int[][] dislikes) {
        for (int i = 1; i <= N; i++) {
            Node node = new Node(i);
            nodeByIndex.put(i, node);
        }
        for (int[] dislike : dislikes) {
            int first = dislike[0];
            int second = dislike[1];
            nodeByIndex.get(first).dislikes.add(second);
        }
        for (int i = 1; i <= N; i++) {
            if (nodeByIndex.get(i).color == WHITE) {
                if (dfs(nodeByIndex.get(i), null) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private Integer dfs(Node node, Integer prohibitGroup){
        if (node.color == BLACK) {
            if (prohibitGroup != null && node.group == prohibitGroup) {
                return null;
            }
            return node.group;
        }
        node.color = GRAY;
        int myGroup = 0;
        Integer thisProhibit = null;
        if (prohibitGroup != null) {
            thisProhibit = 2 / prohibitGroup;
        }
        for (Integer dislike : node.dislikes) {
            Node dislikeNode = nodeByIndex.get(dislike);
            int dislikeGroup;
            if (dislikeNode.color == BLACK) {
                dislikeGroup = dislikeNode.group;
            } else if (dislikeNode.color == GRAY) {
                if (dislikeNode.group == 0) {
                    dislikeGroup = GROUP_1;
                    dislikeNode.group = GROUP_1;
                } else {
                    dislikeGroup = dislikeNode.group;
                }
            } else {
                Integer result = dfs(dislikeNode, thisProhibit);
                if (result == null) {
                    return null;
                }
                dislikeGroup = result;
            }

            if (dislikeGroup == GROUP_1) {
                if (myGroup == 0 || myGroup == GROUP_2) {
                    myGroup = GROUP_2;
                } else {
                    return null;
                }
            }
            if (dislikeGroup == GROUP_2) {
                if (myGroup == 0 || myGroup == GROUP_1) {
                    myGroup = GROUP_1;
                } else {
                    return null;
                }
            }
            if (prohibitGroup != null && prohibitGroup != dislikeGroup) {
                return null;
            }
            if (thisProhibit == null) {
                thisProhibit = 2 / dislikeGroup;
            }
        }
        node.color = BLACK;
        node.group = myGroup == 0 ? (prohibitGroup != null ? 2 / prohibitGroup : GROUP_1) : myGroup;
        return node.group;
    }

    private class Node {
        private int index;
        private int color;
        private int group;
        private List<Integer> dislikes = new ArrayList<>();

        public Node(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", color=" + color +
                    ", group=" + group +
                    ", dislikes=" + dislikes +
                    '}';
        }
    }
}
