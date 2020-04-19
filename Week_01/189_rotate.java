class Solution {
    public void rotate(int[] nums, int k) {
        int start = 0, next = 0, current = 0, temp1 = 0, temp2 = 0, count = 0;
        for (; count < nums.length; start++) {
            current = start;
            temp1 = nums[start];
            do {
                next = (current + k) % nums.length;
                temp2 = temp1;
                temp1 = nums[next];
                nums[next] = temp2;
                current = next;
                count++;
            }
            while(start != current);
        }
    }
}