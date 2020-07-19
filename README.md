# leetcode solutions in java

本仓库内包含了java实现的leetcode解法，但其中的解法思想并不受语言限制。

## 算法心得

本人计算机编程是自学的，并非所谓的"计算机科班出身"，最开始算法方面的学习较少，因为在工作中（本人服务端Java开发）确实不会直接用到。
平时的各类产品需求，编写的代码真的非常简单，读参数、调服务、转换返回数据等等，没什么难度。
但是在面试过程中，又会遇到大量的算法问题。
曾经我去面试的时候，自认为对Java语音、虚拟机、常用的框架等的原理都掌握的很深入了，出去面试拿offer应该如同探囊取物。
然而事实向我泼了一盆冷水，很多面试官问了我自认为是脑筋急转弯的问题，在面试现场怎么想也想不出来。

为什么面试中，会问这么多算法问题呢。
这里的原因会比较多，我自己思考的一些原因有。
1. 算法题是考察代码编写能力的一个重要方式。大部分软件工程师的一个重要工作是编写代码，代码质量、熟练度该如何考核呢，面试线上又不能找个需求让面试者开发实现，
因此算法题就成了一个比较合适的考察方式，解题中用到的数据结构使用、实现方案设计、代码风格等都能看出候选人的代码编写能力。
2. 算法题能够考察候选人的问题解决能力等，大部分公司都希望能够招聘到能力强的候选人，而能力强在互联网工程师工作中一般指解决问题能力强，算法问题千变万化，
面试过程中如何分析、思考、解决问题，也是评估候选人问题解决能力的一个重要参考。
3. 更加严格的筛选方式。虽然平时的工作，其实大部分人都能完成，但是完成的速度、质量等就不一定了，所以公司还是希望能够招聘到更优秀的人才。而面试考察的一些其他知识，
比如语言特性、框架知识点等，网上有各种各样的面试宝典，很多候选人都会突击背诵。举一个例子，比如Java语音的垃圾回收机制，如果问太简单，大部分人都了解或者背诵过。
如果问的太难，要么是我也不会，要么是其实这个岗位根本不需要这种知识。因此很多软知识点不方便明确区分候选人。而算法问题则更加多变，不是只靠背题就能解决的。

每个公司、面试官一般都有一些特定的算法题（大部分都是网上的题目比如leetcode上的，很大一部分面试官算法水平也不怎么样，还没有达到出题水平）

算法问题如何解决

曾几何时，在没有更加系统得学习算法之前，我解决算法题都是靠蛮力，闷头想，简单一点的还能想出来，稍微复杂的问题变完全无处下手。
更形象的描述就是像小学生做初中题目、初中生做高中题目，比如没有学过球体积的计算公式的情况下求球的体积，如果没有学过对应的"公式"，解起题来困难相当大。

后来通过学习一些算法书和练习后，开始有了一些体会，做算法题就应该像做数学题一样，先学习常见的数据结构和算法，这些内容学习后变成了自己的工具。
在解题时，要先尝试分类，看这个题的考点是什么，能够用什么样的工具（算法、数据结构）解决。
有了这样的思考后，解决算法题目就更加简单了。
平时把算法问题分门别类，并进行专项学习练习。
在面试时，对于问题进行分析判断，剥开问题的伪装，内部就是要考察的具体算法类型了，通过常见的算法框架一套，就能轻松解决。
如果更复杂一点的情况，可能是组合多个算法。

## BFS(Breath First Search)

bfs能解决什么样的问题

图遍历中是否可达、最短路径等等。

### 普通bfs解题框架
一个boolean[] visited数组，记录访问过的位置
两个List<Node>，保存要遍历的节点和下次要遍历的节点，Node的值可以按照情况变化，比如可以是数组的index，也可以是一个Point(x,y)对象等
注意这里的List在某些要去重的场景下需要使用Set代替

```
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

### BFS实战题目分析

#### BFS常见问题之二叉树/N叉树层级遍历

很多树的问题可以用层级遍历解决，树的广度优先搜索就是层级遍历，下面找一些题目举例

[对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)
判断一个二叉树是否是对称的，对称的特点是以中心为镜像，把树的每一层想象成一个列表，问题即为树的每一层列表是不是对称的，
通过上面的层次遍历，能够轻松的构建出每一层的列表，而判断列表是不是对称的，也很好实现。

[树的层次遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
这个有点直接了，直接按照上面的bfs框架，就能获得每一层的列表

[二叉树的锯齿形层次遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)
[N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)
也是层次遍历，对于锯齿，只需要记录一个boolean值，初始false，每遍历一层切换true/false一次，如果是true则遍历时把列表翻转一下。

[二叉树的层次遍历 II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)
自底向上遍历，层次遍历后把最终顺序翻转一下就可以

[二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
即最高的叶子节点，叶子节点就是子节点都为空的节点，通过层次遍历，并记录层次数，如果遍历到某一层时某个节点的子节点都是空的，则返回当前遍历的层次即可。

[N叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/)
N叉数和二叉树区别不大，最大深度也是高度，通过层次遍历记录高度即可。

[二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/)
二叉树的右视图，即为层次遍历的每个列表的最后一个元素

[Deepest Leaves Sum](https://leetcode.com/problems/deepest-leaves-sum/)
层次遍历到最后一层的和

[找树左下角的值](https://leetcode-cn.com/problems/find-bottom-left-tree-value/)
层次遍历，每次遍历覆盖记录每一层第一个值，遍历完返回即可。

[在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)
层次遍历，每层找最大值

[二叉树中距离为K的节点](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/)
从二叉树中某一个节点开始距离为K的节点，通过parent的引用线上也算合法路径。这个问题可以把二叉树转换成一个图(图结构中每个节点有一个邻接链表)，
然后从起始节点开始bfs，宽度优先向外遍历k次即可。

[Count Good Nodes in Binary Tree](https://leetcode.com/problems/count-good-nodes-in-binary-tree/)
从根节点开始，记录一个总数，bfs每次遍历到节点计数+1，如果子节点大于当前节点，则加入到下次遍历。
这个问题也可以通过dfs来解决。可以查看代码中具体的实现

[Time Needed to Inform All Employees](https://leetcode.com/problems/time-needed-to-inform-all-employees/)

树的层次遍历还是比较简单的，当然实际面试过程中的题目可能不会这么直接，有可能会故意用一些故事、背景包装，希望大家能够透过问题看到本质。

例如
[Target Sum](https://leetcode.com/problems/target-sum/)
这个题目可以使用暴力算法或加上dp缓存实现。这里提供一个bfs的解法，对于每一个元素的加减，想象成一个树状结构的bfs遍历，遍历的内容是之前的所有加和的结果集，
从上一层的结果集遍历对每个元素加减下一个数组元素得到下一层的结果集，由于可能有重复的加和，所以要保存一个计数。最终寻找结果集的值和数量即为结果。
题目这里限制了原始数组非负数且总和在一定范围内，所以可以用数组提高效率。参考TargetSum.java

#### BFS常见问题之01二维数组问题


01二维数组问题，通常题目背景是岛屿海洋等背景，在一个二维数组里，每个值可以是0或者1，二维数组之间的又有相连的关系等。

举例

[01 Matrix](https://leetcode.com/problems/01-matrix/)
计算每个位置到最近的0节点的距离。从所有的0节点开始bfs遍历，遍历到一个值为1的节点时，当前的步数为从起始0到当前1节点的最短距离，
每个节点保存一个到最近的0节点的最小值，如果当前最短距离比之前最小值小则更新最小值。


#### 其他类型
[jump game 3](https://leetcode.com/problems/jump-game-iii/)
给定一个数组arr和起始位置start，每次在index为i的位置时，能够
跳到i + arr[i]或i - arr[i]的位置（不能跳出数组），问能   否跳到一个值为零的位置
使用bfs遍历就可以完成，一直遍历（不走已经跳过的位置），直到调到一个0的位置或者没有位置可跳
[jump game](https://leetcode.com/problems/jump-game/)

[Get Watched Videos by Your Friends](https://leetcode.com/problems/get-watched-videos-by-your-friends/)
获取第N层好友的观看列表，关键在于怎么获得第N层好友，使用bfs即可实现，注意每一层的bfs要使用Set保存，因为可能有重复数据。


## DFS(Deep First Search)

dfs常见写法框架

注意有的场景只需要标记是否访问过就可以，有的场景可能需要三色标记。
有的时候dfs需要和dp结合一下，或者直白一点说是加一个缓存(Map或数组存储之前计算过的结果）来减少计算。

```
int dfs(Graph graph, boolean[] visited, int index) {
    visited[index] = true;
    int[] adjacent = graph.adjacent(index);
    for (int adj : adjacent) {
        if (!visited[]) {
            // 递归处理货拿到dfs的结果，有的题目会要求汇总所有的节点的结果
            dfs(graph, visited, adj);
        }
    }
    // 对本节点执行某些操作，有可能会依赖从这个节点直接能够达到的邻接节点的结果
    doSomething(graph, index);
}
```

### 01二维数组问题

经常出现的类型是二维int数组，0表示水，1表示陆地，陆地或水域区域周围（有时是上下左右4个方向有时是包括斜对角的8个方向）可以相连。
基于这种场景，可以询问最大区域、区域个数等问题。
01二维数组问题通常既可以用dfs也可以用bfs思路解决。

01二维数组问题常见写法之dfs，参考NumberOfClosedIslands类
首先判断输入合法性，对一些边界case进行处理。
然后初始化需要的一些辅助数据，例如visited数组，需要注意这里如果visited是二维数组，需要提前把二维数组的一维数组部分初始化好。
然后对每个位置，判断位置的值、是否访问过，如果符合条件，进行dfs处理。
dfs函数中，先标记这个位置已经访问过。然后创建一个表示邻接方向的二维数组{{0,1}{0,-1},{-1,0},{1,0}}，
对这个二维数组表示的每个方向判断是否在数组范围内、是否访问过等条件，满足条件继续dfs处理。

```
public int closedIsland(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
        return 0;
    }
    int islandNumber = 0;
    int notClosedNumber = 0;
    int[][] islandNumberMark = new int[grid.length][];
    for (int i = 0; i < grid.length; i++) {
        islandNumberMark[i] = new int[grid[i].length];
    }
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            // island and not visited
            if (grid[i][j] == 0 && islandNumberMark[i][j] == 0) {
                boolean notClose = dfsMark(grid, islandNumberMark, i, j, ++islandNumber);
                if (notClose) {
                    notClosedNumber++;
                }
            }
        }
    }
    return islandNumber - notClosedNumber;
}


/**
 * true 不是close
 * false 还不确定
 */
boolean dfsMark(int[][] grid, int[][] islandNumber, int row, int col, int number) {
    islandNumber[row][col] = number;
    boolean notClosed = 0 == row || row == grid.length - 1 || 0 == col || col == grid[row].length - 1;
    int[][] directions = new int[][] {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };
    for (int[] direction : directions) {
        int xDiff = direction[0];
        int yDiff = direction[1];
        int newRow = row + yDiff;
        int newCol = col + xDiff;
        if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[row].length) {
            if (grid[newRow][newCol] == 0 && islandNumber[newRow][newCol] == 0) {
                notClosed = dfsMark(grid, islandNumber, newRow, newCol, number) || notClosed;
            }
        }
    }

    return notClosed;
}
```

举例

[Number of Closed Islands](https://leetcode.com/problems/number-of-closed-islands/submissions/)
记录一个island总数，同时也作为island的编号生成器、非封闭的island总数，创建一个二维数组标记island属于哪个island编号，
如果遇到值为0的位置，则从这个位置开始dfs遍历，标记dfs遇到的标记数组位置为island编号，如果dfs过程中任何一个点位于边上，则非封闭数量加1，最终封闭
island数量即为island总数减去非封闭island数量。

[Number of Islands](https://leetcode.com/problems/number-of-islands/)
相当于上面问题的简化版，区别是只需要计算island总数就可以了。

[Max Area of Island](https://leetcode.com/problems/max-area-of-island/)
每次dfs时统计遍历区域的和，最终计算一个最大值。

[Number of Enclaves](https://leetcode.com/problems/number-of-enclaves/)
统计不能抵达边界的island的面积的和，和统计closed island问题类似。也有另一个解法，把所有的边界的值通过dfs修改二维数组的值为-1，
然后再遍历统计值为1的数量。


### 判断图中是否存在环
使用三色标记法，没有访问过的节点为白色，正在dfs过程中的节点标记位灰色，如果一个节点dfs处理完，标记位黑色。
如果在dfs过程中遇到了一个灰色的节点，则说明出现了环

### 拓扑排序

dfs的另一个应用是拓扑排序，举一个常见例子，大学生安排课程，某些课程需要在其他课程学习完之后才能学习，因此就形成了一个依赖关系图。
把依赖关系当成边，对图进行dfs遍历，递归过程中，执行doSomething时把当前节点加入到结果列表中，最终的列表顺序就是拓扑排序顺序。
由于可能出现循环依赖，因此需要使用判断图中是否存在环的方式检查是否有循环依赖。

拓扑排序的其他使用场景还有
- 任务编排
- maven编译

leetcode上的问题有

[Course Schedule](https://leetcode.com/problems/course-schedule/)
这个题目只需要判断是否有循环依赖。对数组的每个元素进行dfs（也要判断是否访问过了)，如果dfs中遇到了一个正在遍历的节点（灰色节点），说明有循环依赖。

[https://leetcode.com/problems/course-schedule-ii/](https://leetcode.com/problems/course-schedule-ii/)
准备一个List，doSomething时把节点放到List中，如果有循环依赖，返回空列表。

### 树相关问题dfs解法

一些树的问题，每个节点的值依赖所有子节点或者父节点的值，则可以用dfs解决

[Number of Nodes in the Sub-Tree With the Same Label](https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/)

计算子树中字母和当前节点相同的数量。一种解决思路为保存每个字母的计数，在dfs遍历到每个节点时，记录一个当前字母的计数，记录完计数加一，然后遍历完子节点后看一下这个字母的计数，
减去当前值即为当前这个节点的结果值。另外这个问题需要提前构造好树结构，因为参数中提供的edge是无向边。

## DP(Dynamic Programming)

dynamic programming中文大家都称为动态规划，这个中文翻译名字确实很差，从名字上根本看不出是什么含义。
这里放出我的理解，动态规划就是递归加上缓存。

## Tree

## BinarySearch

## 其他常见题目、解法

### 双指针

双指针的左右指针，指数组左右两个指针，不断互相逼近查找目标值
比较好理解的是[Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
因为数组已经排好序，分别设置左指针指向0，右指针指向数组最后一个元素，比较两个指针的值的和，如果比目标值小，只能向右移动左指针，因为向左移动右指针只会比当前值更小。
反之如果比目标和大了，需要向左移动右指针。

## 其他注意事项

写代码前把思路想清楚，思路确定差不多后和面试官沟通确认，并且要思路这种解法的时间空间复杂度是多少，预估耗时，思考是否有更优解法。
注意检查题目，写完代码仔细检查，考虑边界case，避免出现低级错误，写完从头到尾用小黄鸭调试法讲解一下实现过程，要假设自己的代码有错误，尝试查找错误。
编码注意可读性，有时经常看到一些解法使用到比较trick的技巧例如复用一些内存数据，虽然能够带来一点点效率提升，但是我认为并不直观，毕竟面试时还是需要让人看懂比较重要。
