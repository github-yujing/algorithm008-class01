# 学习笔记

**动态规划 Dynamic Programming**
1."Simplifying a complicated problem by breaking it down into simpler sub-problems"  (in a recursive manner)
2.Divie & Conquer + Optimal substructure
分治 + 最优子结构
3.顺推形式：动态递推

**关键点**
动态规划和递归或者分治没有根本上的区别（关键看有无最优的子结构）；
拥有共性：找到重复子问题；
差异性：最优子结构、中途可以淘汰次优解

**高级DP复杂度来源**
1.状态拥有更多维度（二维、三维、或者更多甚至需要压缩）
2.状态方程更加复杂
3.本质上需要内功、逻辑思维、数学

**字符串**
Java和Python定义字符串后，字符串是不可变的；C++是可变的。

遍历字符串
java：
``` java
String x = "abbc";
for(int != 0; i < x.size(); ++i) {
    char ch = x.charAt(i);
}
for ch in x.toCharArray() {
    System.out.println(ch);
}
```
字符串比较

``` java
String x = "abb" ;
String y = "abb" ;
x == y  // -------> flase  比较地址
x.equals(y)  // -------> true
x.equalsgnoreCase(y)  // -------> true  忽略大写
```



**高级字符串算法**
1.Longest common sequence （最长子序列）

``` java
if (s1[i - 1] == s2[j - 1]) {
    dp[i][j] = dp[i -1][j - 1] +1
}
else {
	dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
}
```

    
2.Longest common substring （最长子串）

``` java
if (s1[i - 1] == s2[j - 1]) {
    dp[i][j] = dp[i -1][j - 1] +1
}
else {
	dp[i][j] = 0
}
```

    
3.编辑距离

```java 
if (s1[i] == s2[j]) {
	edit_dist[i][j] = edit_dist[i - 1][j -1]
}
else {
	edit_dist[i][j] = Math.min(edit_dist[i - 1][j - 1] + 1, edit_dist[i - 1][j] + 1, edit_dist[i][j - 1] + 1)
}
```

4.回文串
首先定义P(i, j)：
P(i, j) = true   //s[i, j]是回文串
P(i, j) = false   //s[i, j]不是回文串
接下来
P(i, j) = (P(i +1, j - 1) && S[i] == S[j])

5.不同的子序列
dp[i][j]代表T前i字符串可以由s前j字符串组成最多个数。
当S[j] == T[i] , dp[i][j] = dp[i - 1][j - 1] + dp[i][j -1]
当S[j] != T[i] , dp[i][j] = dp[i][j - 1]


**字符串匹配算法**
1.暴力法

2.Rabin-Karp算法
用子串的哈希值作对比，如果一致再作暴力匹配。
为了避免挨个字符对目标字符串和子串进行比较，我们可以尝试一次性判断两者是否相等。因此，我们需要一个好的哈希函数。通过哈希函数，我们可以算出子串的哈希值，然后将它和目标字符串中的子串的哈希值进行比较。这个新方法在速度上比暴力法有显著提升。
算法思想：
a.假设子串的长度为M（pat），目标字符串的长度为N（txt）
b.计算子串的hash值hash_pat
c.计算目标字符串txt中每个长度为M的子串的hash值（共需要计算N - M +1次）
d.比较hash值，如果hash值不同，字符串必然不匹配；如果hash值相同，还需要使用朴素算法再次判断。

3.KMP算法
算法思想是，当子串与目标字符串不匹配时，其实你已经知道了前面已经匹配成功那一部分的字符（包括子串与目标字符串）。KMP算法的想法是，设法利用这个已知信息，不要把“搜索位置”移回已经比较过的位置，继续把它向后移，这样就提高了效率。
