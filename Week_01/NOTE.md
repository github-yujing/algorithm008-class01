学习笔记
参加了算法训练营后才真正知道想转行做程序员自己还有很多的不足：
第一是很少使用编程语言写代码，导致敲代码很不熟练，对IDE的使用就更是只当做记事本一样来使用。
第二是因为不是计算机专业出身，数据结构完全没学过，链表、队列、栈都是通过训练营才学习到的，还有对代码时间和空间复杂度的分析等等都是以前所不知道的不足之处。
第三是学习算法的方式“五毒神掌”，学习的思路真的很对，以前做题都是靠自己琢磨出来，现在做题自己没有思路就赶紧看题解，找到一个最好的思路，然后再把代码默写下来，同一道题做多几次，留有影响，遇到同类型题目能做一下子有思路就非常棒。
最后是英语一定要学好!!
本周学到的内容：
1.数组Array：时间复杂度Prepend  O(1)、 Append  O(1)、Lookup  O(1)、Insert  O(n)、Delete  O(n)
2.链表Linked list：时间复杂度Prepend  O(1)、 Append  O(1)、Lookup  O(n)、Insert  O(1)、Delete  O(1) ；增加索引可以提高链表线性查找效率；在LRU Cache有应用。
3.跳表Skip List：在Redis有应用。
4.栈Stack：先入后出，后进先出；时间复杂度添加、删除皆为O(1)，查询为O(n)。
5.队列Queue：先进先出；时间复杂度添加、删除皆为O(1)，查询为O(n)。
6.双端队列Deque：两端可以进出的Queue；时间复杂度插入和删除都是O(1)操作，查询是O(n)。
7.优先队列Priority Queue：时间复杂度插入操作O(1)，取出操作O(longN) 按照元素的优先级取出；底层具体实现的数据结构较为多样和复杂：heap。
8.Stack、Queue、Deque、Priority Queue的工程实现。


用add first或add last这套新的API改写Deque的代码如下：
public void class Demo {
    Deque<String> deque = new LinkedList<String>();
        deque.addFirst('a');
        deque.addFirst('b');
        deque.addFirst('c');
        deque.addLast('a');
        deque.addLast('b');
        deque.addLast('c');
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size()>0) {
        System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
}


分析Queue和Priority Queue的源码：

Queue是Collection的子类，定义有add、offer、remove、poll、element、peek类方法，应该都是继承自父类，并没有重写类方法。

Priority Queue是AbstractQueue的子类，调用了Serializable接口，由于刚学Java，对里面的定义很多都搞不清楚，看不懂源码里面的构造方法；看懂了peek是通过先判断是否有使用空间，有则返回数组的首位数据，没有则返回null；poll先判断是否有使用空间，有则返回数组的首位数据，然后清除该数据，没有则返回null；size返回的是已使用空间的计数值；remove有3个类方法，根据参数不同，作用也有所差异，这3段代码没看懂，不能描述出具体功能。