# 学习笔记

字典树Trie
1.字典树的数据结构
	字典树，即Trie树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
    优点是最大限度地减少无谓的字符串比较，查询效率比哈希表高。
2.字典树的核心思想
	Trie树的核心思想是空间换时间。
    利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。
3.字典树的基本性质
	a.结点本身不存完整单词；
    b.从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串；
    c.每个结点的所有子结点路径代表的字符都不相同。
    
 Java代码模版

``` java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
```

并查集
适用场景：组团、配对问题
基本操作
	makeSet(s)：建立一个新的并查集，其中包含s个单元素集合。
    unionSet(x,y)：把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。
    find(x)：找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。

Java代码模版

``` javascript
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		int root = p;
        while (root != parent[root]) { 
			root = parent[root]; 
        while(p != parent[p]) {
        	int x = p;
            p = parent[p];
            parent[x] = root;
		}
		return root; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```

高级搜索
剪枝，去掉重复的操作或者次优分治。

双向BFS
Java代码模版

``` java
void BFS_bothsides()//双向BFS 
{
    if(s1.state==s2.state)//起点终点相同时要特判
    {
           //do something
           found=true;
           return;
    }
    bool found=false;
    memset(visited,0,sizeof(visited));  // 判重数组
    while(!Q1.empty())  Q1.pop();   // 正向队列
    while(!Q2.empty())  Q2.pop();  // 反向队列
    //======正向扩展的状态标记为1，反向扩展标记为2
    visited[s1.state]=1;   // 初始状态标记为1
    visited[s2.state]=2;   // 结束状态标记为2
    Q1.push(s1);  // 初始状态入正向队列
    Q2.push(s2);  // 结束状态入反向队列
    while(!Q1.empty() || !Q2.empty())
    {
           if(!Q1.empty())
                  BFS_expand(Q1,true);  // 在正向队列中搜索
           if(found)  // 搜索结束 
                  return ;
          if(!Q2.empty())
                  BFS_expand(Q2,false);  // 在反向队列中搜索
           if(found) // 搜索结束
                  return ;
    }
}
void BFS_expand(queue<Status> &Q,bool flag)
{  
 	s=Q.front();  // 从队列中得到头结点s
 	Q.pop()
 	for( 每个s 的子节点 t )
	{
        t.state=Gethash(t.temp);  // 获取子节点的状态
        if(flag)   // 在正向队列中判断
        {
           	if(visited[t.state]!=1)// 没在正向队列出现过
            {
                if(visited[t.state]==2)  // 该状态在反向队列中出现过
              	{
                    各种操作；
                    found=true；
                    return;
                }
                visited[t.state]=1;   // 标记为在在正向队列中
                Q.push(t);  // 入队
           	}
        }
        else    // 在正向队列中判断
        {
            if (visited[t.state]!=2) // 没在反向队列出现过
         	{
                if(visited[t.state]==1)  // 该状态在正向向队列中出现过
                {
                    各种操作；
                    found=true；
                    return;
                }
                visited[t.state]=2;  // 标记为在反向队列中
                Q.push(t);  // 入队
            }
        }
    }
```

启发式搜索
启发式函数：h(n)，它用来评价哪些结点最优希望的是一个我们要找的结点，h(n)会返回一个非负实数，也可以认为是从结点n的目标结点路径的估计成本。
启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标。
Java代码模版
``` java
	public class AStar
	{
		public final static int BAR = 1; // 障碍值
		public final static int PATH = 2; // 路径
		public final static int DIRECT_VALUE = 10; // 横竖移动代价
		public final static int OBLIQUE_VALUE = 14; // 斜移动代价
		
		Queue<Node> openList = new PriorityQueue<Node>(); // 优先队列(升序)
		List<Node> closeList = new ArrayList<Node>();
		
		/**
		 * 开始算法
		 */
		public void start(MapInfo mapInfo)
		{
			if(mapInfo==null) return;
			// clean
			openList.clear();
			closeList.clear();
			// 开始搜索
			openList.add(mapInfo.start);
			moveNodes(mapInfo);
		}
	

		/**
		 * 移动当前结点
		 */
		private void moveNodes(MapInfo mapInfo)
		{
			while (!openList.isEmpty())
			{
				Node current = openList.poll();
				closeList.add(current);
				addNeighborNodeInOpen(mapInfo,current);
				if (isCoordInClose(mapInfo.end.coord))
				{
					drawPath(mapInfo.maps, mapInfo.end);
					break;
				}
			}
		}
		
		/**
		 * 在二维数组中绘制路径
		 */
		private void drawPath(int[][] maps, Node end)
		{
			if(end==null||maps==null) return;
			System.out.println("总代价：" + end.G);
			while (end != null)
			{
				Coord c = end.coord;
				maps[c.y][c.x] = PATH;
				end = end.parent;
			}
		}
	

		/**
		 * 添加所有邻结点到open表
		 */
		private void addNeighborNodeInOpen(MapInfo mapInfo,Node current)
		{
			int x = current.coord.x;
			int y = current.coord.y;
			// 左
			addNeighborNodeInOpen(mapInfo,current, x - 1, y, DIRECT_VALUE);
			// 上
			addNeighborNodeInOpen(mapInfo,current, x, y - 1, DIRECT_VALUE);
			// 右
			addNeighborNodeInOpen(mapInfo,current, x + 1, y, DIRECT_VALUE);
			// 下
			addNeighborNodeInOpen(mapInfo,current, x, y + 1, DIRECT_VALUE);
			// 左上
			addNeighborNodeInOpen(mapInfo,current, x - 1, y - 1, OBLIQUE_VALUE);
			// 右上
			addNeighborNodeInOpen(mapInfo,current, x + 1, y - 1, OBLIQUE_VALUE);
			// 右下
			addNeighborNodeInOpen(mapInfo,current, x + 1, y + 1, OBLIQUE_VALUE);
			// 左下
			addNeighborNodeInOpen(mapInfo,current, x - 1, y + 1, OBLIQUE_VALUE);
		}
	

		/**
		 * 添加一个邻结点到open表
		 */
		private void addNeighborNodeInOpen(MapInfo mapInfo,Node current, int x, int y, int value)
		{
			if (canAddNodeToOpen(mapInfo,x, y))
			{
				Node end=mapInfo.end;
				Coord coord = new Coord(x, y);
				int G = current.G + value; // 计算邻结点的G值
				Node child = findNodeInOpen(coord);
				if (child == null)
				{
					int H=calcH(end.coord,coord); // 计算H值
					if(isEndNode(end.coord,coord))
					{
						child=end;
						child.parent=current;
						child.G=G;
						child.H=H;
					}
					else
					{
						child = new Node(coord, current, G, H);
					}
					openList.add(child);
				}
				else if (child.G > G)
				{
					child.G = G;
					child.parent = current;
					openList.add(child);
				}
			}
		}
	

		/**
		 * 从Open列表中查找结点
		 */
		private Node findNodeInOpen(Coord coord)
		{
			if (coord == null || openList.isEmpty()) return null;
			for (Node node : openList)
			{
				if (node.coord.equals(coord))
				{
					return node;
				}
			}
			return null;
		}
	

	

		/**
		 * 计算H的估值：“曼哈顿”法，坐标分别取差值相加
		 */
		private int calcH(Coord end,Coord coord)
		{
			return Math.abs(end.x - coord.x)
					+ Math.abs(end.y - coord.y);
		}
		
		/**
		 * 判断结点是否是最终结点
		 */
		private boolean isEndNode(Coord end,Coord coord)
		{
			return coord != null && end.equals(coord);
		}
	

		/**
		 * 判断结点能否放入Open列表
		 */
		private boolean canAddNodeToOpen(MapInfo mapInfo,int x, int y)
		{
			// 是否在地图中
			if (x < 0 || x >= mapInfo.width || y < 0 || y >= mapInfo.hight) return false;
			// 判断是否是不可通过的结点
			if (mapInfo.maps[y][x] == BAR) return false;
			// 判断结点是否存在close表
			if (isCoordInClose(x, y)) return false;
	

			return true;
		}
	

		/**
		 * 判断坐标是否在close表中
		 */
		private boolean isCoordInClose(Coord coord)
		{
			return coord!=null&&isCoordInClose(coord.x, coord.y);
		}
	

		/**
		 * 判断坐标是否在close表中
		 */
		private boolean isCoordInClose(int x, int y)
		{
			if (closeList.isEmpty()) return false;
			for (Node node : closeList)
			{
				if (node.coord.x == x && node.coord.y == y)
				{
					return true;
				}
			}
			return false;
		}
	}
```

AVL树
1发明者G.M.Adelson-Velsky和Evgenii Landis
2Balance Fcator（平衡因子）：
是它的左子树的高度减去它的右子树的高度（有时相反）。
balance factor = ｛-1,0,1｝
3通过旋转操作来进行平衡（四种）
  左旋；右旋；左右旋；右左旋
不足：结点需要存储额外信息、且调整次数频繁

红黑树Red-black Tree
红黑树是一种近似平衡的二叉搜索树，它能够确保任何一个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树：
每个结点要么是红色，要么是黑色；
根结点是黑色；
每个叶结点（NIL结点，空结点）是黑色的；
不能有相邻接的两个红色结点；
从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。

对比：
1.AVL树比红黑树提供了更快的查询；
2.红黑树提供了更快的插入和删除操作，因为AVL树的旋转操作会更多一些；
3.AVL树要存的额外信息更多，需要用更多的内存，附加在每个结点里面来存这些额外的信息，而红黑树要的信息非常的少，只要一个bit来存0和1表示黑或者是红；
4.红黑树是用在一些高级语言的库里面，比如说Java或者C++的那些map，set，DateBase里面的话一般是用AVL树。






