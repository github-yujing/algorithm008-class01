# **学习笔记**
**学习算法后的感触：**
1.人肉递归低效，很累
2.找到最近最简单方法，将其拆解成可重复解决的问题
3.数学归纳法思维（抵制人肉递归的诱惑）
本质：寻找重复性，因为计算机指令集只有if else判断、for循环、递归。

**动态规划Dynamic Programming**
1.”Simplifying a complicated problem by breaking it down into simpler subproblems” （in a recursive manner）
指的是将一个复杂的问题，把它分解成简单的子问题（用一种递归的方式）
2.Divide & Conquer + Optimal substructure 
	分治+最优子结构

**关键点**
动态规划和递归或者分治没有根本上的区别（关键是看有无最优的子结构）
共性：找到重复子问题
差异性：最优子结构、中途可以淘汰次优解。
最优子结构：opt[n] = best_of(opt[n-1], opt[n-2], …)
存储中间状态：opt[i]
递推公式（美其名曰：状态转移方程或者DP方程）
	Fib：opt[i] = opt[n-1] + opt[n-2]
	二维路径：opt[i,j] = opt[i+1][j] +opt[i][j+1] （且判断a[i][j]是否为空地）
