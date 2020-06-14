# 学习笔记

**位运算**
机器里的数字表示方式和存储格式就是二进制。

**位运算符**
|  含义                                          | 运算符  | 示例 |
| ---                                               |     ---     | ---                    |
| 左移                                            |    <<     | 0011 => 0110 |
| 右移                                            |     >>    | 0110 => 0011 |
| 按位或                                        |     l        | 0011 l 1011 => 1011  |
| 按位与                                        |     &      | 0011 1011=> 0011  |
| 按位取反                                     |     ~      | 0011 => 1100  |
| 按位异或（相同为零不同为一） |     ^      | 0011 ^ 1011 => 1000  |

**异或-XOR**
异或：相同为0，不同为1。也可用“不进位加法”来理解。
异或操作的一些特点：
x ^ 0 = x
x ^ 1s = ~x  //注意1s = ~0
x ^ (~x) = 1s
x ^ x =0
c = a ^ b  =>  a ^ c = b , b ^ c = a //交换两个数
a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c //associative

**指定位置的位运算**
1.将x最右边的n位清零： x & (~0 << n)
2.获取x的第n位值（0或者1）：(x >> n) & 1
3.获取x的第n位的幂值： x & (1 << n)
4.仅将第n位置为1：x l (1 << n)
5.仅将第n位置为0：x & (~(1 << n))
6.将x最高位至第n位（含）清零：x & ((1 >> n) - 1)

**实战位运算要点**
判断奇偶：
x % 2 == 1  ——>  x & 1 == 1
x % 2 == 0  ——>  x & 1 == 0

x >> 1  ——>  x / 2
即：x = x / 2;  ——>  x = x >> 1;
		mid = (left + right) / 2 ;  ——> mid = (left + right) >> 1;

X = X & (X - 1) 清零最低位的1

X & -X   ——>  得到最低位的1

X & ~X   ——> 0


**布隆过滤器**
布隆过滤器（Bloom Filter）的核心实现是一个超大的位数组和几个哈希函数。假设位数组的长度为m，哈希函数的个数为k。
![enter description here][1]
以上图为例，具体的操作流程：假设集合里面有3个元素{x, y, z}，哈希函数的个数为3。首先将位数组进行初始化，将里面每个位都设置位0。对于集合里面的每一个元素，将元素依次通过3个哈希函数进行映射，每次映射都会产生一个哈希值，这个值对应位数组上面的一个点，然后将位数组对应的位置标记为1。查询W元素是否存在集合中的时候，同样的方法将W通过哈希映射到位数组上的3个点。如果3个点的其中有一个点不为1，则可以判断该元素一定不存在集合中。反之，如果3个点都为1，则该元素可能存在集合中。注意：此处不能判断该元素是否一定存在集合中，可能存在一定的误判率。可以从图中可以看到：假设某个元素通过映射对应下标为4，5，6这3个点。虽然这3个点都为1，但是很明显这3个点是不同元素经过哈希得到的位置，因此这种情况说明元素虽然不在集合中，也可能对应的都是1，这是误判率存在的原因。

``` undefined
布隆过滤器添加元素
```
将要添加的元素给k个哈希函数
得到对应于位数组上的k个位置
将这k个位置设为1

``` undefined
布隆过滤器查询元素
```
将要查询的元素给k个哈希函数
得到对应于位数组上的k个位置
如果k个位置有一个为0，则肯定不在集合中
如果k个位置全部为1，则可能在集合中

BloomFilter布隆过滤器适用案例有：
1.比特币网络；
2分布式系统（Map-Reduce）—— Hadoop、search engine
3.Redis 缓存
4.垃圾邮件、评论等的过滤

**LRU Cache**
两个要素：大小、替换策略
Hash Table + Double LinkedList
O(1)查询；O(1)修改、更新

替换策略
LFU -- least frequently used
LRU -- least recently used


**排序**
1.比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(NLOGN),因此也称为非线性时间比较类排序。
交换排序：冒泡排序、快速排序
插入排序：简单插入排序、希尔排序
选择排序：简单选择排序、堆排序
归并排序：二路归并排序、多路归并排序

2.非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。
计数排序、桶排序、基数排序

``` 
初级排序 - O(n ^ 2)
```
1.选择排序（Selection Sort）：
每次找最小值，然后放到待排序数组的起始位置。

2.插入排序（Insertion Sort）：
从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

3.冒泡排序（Bubble Sort）：
嵌套循环，每次查看相邻的元素如果逆序，则交换。

``` 
高级排序 - O(n * longn)
```
1.快速排序（Quick Sort）
数组取标杆pivot，将小元素放pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排；以达到整个序列有序
代码模版
``` java
public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}

static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;  
    for (int i = begin; i < end; i++) {
        if (a[i] < a[pivot]) {
            int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
}
```

2.归并排序（Merge Sort） -- 分治
a.把长度为n的输入序列分成两个长度为n/2的子序列；
b.对这两个子序列分别采用归并排序；
c.将两个排序好的子序列合并成一个最终的排序序列。
代码模版
``` java
public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid)   temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
    }
```

归并和快排具有相似性，但步骤顺序相反
归并：先排序左右子数组，然后合并两个有序子数组
快排：先调配出左右子数组，然后对于左右子数组进行排序。

3.堆排序（Heap Sort） - 堆插入O(logn)
a.数组元素依次建立小顶堆
b.依次取堆顶元素，并删除
代码模版
``` java
static void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2；
    int largest = i;

    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }

    if (largest != i) {
        int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
        heapify(array, length, largest);
    }
}

public static void heapSort(int[] array) {
    if (array.length == 0) return;

    int length = array.length;
    for (int i = length / 2-1; i >= 0; i-) 
        heapify(array, length, i);

    for (int i = length - 1; i >= 0; i--) {
        int temp = array[0]; array[0] = array[i]; array[i] = temp;
        heapify(array, i, 0);
    }
}


``` 
特殊排序  -  O(n)
```
计数排序（Counting Sort）
计数排序要求输入的数据必须是有确定范围的整数，将输入的数据值转化为键存储在额外开辟的数组空间中；然后依次把计数大于1的填充回原数组

桶排序（Bucket Sort）
假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。

基数排序（Radix Sort）
基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。
