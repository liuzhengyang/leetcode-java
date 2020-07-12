# leetcode solutions in java

## 算法心得

本人计算机编程是自学的，并非所谓的"计算机科班出身"，最开始算法方面的学习较少，这个确实是因为在工作中（本人服务端Java开发）用不到。
平时的各类产品需求，编写的代码真的非常简单，读参数、调服务、转换返回数据等等，没什么难度。
但是在面试过程中，又会遇到大量的算法问题。
曾经我去面试的时候，自认为对Java语音、虚拟机、常用的框架等的原理都挺掌握了，出去面试不是简简单单。
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

每个公司、面试官一般都有一些特定的算法题（大部分都是网上的题目比如leetcode上的，因为很大一部分面试官算法水平其实也一般，还没有达到出题水平）

算法问题如何解决

曾几何时，在没有更加系统学习算法之前，我解决算法题都是靠蛮力，简单一点的还能想出来，稍微复杂的问题变完全无处下手。
更形象的描述就是像小学生做初中题目、初中生做高中题目，如果没有这些"公式"，解起题来困难相当大。

后来通过学习一些算法书和练习后，开始有了一些体会，做算法题就应该像做数学题一样，先学习常见的数据结构和算法，这些内容学习后变成了自己的工具。
在解题时，要先尝试分类，看这个题的考点是什么，能够用什么样的工具（算法、数据结构）解决。
有了这样的思考后，解决算法题目就更加简单了。
把算法问题分门别类，并进行专项学习练习。在面试时，对于问题进行分析判断，剥开问题的伪装，内部就是要考察的具体算法类型了，通过常见的算法框架一套，就能轻松解决。
如果更复杂一点的情况，可能是组合多个算法。

## BFS(Breath First Search)

bfs能解决什么样的问题

图遍历中是否可达、最短路径等等。

### 普通bfs解题框架
一个boolean[] visited数组，记录访问过的位置
两个List<Node>，保存要遍历的节点和下次要遍历的节点，Node的值可以按照情况变化，比如可以是数组的index，也可以是一个Point(x,y)对象等

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

[找树左下角的值](https://leetcode-cn.com/problems/find-bottom-left-tree-value/)
层次遍历，每次遍历覆盖记录每一层第一个值，遍历完返回即可。

[在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)
层次遍历，每层找最大值

树的层次遍历还是比较简单的，当时实际面试过程中的题目可能不会这么直接，有可能会故意用一些故事、背景包装，希望大家能够透过问题看到本质。

#### BFS常见问题之01二维数组问题

01二维数组

#### 其他类型
[jump game 3](https://leetcode.com/problems/jump-game-iii/)
给定一个数组arr和起始位置start，每次在index为i的位置时，能够
跳到i + arr[i]或i - arr[i]的位置（不能跳出数组），问能否跳到一个值为零的位置
使用bfs遍历就可以完成，一直遍历（不走已经跳过的位置），直到调到一个0的位置或者没有位置可跳
[jump game](https://leetcode.com/problems/jump-game/)

如果有其他变种，例如01数组，也是类似解法

#### 


## DFS(Deep First Search)

dfs常见写法



## DP(Dynamic Programming)

dynamic programming中文大家都称为动态规划，这个中文翻译名字确实很差，从名字上根本看不出是什么含义。
这里放出我的理解，动态规划就是递归加上缓存。

## Tree

## BinarySearch

