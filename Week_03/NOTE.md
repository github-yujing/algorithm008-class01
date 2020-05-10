# 学习笔记

**树的面试题解法一般都是递归**

``` undefined
1.节点的定义：它的节点和树本身的数据结构的定义就是用递归的方式来进行的。
2.重复性（自相似性）：不仅是树本身，二叉树以及二叉搜索树，它在定义它的数据结构和它的算法特性的时候，也是有所谓的重复性，也就是自相似性。
```


**递归Recursion**

``` undefined
递归相当于循环，通过函数体来进行的循环。

递归类比盗梦空间:
向下进入到不同梦境中；向上又回到原来一层。
通过声音同步回到上一层。
每一层的环境和周围的人都是一份拷贝、主角等几个人穿越不同层级的梦境（发生和携带变化）。
```

代码模版
``` nimrod
public void recur(int level, int param)  {
	//terminator	递归终结条件
	if(level > MAX_LEVEL) {
	//process result
	return;
	}
	
	//process current logic  处理当前层逻辑
	process(level, param);

	//drill down  下探到下一层
	recur(level: level + 1, newParam);
	
	//restore current status  清理当前层
}
```

	思维要点
    1.不要人肉进行递归（最大误区）
    2.找到最近最简单方法，将其拆解成可重复解决的问题（重复子问题）
    3.数学归纳法思维

	分治和回溯本质上就是递归，只不过是递归中的一个细分类，可以认为是一种特殊的递归或者较为复杂的递归。强调一点，碰到问题就找重复性，重复性有最近重复性、最优重复性；最优重复性就是动态规划，最近重复性就分为分治和回溯等。

**分治**

``` pf
把一个复杂问题分解为多个重复子问题。
比递归多一步，在drill down和revert state中间再加一步，就是把这些drill down得到的这些子结果要合并在一起，并返回回去。
```
分治代码模板：
``` nimrod
public void  divide_conquer(problem, param1, param2, ...) {

//recursion terminator 
if (!problem) {
print_result;
return;
}

//prepare data 
data = prepare_data(problem) 
subproblems = split_problem(problem, data) 

//conquer subproblems 
subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
…

//process and generate the final result 
result = process_result(subresult1, subresult2, subresult3, …)

//revert the current level states
}
```
**回溯**

``` undefined
不断地在每一层中去尝试，每一层有不同的办法。
回溯代码模板同泛型递归。
```
