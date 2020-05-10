//一、分治的解法：
class Solution {
    public int majorityElement(int[] nums) {
        return majorityElementDef(nums, 0, nums.length-1);
    }

//获得区间内众数的递归函数
    private int majorityElementDef(int[] nums, int l, int r) {

        if (l == r) {
            return nums[l];
        }

        int mid = (r-l)/2 + l;
        int leftmajority = majorityElementDef(nums, l, mid);
        int rightmajority= majorityElementDef(nums, mid+1, r);

        if (leftmajority == rightmajority) {
            return leftmajority;
        }

        int leftCount = countMethod(nums, leftmajority, l, r);
        int rightCount = countMethod(nums, rightmajority, l, r);

        return leftCount > rightCount ? leftmajority : rightmajority;
    }
    
//计算元素在区间出现次数的方法
    private int countMethod(int[] nums, int num, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}

//二、排序的解法
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
