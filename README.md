# leetcode solutions in java

## BFS(Breath First Search)

bfs能解决什么样的问题

图遍历中是否可达，例如[Jump Game III](https://leetcode.com/problems/jump-game-iii/)
最短路径

普通bfs写法
一个boolean[] visited数组，记录访问过的位置
两个List<Node>，保存要遍历的节点和下次要遍历的节点，Node的值可以按照情况变化，比如可以是数组的index，也可以是一个Point(x,y)对象等

```java
// 创建需要的数据结构
boolean[] visited = new boolean[length];
List<Integer> prev = new ArrayList();
List<Integer> next = new ArrayList();

// 初始化prev元素
prev.add(firstNode)

while (!prev.isEmpty() {
    for (int nodeIndex : prev) {
        // 根据具体的问题对每个node做处理
        doSomething(nodeIndex)
        // 记录下这个node已经访问过了
        visited[nodeIndex] = true;
        // 对从当前node可以直达的下一个node，如果没有访问过，加到next中
        for (adjacentNodeIndex in getAdjacentList(nodeIndex)node.adjacentList) {
            if (!visited[adjacentNodeIndex]) {
                next.add(adjacentNodeIndex)
            }
        }
    }
    // 交换prev next
    prev = next;
    next = new ArrayList();
}
```

如果有其他变种，例如01数组，也是类似解法

## DFS(Deep First Search)

## DP(Dynamic Programming)

## Tree

## BinarySearch

